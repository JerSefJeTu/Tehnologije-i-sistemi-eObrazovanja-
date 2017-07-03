(function (angular) {
	angular.module('predispitna.resource',['ngResource'])
	.factory('PredispitnaObaveza', function($resource){
		var PredispitnaObaveza = $resource('/api/predispitnaObaveza/:id',
			{id:'@id'},
			{update:{method:'PUT'}});
		return PredispitnaObaveza;
	})
}(angular));
