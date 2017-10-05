'use strict'
angular.module('notificationCount').component('notificationCount', {
	templateUrl : '../components/notification-count/notification-count.template.html',
	controller : function NotificationPanelController($http, $scope, testService, notificationService) {
		

		
		
		var self = this;

	$scope.notificationcount=0;
		notificationService.receive().then(null, null, function(out) {
		$scope.receivedDate = new Date(parseInt(out.time,10));
		$scope.notificationcount=$scope.notificationcount+1;

	  
	  });
	
	}
});



$(document).ready(function(){
$("#notificationLink").click(function () {
    $("#notificationcount").fadeOut("slow");

});
});
