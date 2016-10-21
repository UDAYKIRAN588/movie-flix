( function () {
  angular
  .module('flix')
  .controller('UserController',UserController);
  
  function UserController () {
    
    var signupVm = this;
    
    init();
    
    function init () {
      console.log("user controller initialized");
    }
  }
  
})();