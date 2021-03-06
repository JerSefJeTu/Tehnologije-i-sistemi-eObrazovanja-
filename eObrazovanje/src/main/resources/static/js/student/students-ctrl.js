(function(angular){
    angular.module('student', ['authentication','uplata.resource'])
           .controller('StudentsCtrl',
            function($http,$scope, $localStorage, StudentsResource, AuthenticationService){


              $scope.polozeniIspit=function(student){
                $scope.listaPrivremenihStudenata.push(student);
                for(student1 in $scope.sviStudent) {
                  var index = $scope.sviStudent.findIndex(t => t.id == student.id);
                  if(index != -1) {
                    $scope.sviStudent.splice(index, 1);
                  }
                }

              }

        	   $scope.addDokument = function(files){
        	    	var fd = new FormData();
        	        //Take the first selected file
        	    	$scope.student.dateOfBirth=null;
        	        fd.append("file", files[0]);
        	        fd.append('student', new Blob([angular.toJson($scope.student)], {
        	            type: "application/json"
        	        }));
        	        console.log(fd);
        	        $http.post('/api/student/upload', fd, {
        	            withCredentials: true,
        	            headers: {'Content-Type': undefined },
        	            transformRequest: angular.identity
        	        }).then().catch();

        	    };

        	    $scope.downloadFile = function(file){
        	    	console.log(file);
        	        $http.post("api/student/download", {params:{"filename" : file.naziv}}).
        	        then(function(data) {
        	        	console.log(data);
        	            // this callback will be called asynchronously
        	            // when the response is available
        	        	var file = new Blob([data], {type: 'application/pdf'});
        	        	var fileURL = URL.createObjectURL(file);
        	            $window.open(fileURL);


        	          }).
        	          catch(function(data, status, headers, config) {
        	            // called asynchronously if an error occurs
        	            // or server returns response with an error status.
        	          });



        	    };

               var username = AuthenticationService.getCurrentUser().username;
               var student = {};
               var pohadjanja = {};
               var dokumenti = {};

            StudentsResource.getStudentByUsername(username).then(function(item){
                student = item.data;
                $scope.student = student;

                function examComputation(pohadjanja) {
                    for(p in pohadjanja) {

                        let pohadjanje = pohadjanja[p];

                        let sum = 0;
                        let sumMax = 0;
                        let sumMin = 0;

                        let sumColloquium = 0;
                        let sumColloquiumMax = 0;
                        let sumColloquiumMin = 0;

                        for(po in pohadjanje.polaganje.predispitneObaveze) {

                            let obaveza = pohadjanje.polaganje.predispitneObaveze[po];

                            if(!obaveza.nazivObaveze.toLowerCase().includes("kolokvijum")) {
                                sum += obaveza.brojBodova;
                                sumMax += obaveza.maxBodova;
                                sumMin += obaveza.minBodova;
                            } else {
                                sumColloquium += obaveza.brojBodova;
                                sumColloquiumMax += obaveza.maxBodova;
                                sumColloquiumMin += obaveza.minBodova;
                            }
                        }

                        let onePercent = sumMax / 100;
                        let totalPercent = sum / onePercent;
                        let maxPercent = sumMax / onePercent;
                        let minPercent = sumMin / onePercent;

                        let onePercentCol = sumColloquiumMax / 100;
                        let totalPercentCol = sumColloquium / onePercentCol;
                        let maxPercentCol = sumColloquiumMax / onePercentCol;
                        let minPercentCol = sumColloquiumMin / onePercentCol;

                        if(isNaN(maxPercent) || isNaN(minPercent)) {
                            pohadjanje['predispitneObaveze'] = 'nema obaveza';
                        } else {
                            if(!isNaN(totalPercent) && totalPercent >= minPercent) {
                                pohadjanje['predispitneObaveze'] = 'polozeno';
                            } else {
                                pohadjanje['predispitneObaveze'] = 'nije polozeno';
                            }
                        }
                        pohadjanje['predispitneBodovi'] = totalPercent;

                        if(isNaN(maxPercentCol) || isNaN(minPercentCol)) {
                            pohadjanje['kolokvijum'] = 'nema kolokvijuma';
                        } else {
                            if(!isNaN(totalPercentCol) &&
                                totalPercentCol >= minPercentCol) {
                                pohadjanje['kolokvijum'] = 'polozeno';
                            } else {
                                pohadjanje['kolokvijum'] = 'nije polozeno';
                            }
                        }

                        pohadjanje['kolokvijumBodovi'] = totalPercentCol;

                    }
                    console.log(pohadjanja);
                }

                function createDummyArray(range) {
                    var array = [];
                    for(i = 0; i < range; i++) {
                        array[i] = i + 1;
                    }

                    return array;
                }

                StudentsResource.getPohadjanjaPages(student.id, 0, 4).then(function(item){
                   $scope.pohadjanja = item.data.content;
                   $scope.totalPages = createDummyArray(item.data.totalPages);
                   examComputation(item.data.content);
               });

               StudentsResource.getDokumenti(student.username).then(function(item){
            	   console.log(item);
                  $scope.dokumenti = item.data;
                  console.log(item);
               });
           });

    // <-- UI  -->

        // Predispitne obaveze
        $scope.predispitneObavezeClass = function(pohadjanje) {
            if(pohadjanje.predispitneObaveze === 'nema obaveza') {
                return 'progress-bar progress-bar-striped';
            } else {
                return 'progress-bar progress-bar-info';
            }
        }

        $scope.predispitneObavezeLabel = function(pohadjanje) {
            if(pohadjanje.predispitneObaveze === 'nema obaveza') {
                return 'Nema predispitnih obaveza';
            } else {
                return pohadjanje.predispitneBodovi.toFixed(1) + '% predispitnih obaveza';
            }
        }

        $scope.predispitneObavezeWidth = function(pohadjanje) {
            if(pohadjanje.predispitneObaveze === 'nema obaveza') {
                return 100;
            } else {
                return pohadjanje.predispitneBodovi;
            }
        }

        // Kolokvijumi
        $scope.kolokvijumClass = function(pohadjanje) {
            if(pohadjanje.kolokvijum === 'nema kolokvijuma') {
                return 'progress-bar progress-bar-striped';
            } else {
                return 'progress-bar progress-bar-primary';
            }
        }

        $scope.kolokvijumWidth = function(pohadjanje) {
            if(pohadjanje.kolokvijum === 'nema kolokvijuma') {
                return 100;
            } else {
                return pohadjanje.kolokvijumBodovi;
            }
        }

        $scope.kolokvijumLabel = function(pohadjanje) {
            if(pohadjanje.kolokvijum === 'nema kolokvijuma') {
                return 'Nema kolokvijuma';
            } else {
                return pohadjanje.kolokvijumBodovi.toFixed(1) + '% kolokvijuma';
            }
        }

        $scope.cardClass = function(pohadjanje) {
            if(pohadjanje.polaganje.brojBodova >= 51) {
                return 'panel panel-success';
            } else if(pohadjanje.polaganje.brojBodova <= 0 ||
                isNaN(pohadjanje.polaganje.brojBodova)) {
                return 'panel panel-default';
            } else {
                return 'panel panel-warning';
            }
        }

        $scope.dateLabel = function(student) {
            var convertDate = new Date(student.dateOfBirth);
            student.dateOfBirth = convertDate.getDate() + "." +
            (convertDate.getMonth() + 1) + "." + convertDate.getFullYear() + ".";
            return student.dateOfBirth;
        }

        }).controller('uplateController', function($scope, $location,Uplata,$localStorage,$http){


     	   $scope.uplata = new Uplata();
     	   $scope.uplata.$findByStudent({'UserName':$localStorage.currentUser.username}).then(function(item){

	                console.log( $scope.uplata);


	                $scope.uplate=$scope.uplata;

	            });


     	   $scope.Filter= function(){


     		   for (var i = 0; i <  $scope.uplata.uplate.length; i++) {
     			   console.log($scope.range.maxPrice);
					if($scope.uplata.uplate[i].iznos <= $scope.range.minPrice && $scope.uplata.uplate[i].iznos >= $scope.range.maxPrice){
						console.log("uslo u if");
						$scope.uplate.uplate.remove(i);
					}
				}
     	   };

    	});
}(angular));
