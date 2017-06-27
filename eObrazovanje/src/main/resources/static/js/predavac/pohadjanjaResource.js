(function (angular) {
	angular.module('pohadjanja.resource',['ngResource'])
	.factory('Pohadjanja', function($resource){
		var Pohadjanja = $resource('/api/pohadjanje/:id',
			{id:'@id'},
			{
				update:{method:'PUT'},
				findByKurs:{//custom post metoda koja dobavlja pohadjanja odredjenog kursa
					method:'GET',
					url:'/api/pohadjanje/findByKurs/:idKursa'
				}
			}
			);
		return Pohadjanja;
	});
}(angular));