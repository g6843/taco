'use strict'
angular.module('coursesList').component('coursesList', {
	templateUrl : '../components/courses-list/courses-list.template.html',
	controller : function CoursesListController($http, $scope, testService) {
		var self = this;

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

	}
});