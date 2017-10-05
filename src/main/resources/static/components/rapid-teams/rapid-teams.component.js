'use strict'
angular.module('rapidTeams').component('rapidTeams', {
	templateUrl : '../components/rapid-teams/rapid-teams.template.html',
	controller : function RapidTeamsController($http, $scope, testService) {
		var self = this;

		$scope.url = testService.getUrl();
		$scope.id = $scope.url.id;
		$scope.role = $scope.url.role;

		$http.get('../data/professor.json').then(function(response) {
			self.professor = response.data;

			self.rapidTeams = self.professor.rapidTeams;
		});

	}
});