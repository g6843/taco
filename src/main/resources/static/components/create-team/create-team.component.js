'use strict'
angular.module('createTeam').
component('createTeam', {
	templateUrl : '../components/create-team/create-team.template.html',
	controller : function CreateTeamController($window, $location, $http, $scope) {
		var self = this;
		$scope.tasks = [];
		
		$http.get('../data/courseTasksTAHours.json').then(function(response) {
			$scope.courseTasksTAHours = response.data;
			
			for (var i = 0; i < $scope.courseTasksTAHours.length; i++) {
				$scope.tasks[i].selected = false;
			}
		});
		
		$http.get('../data/taTasks.json').then(function(response) {
			$scope.tasks = response.data;
			
			for (var i = 0; i < $scope.tasks.length; i++) {
				$scope.tasks[i].editable = false;
			}
		});

		//this.orderProp = 'age';
		$http.get('../data/allTAs.json').then(function(response) {
		 	$scope.allTas = response.data;
		});
		
		$scope.edit = function(index) {
			$scope.entity = $scope.tasks[index];
			$scope.entity.index = index;
			$scope.entity.editable = true;
		}

		$scope.save = function(index) {
			$scope.tasks[index].editable = false;
		}
		
		$http.get('../data/status.json').then(function(response) {
		 	$scope.statuses = response.data;
		});
		
		$scope.updateSelection = function(position, entities) {
			  angular.forEach(entities, function(ta, index) {
			    if (position != index) 
			      ta.selected = false;
			  });
			}
		
		$scope.reset = function(){
			$scope.teamName = null;
			$scope.aboutTeam = null;
			$scope.currentTASelected = false;
		
			$scope.chooseDeptTASelected = false;
			angular.forEach($scope.courseTasksTAHours, function(ta) {
			      ta.selected = false;
			  });
		}
		
		$scope.save = function(){
			// server side request to save form data 
			alert("Record Saved")
			var str = $location.absUrl().split('/newTeam');
			$window.location.href = str[0];
		}
	}
});