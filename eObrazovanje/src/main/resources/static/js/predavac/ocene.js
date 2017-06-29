(function (angular) {
	angular.module('ocene',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('OceneCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http) {
		var loadEntries = function () {


			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();


	});


}(angular));
