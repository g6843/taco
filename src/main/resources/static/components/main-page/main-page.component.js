'use strict'
angular.module('mainPage').component(
		'mainPage',
		{
			templateUrl : '../components/main-page/main-page.template.html',
			controller : function MainPageController($location, $http, $scope,
					testService) {
				/**
				 * Get role and id information for the logged-in user
				 */
				
				if ($location.path().includes("id")) {
					$scope.path = $location.path();
					
					$scope.id = $scope.path.substring($scope.path.indexOf("id/")+3, $scope.path.length);
					$scope.path = $scope.path.substring(0, $scope.path.indexOf("/id"));
					
					console.log($scope.path);
					
									var url = {
					role : $scope.path.substring(1, $scope.path.length), id: $scope.id};
					testService.setUrl(url);
					$location.path($scope.path);
					console.log("url");
					console.log(url.role);
					console.log(url.id);
					localStorage.setItem("id", url.id);
					localStorage.setItem("role", url.role);
					
					$scope.init = function(name)
					  {
					    $scope.id = name;
					    console.log("=====" + name);
					  };
				} else if(!$location.path().includes("role")) {
					$location.path(localStorage.getItem("role"));
				}
				
				

			}
		});