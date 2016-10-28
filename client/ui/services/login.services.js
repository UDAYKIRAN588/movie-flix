(function () {
  'use strict';
  
  angular.module('flix').service('loginService',loginService);
  
  loginService.$inject=['$http','$q']
  function loginService($http,$q){
    var self = this;
    self.authenticate=authenticate;
    self.findOne=getDriver;
    self.remove=deleteDriver;
    self.update=updateDriver;
    
    function authenticate(loginVm) {
     return  $http.post('http://localhost:8080/movie-flex/api/user/auth/123', {
 "user_id":"123",
 "email":loginVm.email,
 "passwd":loginVm.password,
 "type":"User"
  }).then(function (response) {
       console.log(" User login success");
       console.log(response.data);
      },function (err) {
        console.log(" User error");
        console.log(err);
        $q.reject(err);
      });
    }
    
    function getDriver() {}
    function deleteDriver() {}
    function updateDriver() {}
  }
  
})();