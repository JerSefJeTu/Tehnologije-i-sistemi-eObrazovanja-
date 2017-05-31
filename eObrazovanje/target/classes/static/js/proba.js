(function (angular) {
	angular.module('proba',[])
	.controller('probaCtrl', function($scope,$http) {
		
		$scope.predmet = function () {
			 $http.get("http://localhost:8080/api/Kurs").
		        then(function(data, status, headers, config) {
		            // this callback will be called asynchronously
		            // when the response is available
		        	
		            console.log(data);
		            $scope.kategorija.ime="";
		            $scope.initFirst();
		            
		          }).
		          catch(function(data, status, headers, config) {
		            // called asynchronously if an error occurs
		            // or server returns response with an error status.
		          });
		} 
	});
}(angular));


