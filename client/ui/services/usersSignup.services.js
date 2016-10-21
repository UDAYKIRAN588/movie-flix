(function () {
  'use strict';
  
  angular.module('flix').service('userSignupService',userSignupService);
  
  userSignupService.$inject=['$http','$q']
  function userSignupService($http,$q){
    var self = this;
    self.signup=signup;
  
    
    function signup(user) {
      console.log(user);
     return  $http.post('http://localhost:8081/movie-flex/api/user/registration',{
 "user_id":"sdsa ",
 "email":"johdadanc.2@gmail.com",
 "passwd":"dad",
 "firstName": "dad ",
 "type":"User",
 "lastName": "corner",
 "uda":"sdacsdcsd"
 }).then(function (response) {
       console.log(" success user created");
       return "syccess;";
      },function (err) {
        console.log("error");
        console.log(err);
        $q.reject(err);
      });
    }
  }
  }
  )();


