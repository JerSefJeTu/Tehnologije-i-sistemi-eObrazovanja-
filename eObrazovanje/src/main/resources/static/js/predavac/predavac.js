(function (angular) {
	angular.module('predavac',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('PredavacCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http, ngDialog) {
		var loadEntries = function () {
					
			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();
	
        $scope.alert = function() {
            alert("!!!");
        }
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
	.controller('kursCtrl', function($scope, $location,Predmet,Student,Pohadjanja ,Kurs,Predavac,$localStorage,$http){
		
		$scope.pohadjanje = new Pohadjanja();
		$scope.izborKursa = function(idKursa){
	    	
		      
		     
		      
		      $scope.sviStudent = new Student.query();
		      $scope.pohadjanje.$findByKurs({'idKursa':idKursa}).then(function(item){
		    	 
	                
	                $scope.pohadjanja = item;
	                $scope.obaveze= $scope.pohadjanja.pohadjanja[0].polaganje.predispitneObaveze;
	                console.log($scope.obaveze);
	                console.log($scope.pohadjanja);
	 
	            });;
		      
		      
		      
		     
		     
		     

		      
		        
		    };
	});
}(angular));


