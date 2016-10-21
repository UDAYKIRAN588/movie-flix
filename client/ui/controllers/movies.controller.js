(function() {
  angular
    .module('flix')
    .controller('MoviesController', MoviesController);


  MoviesController.$inject = ['movieService'];

  function MoviesController(movieService) {

    var moviesVm = this;
    moviesVm.type = "All";
    moviesVm.genere = "ALl";
    moviesVm.genere = "ALl";
    moviesVm.show = show;
    moviesVm.path="views/movies2.tmpl.html";
    moviesVm.sort = [{
      rep: "Rating",
      param: "imdbRating"
    }, {
      rep: "Year",
      param: "Year"
    }, {
      rep: "User Rating",
      param: "imdbVotes"
    }]; 
    moviesVm.type = ['All','movie','series'];
    moviesVm.genere=['ALL','Animation','Action','Comedy'];
    moviesVm.filter={
      type:'ALL',
      genre:'ALL'
    };


    function show(movies) {
      
      console.dir(movies);
      console.log(moviesVm.filter.genre);
      if ((movies.Genre.includes(moviesVm.filter.genre))&&(movies.Type ==moviesVm.filter.type))
       { return true;} else 
        return false;
    }
  
    init();

    function init() {
      console.log("movies controller initialized");

      movieService.getAll()
        .then(function(movies) {
          console.log("movies successfull");
          console.log(movies);
          moviesVm.movies = movies;
        }, function(error) {
          console.log(error);
        })

    }
  }

})();