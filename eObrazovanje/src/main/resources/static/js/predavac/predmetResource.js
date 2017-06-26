(function (angular) {
	angular.module('predmet.resource',['ngResource'])
	.factory('Predmet', function($resource){
		var Predmet = $resource('/api/predmet/:id',
			{id:'@id'},
			{update:{method:'PUT'}});
		return Predmet;
	})
}(angular));