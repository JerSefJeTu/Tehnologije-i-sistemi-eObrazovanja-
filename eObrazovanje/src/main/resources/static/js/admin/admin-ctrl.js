(function(angular) {
   angular.module('admin',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
    .controller('AdminCtrl', function($scope, Predmet, Predavac, Student, $http){
    	
    	var loadEntries = function () {


    		$scope.sviStudent = new Student.query();
    		console.log($scope.sviStudent);
		}
		loadEntries();
    	 
		$scope.dodavanjeStudenta = function(){
			$http.post("api/student",$scope.student)
			.then(function(data, status, headers, config){
				loadEntries();
    			
    		})
		}
   });
}(angular));