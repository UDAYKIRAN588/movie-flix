(function () {
  'use strict';
  
  angular.module('flix').service('movieService',movieService);
  
  movieService.$inject=['$http','$q']
  function movieService($http,$q){
    var self = this;
    self.getAll=getAll;
    self.findOne=getDriver;
    self.remove=deleteDriver;
    self.update=updateDriver;
    
    function getAll() {
     return  $http.get('http://localhost:8081/movie-flex/api').then(function (response) {
       console.log("success");
       console.log(response.data);
        return response.data;
      },function (err) {
        console.log("error");
        console.log(err);
        $q.reject(err);
      });
    }
    
    function getDriver() {}
    function deleteDriver() {}
    function updateDriver() {}
  }
  
})();