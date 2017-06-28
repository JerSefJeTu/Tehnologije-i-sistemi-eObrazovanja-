(function (angular) {
	angular.module('uplata.resource',['ngResource'])
	.factory('Uplata', function($resource){
		var Uplata = $resource('/api/uplata/:id',
			{id:'@id'},
			{
				update:{method:'PUT'},
				findByStudent:{//custom post metoda koja dobavlja uplate odredjenog studenta
					method:'GET',
					url:'/api/uplata/findByStudent/',
					params:{UserName:'UserName'}
				}
			}
			);
		return Uplata;
	});
}(angular));