// Code goes here
(function () {
  'use strict';
  
  angular.module("flix",['ngRoute','ngMessages'])
  .config(moviesModule);
  
  //userModule.$inject=['$'];
    function moviesModule($routeProvider) {
      
 
        $routeProvider
        .when('/movies',{
          resolve:{
            check:function ($location,$rootScope){
              if(!$rootScope.loggedIn)
              {
                $location.path("/login");
              }
            }
          },
          templateUrl:'views/movies.tmpl.html',
          controller:'MoviesController',
          controllerAs:'moviesVm'
        })
        .when('/user', {
          templateUrl:'views/user.tmpl.html',
          controller:'UserController',
          controllerAs:'userVm'
          
        })
        .when('/loginin', {
          templateUrl:'views/login.tmpl.html',
          controller:'LoginController',
          controllerAs:'loginVm'
          
        })
        .when('/signup', {
          templateUrl:'views/signup.tmpl.html',
          controller:'SignUpController',
          controllerAs:'signupVm'
          
        })
        .otherwise('/loginin');
    }
  
  
})();
