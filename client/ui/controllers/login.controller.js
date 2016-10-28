( function () {
  angular
  .module('flix')
  .controller('LoginController',LoginController);
  
  LoginController.$inject=['loginService','$location','$rootScope'];
  function LoginController (loginService,$location,$rootScope,$q) {
    
    var loginVm = this;
    loginVm.authenticate=authenticate;
    init();
    
    
    function authenticate (loginVm){
      loginService.authenticate()
    .then(function (response) {
      console.log(response.data);
      $location.path("/movies");
    },function (err) {
      q.error(err);
    })
    function init () {
      $rootScope.loggedIn=false;
      console.log("login controller initialized");
    }
  }}
  
})();




// {
//     if (loginService.authenticate(loginVm)) {
//       console.log(loginService.authenticate(loginVm));          $rootScope.loggedIn=true;
//       $location.path("/movies");
//     }
//
// }
