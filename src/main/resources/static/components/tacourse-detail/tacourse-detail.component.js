'use strict'
angular.module('tacourseDetail').component('tacourseDetail', {
	templateUrl : '../components/tacourse-detail/tacourse-detail.template.html',
	controller : function TacourseDetailController($routeParams, $http, $scope, notificationService, testService) {
		this.courseId = $routeParams.courseName;
		var self = this;
		this.userId = testService.getUrl().id;
		$scope.currentPage = 0;
	    $scope.pageSize = 10;
	    $scope.totalPages = 0;
	    $scope.pagedData = []; 
	    
		$http.get('../data/courses.json').then(function(response) {
			self.courses = response.data;

			/** Course Information * */
			for (var i = 0; i < self.courses.length; i++) {
				if (self.courses[i].id == self.courseId) {
					self.course = self.courses[i];
					break;
				}
			}

			/** TA names from TA emails * */
			/** make a post request to send the course id here and get TA names * */

		});
		$scope.tasks = [];
		var backup;
		/** get tasks json from server for this course * */
		// send courseId
		$http.get('../data/courseTaTasks.json', {
			params : {
				courseName: self.courseId,
				userId: self.userId
			}
		}).then(function(response) {
			$scope.tasks = response.data;
			  backup=angular.copy($scope.tasks);

			for (var i = 0; i < $scope.tasks.length; i++) {
				$scope.tasks[i].editable = false;
				if($scope.tasks[i].doneHours>0){
					$scope.tasks[i].status="Started";
				}
				if($scope.tasks[i].doneHours==$scope.tasks[i].hours){
					$scope.tasks[i].status="Completed";
				}
			}
			
			$scope.totalPages = Math.ceil(($scope.tasks).length/$scope.pageSize);
		    $scope.pagedData = $scope.tasks;
		});
		/** * */

		$scope.edit = function(index) {
			index = index + $scope.pageSize * $scope.currentPage;
			$scope.entity = $scope.tasks[index];
			$scope.entity.index = index;
			$scope.entity.editable = true;
		}

		$scope.deleteFunction = function(index) {
			index = index + $scope.pageSize * $scope.currentPage;
			$scope.tasks.splice(index, 1);
		}

		$scope.message = {};
		$scope.save = function(index) {
            if($scope.tasks[index].doneHours<$scope.tasks[index].hours && $scope.tasks[index].doneHours!== backup[index].doneHours){
			var date = new Date();
			index = index + $scope.pageSize * $scope.currentPage;
			$scope.tasks[index].editable = false;
     $scope.myMessage = $scope.tasks[index].doneHours + " hour(s) are added to " + $scope.tasks[index].name +" task "; 
		$scope.tasks[index].status="Started";	
				$scope.message = {message: $scope.myMessage,
						time: date.getTime()};
				notificationService.send($scope.message);

		    	}
		    	else if($scope.tasks[index].doneHours>$scope.tasks[index].hours){
		    		alert("Done Hours can not be more than Assigned hours! Please reenter the correct hours");}
		    	else if ($scope.tasks[index].doneHours==$scope.tasks[index].hours){
		    		var date = new Date();
            		index = index + $scope.pageSize * $scope.currentPage;
            		$scope.tasks[index].editable = false;
		    		$scope.myMessage = $scope.tasks[index].doneHours + " hour(s) are added to " + $scope.tasks[index].name +" task ";
		    		$scope.tasks[index].status="Completed";
					$scope.message = {message: $scope.myMessage,
							time: date.getTime()};
					notificationService.send($scope.message);
		    	}
		    	else 
		    		$scope.tasks[index].editable = false;
            
       /*     if ($scope.tasks[index].status !== backup[index].status) {
            	var date = new Date();
    			index = index + $scope.pageSize * $scope.currentPage;
            	$scope.tasks[index].editable = false;
    			$scope.myMessage =  $scope.tasks[index].name + " task status was modified from " + backup[index].status + " to "+ $scope.tasks[index].status;
    			$scope.message = {message: $scope.myMessage,
    					time: date.getTime()};
    			notificationService.send($scope.message);
    			
                }*/
    
			var saveTask = {
				      "name": $scope.tasks[index].name,
				      "taId": self.userId,
				      "hours": $scope.tasks[index].hours,
				      "doneHours" : $scope.tasks[index].doneHours,
				      "priority" : "low",
				      "status": "Started",
				    	  "courseName": self.courseId };
			
			var res = $http({
				url: '../data/saveTaTask.json',
				method: "POST",
				data: saveTask,
				headers: {'Content-Type': 'application/json'}
			}).success(function(data, status, headers, config) {
				$scope.messages = data;
			});
			
		
			
		}
		/** make sure you don't add field editable in json put/post * */
		/*$scope.add = function() {
			$scope.tasks.push({
				id : "",
				name : "",
				hours : "",
				priority : "",
				status : "",
				editable : true
			})
		}*/

		/** get TAs json from server for this course * */
		// Send information about this course -- courseid
		$http.get('../data/courseTAs.json', {
			params : {
				courseName : self.courseId
			}
		}).then(function(response) {
			$scope.tas = response.data;
		});

		$http.get('../data/allTAs.json').then(function(response) {
			$scope.allTas = response.data;
		});

		// Send information about this course -- courseid
		$http.get('../data/courseTAAvailability.json', {
			params : {
				courseName : self.courseId
			}
		}).then(function(response) {
			$scope.courseTasksTAHours = response.data;
		});

		$http.get('../data/priorities.json').then(function(response) {
			$scope.priorities = response.data;
		});

		$http.get('../data/status.json').then(function(response) {
			$scope.statuses = response.data;
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
		
		
		$scope.changePageSize = function(value){
			$scope.pageSize = value;
			$scope.totalPages = Math.ceil(($scope.tasks).length/$scope.pageSize);
		}
		$scope.pageButtonDisabled = function(dir) {
	    	if (dir == -1) {
				return $scope.currentPage == 0;
	    	}
			return $scope.currentPage >= ($scope.tasks).length/$scope.pageSize - 1;
	    }
		
		$scope.paginate = function(nextPrevMultiplier) {
		    $scope.currentPage += (nextPrevMultiplier * 1);
		    $scope.pagedData = ($scope.tasks).slice($scope.currentPage*$scope.pageSize);
		}
	}

});