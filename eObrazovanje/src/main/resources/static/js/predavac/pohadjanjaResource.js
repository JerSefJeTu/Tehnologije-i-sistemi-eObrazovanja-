(function (angular) {
	angular.module('pohadjanja.resource',['ngResource'])
	.factory('Pohadjanja', function($resource){
		var Pohadjanja = $resource('/api/pohadjanja/:id',
			{id:'@id'},
			{update:{method:'PUT'}});
		return Pohadjanja;
	})
}(angular));