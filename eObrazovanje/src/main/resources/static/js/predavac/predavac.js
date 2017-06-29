(function (angular) {
	angular.module('predavac',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('PredavacCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http) {
		var loadEntries = function () {


			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();

		 $scope.kurseviPredmeta = function(idPredmeta){
		    	console.log("aa");

		      $scope.idPredmeta=idPredmeta;
		      $scope.kurseviSelektovanogPredmeta= new Predmet.get({id:idPredmeta})
		      console.log($scope.kurseviSelektovanogPredmeta);



		    };



        $scope.brisanjeKursaInit = function(idKursa,naziv) {
            $scope.nazivKursaInit=naziv;
            $scope.idKursaInit=idKursa;
        }
        $scope.brisanjeKursa = function(){

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
		$scope.predmetService = new Predmet();
	      $scope.dodavanje = function() {
	        	console.log($scope.kurs);

	        	$http.get("api/predmet/"+$scope.idPredmeta).
	            then(function(data, status, headers, config) {
	            	$scope.predmet=data.data;
	            	$scope.kurs.predmet=$scope.predmet;
	            	 $http.post("api/kurs/",$scope.kurs).
	 	            then(function(data, status, headers, config) {
	 	                // this callback will be called asynchronously
	 	                // when the response is available

	 	                console.log(data);



	 	              }).
	 	              catch(function(data, status, headers, config) {
	 	                // called asynchronously if an error occurs
	 	                // or server returns response with an error status.
	 	              });
	              }).
	              catch(function(data, status, headers, config) {
	              });

	        	console.log($scope.kurs);


	        }
		$scope.izborKursa = function(idKursa){



		     $scope.idKursaInit=idKursa;

		      $scope.sviStudent = new Student.query();
		      $scope.pohadjanje.$findByKurs({'idKursa':idKursa}).then(function(item){

		    	  console.log($scope.kurs);
	                $scope.pohadjanja = item;
	                $scope.obaveze= $scope.pohadjanja.pohadjanja[0].polaganje.predispitneObaveze;
	                console.log($scope.obaveze);
	                console.log($scope.pohadjanja);

	            });

	            };

        $scope.dodavanjeObaveze = function(){
                console.log($scope.obaveza);
            }
        $scope.brisanjeKursaInit = function(idKursa,naziv) {
            $scope.nazivKursaInit=naziv;
            $scope.idKursaInit=idKursa;
        }
        $scope.brisanjeKursa = function(){

        }
        $scope.brisanjeObavezeInit = function(idObaveze, naziv) {
            $scope.idObavezeInit = idObaveze;
            $scope.nazivObavezeInit = naziv;
        }
        $scope.brisanjeObaveze = function(){
            alert("brise se "+$scope.nazivObavezeInit+", kursa "+$scope.nazivKursaInit);
        }
	});
}(angular));
