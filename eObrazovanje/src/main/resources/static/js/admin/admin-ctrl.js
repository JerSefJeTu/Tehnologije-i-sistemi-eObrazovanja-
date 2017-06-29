(function(angular) {
   angular.module('admin',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
    .controller('AdminCtrl', function($scope, Predmet, Predavac, Student, $http){
    	
    	var loadEntries = function () {


    		$scope.sviStudent = new Student.query();
    		console.log($scope.sviStudent);
		}
		loadEntries();
    	 
   });
}(angular));