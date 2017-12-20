(function(){

  var app = angular.module('springboxui', []);
  app.controller('CatalogController', ["$http", function($http) {
	    var self=this;
	    self.movies=[];
	    $http.get('/movies').then( function(response){
	    	self.movies=response.data;
	    }, function(errResponse) {
	    	console.error('Error while getting movies')
	    });
	    }]);
  app.controller('PanelController', function() {
	    this.tab=1;
	    this.isSelected = function(tab) {
	    	return this.tab === tab;
	    }
	    });
  app.controller('ReviewController', function() {
	    this.review={};
	    this.addReview=function(movie) {
	    	//Add review to movie
	    	this.review={};
	    }
	    });
})();