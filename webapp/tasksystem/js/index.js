'use strict';

// Declare app level module which depends on views, and components
var app =
    angular.module('tasksystem', [
        'ngRoute',
        'ui.grid',
        'ui.grid.pagination',
        'ui.grid.selection',
        'jsTree.directive',
        'tasksystem.login',
        'tasksystem.main'
    ]).
        config(['$routeProvider', function ($routeProvider) {
            $routeProvider.otherwise({redirectTo: '/login'});
        }]).config(function ($controllerProvider, $compileProvider, $filterProvider, $provide) {
            app.controller = $controllerProvider.register;
        }).factory('Auth', function ($http, $location, $q) {
            var logined;
            var user;
            return {
                setlogin: function (islogined) {
                    logined = islogined;
                },
                getUser: function () {
                    return user;
                },
                checklogin: function () {
                    var deferred = $q.defer();
                    if (!logined) {
                        CommonExamService.getCurrentUser({
                            callback: function (data) {
                                console.log("data==", data)
                                if (data == null) {
                                    $location.path('/tasksystem/login');
                                    deferred.reject(data);
                                } else {
                                    user = data;
                                    deferred.resolve(data);
                                }
                            }, errorHandler: function (message) {
                                $location.path('/tasksystem/login');
                                deferred.reject(message);
                            }
                        });
                    } else {
                        CommonExamService.getCurrentUser({
                            callback: function (data) {
                                user = data;
                                deferred.resolve(data);
                            }, errorHandler: function (message) {
                                $location.path('/tasksystem/login');
                                deferred.reject(message);
                            }
                        });
                    }
                    return deferred.promise;
                }
            }
        });
