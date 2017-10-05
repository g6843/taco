'use strict'
angular.
  module('customZingchart').
  component('customZingchart', {
    templateUrl: '../components/custom-zingchart/custom-zingchart.template.html',
    controller: function CustomZingchartController($http, $scope,testService, notificationService, ngToast){
    	
    	this.userId = testService.getUrl().id;
    	var self = this;
    	$scope.url = testService.getUrl();

    	$scope.role = $scope.url.role;

    	$scope.messages = [];
    	$scope.timeSince = function(milliSeconds) {
    		var seconds = Math.floor(milliSeconds / 1000);
    		var minutes = Math.floor(seconds / 60);
    		var hours = Math.floor(seconds / 3600);


    		if (hours >= 1) {
    			return hours + " hours ago";
    		}
    		if (minutes >= 1) {
    		  return minutes + " minutes ago";
    		}
    		return Math.floor(seconds) + " seconds ago";
    	}

    	notificationService.receive().then(null, null, function(out) {
    	$scope.receivedDate = new Date(parseInt(out.time,10));
    	var myDate = new Date();
    	var difference = myDate.getTime() - $scope.receivedDate.getTime();
    	var timeStamp = $scope.timeSince(difference);
    	
      $scope.messages.push({text : out.message, timeStamp: timeStamp, receivedDate: $scope.receivedDate}); 
    ngToast.show(out.message, 'top', 3000);
    	});
    	$scope.currentPage = 0;
        $scope.pageSize = 6;
        $scope.numberOfPages=function(){
            return Math.ceil($scope.messages.length/$scope.pageSize);                
        }
        
        
        
    	$scope.notificationClick = function(message){
    		alert(message.text);
    	}
    	
    	$scope.dropdownClicked = function(messages){
    		angular.forEach(messages, function(message){
    			var myDate = new Date();
    			var difference = myDate.getTime() - message.receivedDate.getTime();
    			message.timeStamp = $scope.timeSince(difference);
    		});
    	}
    	
    	$scope.accept = function(index){
    		alert("Accepted");
    		// send to server 
    		$scope.messages.splice(index, 1);
    		message.isRead = true;
    	}
    	
    	$scope.reject = function(){
    		alert("Rejected");
    		$scope.messages.splice(index, 1);
    		message.isRead = true;
    	}
    	
   $http.get('../data/dashboardData.json', {
		params : {
			userId : self.userId
		}
	}).then(function (response) {
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
        	                            
        	                          ],
        	        fillColor: "rgba(151,187,205,0.2)"
        	        }] ,
        		 options:{
        	 
        			legend: {
               		display: true,
                  position: 'top'
              }
    }
        	 }

         
         
         
   
  });
     
    
  
    }
 
  });

    	
