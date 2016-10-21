( function () {
  angular
  .module('flix')
  .controller('SignUpController',SignUpController);
  
  SignUpController.$inject=['userSignupService'];
  function SignUpController (userSignupService) {
    
    var signupVm = this;
    signupVm.signup=signup;
    
    function  signup(user) {
    
      userSignupService.signup(user)
      .then((function(resp){
        console.log(resp);
      }),(function (err) {
        console.log(err);
        
      } ));
    }
    
    init();
    
    function init () {
      console.log("signup controller initialized");
    }
  }
  
})();