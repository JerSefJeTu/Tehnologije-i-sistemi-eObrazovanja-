(function (angular) {
	angular.module('ocene',['pohadjanja.resource', 'predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('OceneCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http, Pohadjanja) {
		var loadEntries = function () {


			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
			console.log($scope.predavac);
		}
		loadEntries();

		$scope.pickSubjects = function(predmet) {
			$scope.selectedCourses = predmet.kursevi;
		}

		$scope.pickCourseInformation = function(kurs) {
			$scope.pohadjanja= new Pohadjanja();
			$scope.pohadjanja.$findByKurs({"idKursa": kurs.id}).then(function(item){
				console.log(item);
			})
			$scope.singleCourse = kurs;
			var pohadjanja = findAttendingsByCourse(kurs);
			console.log(pohadjanja);
			//$scope.numberOfStudents = pohadjanja.data;
		}

		function findAttendingsByCourse(kurs) {
			new Pohadjanja().$findByKurs({"idKursa" : kurs.id}).then(function(item){
				return item;
			});
		}

	});


}(angular));
