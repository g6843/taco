'use strict'
angular.
  module('notificationSidebar').
  component('notificationSidebar', {
    templateUrl: '../components/notification-sidebar/notification-sidebar.template.html',
    controller: function notificationSidebarController($http, $scope,testService, notificationService, ngToast){
    	
    	
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
    	var dd = myDate.getDate();
		var mm = myDate.getMonth()+1; //January is 0!
		var yyyy = myDate.getFullYear();

		if(dd<10) {
		    dd = '0'+dd
		} 

		if(mm<10) {
		    mm = '0'+mm
		} 

		var today = mm + '/' + dd + '/' + yyyy;
		var timeStamp = today;
    	
      $scope.messages.push({text : out.message, timeStamp: timeStamp, receivedDate: $scope.receivedDate});
    ngToast.show(out.message, 'top', 3000);
    	});
    	$scope.currentPage = 0;
        $scope.pageSize = 4;
        $scope.numberOfPages=function(){
            return Math.ceil($scope.messages.length/$scope.pageSize);                
        }
        
        
        
    	/*$scope.notificationClick = function(message){
    		alert(message.text);
    	}*/
    	
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
    		/*$scope.messages.splice(index, 1);*/
    	}
    	
    	$scope.reject = function(index){
 		alert("Rejected");
    	$scope.messages.splice(index, 1);

    	}

  
    }
 
  });

    	
