'use strict'
angular.module('rapteamDetail').component('rapteamDetail', {
	templateUrl : '../components/rapteam-detail/rapteam-detail.template.html',
	controller : function RapteamDetailController($routeParams, $http, $scope) {
		this.courseId = $routeParams.rapidTeamId;
		var self = this;

		$http.get('../data/rapidTeams.json').then(function(response) {
			self.courses = response.data.courses;

			/** Rapid Team Information * */
			for (var i = 0; i < self.courses.length; i++) {
				if (self.courses[i].id == self.courseId) {
					self.course = self.courses[i];
					break;
				}
			}

		});
		$http.get('../data/rapidTeamTANames.json').then(function(response) {
			$scope.taNames = response.data;
		});

		/** get tasks json from server for this course * */
		// send courseId
		$http.get('../data/rapidTeamTasks.json').then(function(response) {
			$scope.tasks = response.data;

			for (var i = 0; i < $scope.tasks.length; i++) {
				tasks[i].editable = false;
			}
		});
		/** * */

		$scope.edit = function(index) {
			$scope.entity = $scope.tasks[index];
			$scope.entity.index = index;
			$scope.entity.editable = true;
		}

		$scope.deleteFunction = function(index) {
			$scope.tasks.splice(index, 1);
		}

		$scope.save = function(index) {
			$scope.tasks[index].editable = false;

		}
		/** make sure you don't add field editable in json put/post * */
		$scope.add = function() {
			$scope.tasks.push({
				id : "",
				name : "",
				hours : "",
				priority : "",
				status : "",
				editable : true
			})
		}

		/** get TAs json from server for this course * */
		// Send information about this course -- courseid
		$http.get('../data/rapidTeamTAs.json').then(function(response) {
			$scope.tas = response.data;
		});

		$scope.rowClicked = null;

		$scope.setTA = function(ta, index) {
			$scope.rowClicked = ta;
			
			$scope.allTas.splice(index, 1);
			
			// 
			var combinedCourseTA = {
				"ta" : ta,
				"courseId" : self.courseId
			};
			$http.post("../data/save1.json", combinedCourseTA);
		}
	}

});