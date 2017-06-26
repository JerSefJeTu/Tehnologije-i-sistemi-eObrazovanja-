(function (angular) {
	angular.module('kurs.resource',['ngResource'])
	.factory('Kurs', function($resource){
		var Kurs = $resource('/api/kurs/:id',
			{id:'@id'},
			{update:{method:'PUT'}});
		return Kurs;
	})
}(angular));