angular.
  module('myApp').
  config(['$locationProvider' ,'$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/role/prof/courses/:courseName', {
          template: '<course-detail></course-detail>'
        }).
        when('/role/ta/rapidTeams/:rapidTeamId', {
            template: '<rapteam-detail></rapteam-detail>'
          }).
          when('/role/prof/rapidTeams/:rapidTeamId', {
              template: '<rapteam-detail></rapteam-detail>'
            }).
        when('/role/ta/courses/:courseName', {
        	template: '<tacourse-detail></tacourse-detail>'
        }). 
        when('/role/prof/newTeam/:rapidTeamId', {
            template: '<create-team></create-team>'
          }).
          when('/role/prof', {
        	  template: '<custom-zingchart></custom-zingchart>'
          }).
          when('/', {
        	  template: '<main-page></main-page>'
          }).
          when('/role/ta', {
        	  template: '<ta-charts></ta-charts>'
          });
      
    }
  ]);