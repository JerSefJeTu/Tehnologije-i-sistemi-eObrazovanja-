(function(angular){
    angular.module('student', ['authentication','uplata.resource'])
           .controller('StudentsCtrl',
            function($scope, $localStorage, StudentsResource, AuthenticationService){

               var username = AuthenticationService.getCurrentUser().username;
               var student = {};
               var pohadjanja = {};

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


                StudentsResource.getPohadjanja(student.id).then(function(item){
                   $scope.pohadjanja = item.data;
                   examComputation(item.data);
                   console.log($scope.pohadjanja);
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
     	  
    	}).directive('fileModel', ['$parse', function ($parse) {
            return {
                restrict: 'A',
                link: function(scope, element, attrs) {
                   var model = $parse(attrs.fileModel);
                   var modelSetter = model.assign;
                   
                   element.bind('change', function(){
                      scope.$apply(function(){
                         modelSetter(scope, element[0].files[0]);
                      });
                   });
                }
             };
          }]).service('fileUpload', [ function ($http) {
              this.uploadFileToUrl = function(file, uploadUrl,imeFajla){
                  var fd = new FormData();
                  fd.append('file', file);
                   fd.append('imeFajla',imeFajla);
               
                  $http.post(uploadUrl, fd, {
                     transformRequest: angular.identity,
                     headers: {'Content-Type': undefined}
                  })
               
                  .then(function(){
                  })
               
                  .catch(function(){
                  });
               }
            }]).controller('myCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){
                $scope.uploadFile = function(){
                    var file = $scope.myFile;
                     var imeFajla = $scope.dokument.naziv;
                    
                    console.log('file is ' );
                    console.dir(file);
                    
                    var uploadUrl = "/api/student/uploadFile";
                    fileUpload.uploadFileToUrl(file, uploadUrl,imeFajla);
                 };
              }]);
}(angular));