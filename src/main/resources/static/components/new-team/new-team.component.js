'use strict'
angular.module('newTeam').component('newTeam', {
	templateUrl : '../components/new-team/new-team.template.html',
	controller : function NewTeamController($http, $scope, testService) {
		$scope.url = testService.getUrl();

		$scope.id = $scope.url.id;
		$scope.role = $scope.url.role;

		var self = this;

		self.rapidTeams = [ {
			"id" : 1
		}, {
			"id" : 2
		}, {
			"id" : 3
		} ];
	}
});