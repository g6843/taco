'use strict';

// Define the `myApp` module
angular.module(
		'myApp',
		[ 'ngRoute', 'coursesList', 'courseDetail', 'rapidTeams', 'newTeam',
		'createTeam', 'userProfile', 'chart.js', 'customZingchart','ng-toast',
				'mainPage', 'notificationService','notificationSidebar', 'notificationPanel','notificationCount','tacourseDetail','taCharts','rapteamDetail', 'welcomeUser','ngAnimate',])
		.factory('testService', function() {
			var myurl = null;
			return {
				getUrl : function() {
					return myurl;
				},
				setUrl : function(value) {
					myurl = value;
				}
			}
		}).factory('notificationService', function($q, $timeout) {
			var service = {}, listener = $q.defer(), socket = {
				client : null,
				stomp : null
			}, messageIds = [];

			service.RECONNECT_TIMEOUT = 30000;
			service.SOCKET_URL = "/gs-guide-websocket";
			service.CHAT_TOPIC = "/topic/tasks";
			service.CHAT_BROKER = "/app/taco";

			service.receive = function() {
				return listener.promise;
			};

			service.send = function(message) {
				socket.stomp.send(service.CHAT_BROKER, {
					priority : 9
				}, JSON.stringify(message))
			};

			var reconnect = function() {
				$timeout(function() {
					initialize();
				}, this.RECONNECT_TIMEOUT);
			};

			var getMessage = function(data) {
				var message = JSON.parse(data), out = {};
				out.message = message.message;
				out.time = message.time;
				return out;
			};

			var startListener = function() {
				socket.stomp.subscribe(service.CHAT_TOPIC, function(data) {
					listener.notify(getMessage(data.body));
				});
			};

			var initialize = function() {
				socket.client = new SockJS(service.SOCKET_URL);
				socket.stomp = Stomp.over(socket.client);
				socket.stomp.connect({}, startListener);
				socket.stomp.onclose = reconnect;
			};

			initialize();
			return service;
		})
		.filter('startFrom', function() {
		    return function(input, start) {
		        start = +start; 
		        return input.slice(start);
		    }
		})
.factory('ngToast', ['$document', '$interval', '$timeout', '$rootScope', function ($document, $interval, $timeout, $rootScope) {

    return {
        show : function(text, position, interval) {

            if (typeof $rootScope.toastInterval != 'undefined') return false;

            $rootScope.toastInterval = true;

            interval = ((typeof interval == "undefined") ? 2500 : interval);

            var divider = $document[0].createElement('div');
            divider.id = "toast";
            divider.style.minHeight= "20px";
            divider.style.width = "250px";
            divider.style.color = "#fff";
            //divider.style.borderBottomLeftRadius = "6px";
            //divider.style.borderTopRightRadius = "6px";
            divider.style.textAlign = "center";
            divider.style.opacity = "0";
            divider.style.padding = "5px";
            divider.style.position = "fixed";//"absolute";
            divider.style.fontFamily = '"Helvetica Neue Light", "HelveticaNeue-Light",'+
                ' "Helvetica Neue", Calibri, Helvetica, Arial, Sans-Serif';
            divider.style.background = "rgba(0,0,0,0.8)";

            if (position=='top') {
                divider.style.top = "50px";
            } else {
                divider.style.top = (screen.availHeight - (50 + 100)) +"px";
            }

            divider.style.left = (screen.width - (250 + 70)) +"px";
            divider.style.zIndex = "100";
            var textNode = $document[0].createTextNode(text);
            divider.appendChild(textNode);

            divider.addEventListener("click", function() {
                opacity = 1;
                promised = 0;
                var hide = $interval(function () {
                    promised += 25;
                    opacity -= 0.1;
                    divider.style.opacity = opacity;
                    divider.style.top = parseInt(divider.style.top.replace("px", "")) - 2+"px";

                    if (promised > 250)  {
                        $interval.cancel(hide);
                        opacity = 0;
                        promised = 0;
                        var elem = document.getElementById("toast");
                        elem.parentNode.removeChild(elem);
                        delete $rootScope.toastInterval;
                    }
                }, 25);
            });

            $document[0].body.insertBefore(divider, $document[0].body.firstChild);

            var promised = 0;
            var opacity = 0;

            var show = $interval(function () {
                promised += 25;
                opacity += 0.1;
                divider.style.opacity = opacity;

                divider.style.top = parseInt(divider.style.top.replace("px", "")) + 2+"px";

                if (promised> 250) $interval.cancel(show);
            }, 25);

            $timeout(function () {
                opacity = 1;
                promised = 0;
                var hide = $interval(function () {
                    promised += 25;
                    opacity -= 0.1;
                    divider.style.opacity = opacity;
                    divider.style.top = parseInt(divider.style.top.replace("px", "")) - 2+"px";

                    if (promised > 250)  {
                        $interval.cancel(hide);
                        opacity = 0;
                        promised = 0;
                        var elem = document.getElementById("toast");
                        elem.parentNode.removeChild(elem);
                        delete $rootScope.toastInterval;
                    }
                }, 25);

            }, interval);
        }
    }
}]);

angular.module('ng-toast', []);
angular.module("notificationService", []);