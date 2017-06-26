(function (angular) {
	angular.module('predavac',['predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('PredavacCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http) {
		var loadEntries = function () {
					
			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();
	
		
		$scope.save = function () {
			if(!$scope.blogEntry._id){
				$scope.blogEntry.$save(loadEntries);
			}
			else{
				$scope.blogEntry.$update(loadEntries);				
			}
		} 
		$scope.delete = function (blogEntry) {
			blogEntry.$delete(loadEntries);
		}
		$scope.edit = function (blogEntry) {
			$scope.blogEntry = blogEntry;
		}
	    $scope.details = function (blogEntry) {
	      $location.path('/blogEntries/'+blogEntry._id);
	    }
	    $scope.kurseviPredmeta = function(idPredmeta){
	    	
	      
	     
	      $scope.kurseviSelektovanogPredmeta= new Predmet.get({id:idPredmeta})
	      console.log($scope.kurseviSelektovanogPredmeta);

	      
	        
	    };
	})
	.controller('kursCtrl', function($scope, $location,Predmet,Student ,Kurs,Predavac,$localStorage,$http){
		$scope.izborKursa = function(idKursa){
	    	
		      
		     
		      var kurs= new Kurs.get({id:idKursa})
		      $scope.sviStudent = new Student.query();
		     
		     

		      
		        
		    };
	});
}(angular));


