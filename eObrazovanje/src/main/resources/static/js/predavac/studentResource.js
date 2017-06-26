(function (angular) {
	angular.module('student.resource',['ngResource'])
	.factory('Student', function($resource){
		var Student = $resource('/api/student/:id',{id:'@id'},
			{update:{method:'PUT'}});
		return Student;
	})
}(angular));