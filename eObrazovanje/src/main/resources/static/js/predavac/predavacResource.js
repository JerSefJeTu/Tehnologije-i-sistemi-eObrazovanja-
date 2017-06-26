(function (angular) {
	angular.module('predavac.resource',['ngResource'])
	.factory('Predavac', function($resource){
		var Predavac = $resource('/api/getUser/:userName',
			{userName:'@userName'},
			{update:{method:'PUT'}});
		return Predavac;
	})
}(angular));