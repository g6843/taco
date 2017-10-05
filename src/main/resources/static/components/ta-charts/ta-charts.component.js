'use strict'
angular.
  module('taCharts').
  component('taCharts', {
    templateUrl: '../components/ta-charts/ta-charts.template.html',
    controller: function CustomZingchartController($routeParams, $http, $scope, notificationService, testService){
    	/*this.courseId = $routeParams.courseName;*/
		var self = this;
		$scope.courseId=" ";
		$scope.alltasks = {};
		this.userId = testService.getUrl().id;
		$scope.currentPage = 0;
	    $scope.pageSize = 10;
	    $scope.totalPages = 0;
	    $scope.pagedData = [];
	    $scope.tasks = [];
	    var backup;
	    

		$scope.url = testService.getUrl();

		$scope.id = localStorage.getItem("id");
		$scope.role = $scope.url.role;

		/** get courses list from server for this person with this id * */
		$http.get('../data/professor.json', {
			params : {
				userId : $scope.id
			}
		}).then(function(response) {
			self.professor = response.data;

			self.courses = self.professor.courses;
		});
	    
	    
	    
	    
		/** get tasks json from server for this course * */
	     $http.get('../data/dashboardDataTa.json', {
	 		params : {
	 			userId : self.userId
	 		}
	 	})
	      .then(function (response) {
	          $scope.person = response.data;
	          $scope.courses=$scope.person.courses;       
	          $scope.chartParams=
	         	 {
	         		colours:[{ 
	         	          backgroundColor: [
	         	                            "#808080",
	         	                            "#808080",
	         	                            "#808080",
	         	                            "#808080"

	         	                          ]
	         	        }] ,
	         		 options:{
	         	 
	         			legend: {
	                		display: true,
	                   position: 'top'
	               }
	     }
	         	 }

	          
	          
	          
	    
	   });
	     $scope.tasks = [];
			var backup;
	     $scope.sendCourseId=function(course){
	    	 $scope.courseId=course
	    	 console.log($scope.courseId);
	    		$http.get('../data/courseTaTasks.json', {
	    			params : {
	    				userId: self.userId,
	    				courseName: $scope.courseId
	    				
	    			}
	    		}).then(function(response) {
	    			$scope.tasks = response.data;
	  			  backup=angular.copy($scope.tasks);

	    			for (var i = 0; i < $scope.tasks.length; i++) {
	    				$scope.tasks[i].editable = false;
	    			}
	    			
	    			console.log($scope.alltasks);
	    			$scope.totalPages = Math.ceil(($scope.tasks).length/$scope.pageSize);
	    		    $scope.pagedData = $scope.tasks;
	    		});
	    

		
		/** get tasks json from server for this course * */
		// send courseId
		console.log($scope.courseId);
	


		$scope.message = {};

		   $scope.editItem = function (index) {
			   $scope.tasks[index].editing = true;
		    }

		    $scope.doneEditing = function (index) {
		    	if($scope.tasks[index].doneHours<=$scope.tasks[index].hours && $scope.tasks[index].doneHours!=backup[index].doneHours){
			    	var date = new Date();
					index = index + $scope.pageSize * $scope.currentPage;
			    	$scope.tasks[index].editing = false;
			    	$scope.myMessage = $scope.tasks[index].doneHours + " hour(s) are added to " + $scope.tasks[index].name +" task ";
					$scope.message = {message: $scope.myMessage,
							time: date.getTime()};
					notificationService.send($scope.message);
			    	}
		    	 
			    	else if($scope.tasks[index].doneHours>$scope.tasks[index].hours){  
			    		alert("Done Hours can not be more than Assigned hours! Please reenter the correct hours");}
			    	else
			    		$scope.tasks[index].editing = false;	
			 

		    
					var saveTask = {
						      "name": $scope.tasks[index].name,
						      "taId": self.userId,
						      "hours": $scope.tasks[index].hours,
						      "doneHours" : $scope.tasks[index].doneHours,
						      "priority" : "low",
						      "status": "Started",
						    	  "courseName": $scope.courseId };
					
					var res = $http({
						url: '../data/saveTaTask.json',
						method: "POST",
						data: saveTask,
						headers: {'Content-Type': 'application/json'}
					}).success(function(data, status, headers, config) {
						$scope.messages = data;
					});
		    }
    	
		    }
    	
    	
    	
    	
    	

    

     
     
     
    } 
 
  });
