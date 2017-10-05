'use strict'
angular.module('userProfile').component('userProfile', {
	templateUrl : '../components/user-profile/user-profile.template.html',
	controller : function UserProfileController($http, $scope, testService) {
		this.userId = testService.getUrl().id;
		
		console.log(self.userId);
		$http.get('../data/user.json', {
			params : {
				userId : localStorage.getItem("id")
			}
		}).then(function(response) {
			$scope.users = response.data;
			$scope.image = $scope.users.image;
			$scope.name = $scope.users.name;
			$scope.email = $scope.users.email;
		});
	}
});