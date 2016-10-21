( function () {
  angular
  .module('flix')
  .controller('LoginController',LoginController);
  
  LoginController.$inject=['loginService','$location','$rootScope'];
  function LoginController (loginService,$location,$rootScope) {
    
    var loginVm = this;
    loginVm.authenticate=authenticate;
    init();
    
    
    function authenticate () {
        if (loginService.authenticate(loginVm)) {
          console.log(loginService.authenticate(loginVm));          $rootScope.loggedIn=true;
          $location.path("/movies");
        }
        
    }
    function init () {
      $rootScope.loggedIn=false;
      console.log("login controller initialized");
    }
  }
  
})();