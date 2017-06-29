(function (angular) {
	angular.module('ocene',['pohadjanja.resource', 'predavac.resource','predmet.resource','student.resource','kurs.resource'])
	.controller('OceneCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http, Pohadjanja) {
		var loadEntries = function () {


			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
		}
		loadEntries();

		$scope.pickSubjects = function(predmet) {
			$scope.selectedCourses = predmet.kursevi;
		}

		$scope.pickCourseInformation = function(kurs) {
			$scope.pohadjanja= new Pohadjanja();
			$scope.pohadjanja.$findByKurs({"idKursa": kurs.id}).then(function(item){
				$scope.numberOfStudents = item.pohadjanja.length;
				$scope.studentsByCourse = item.pohadjanja;
				console.log(item.pohadjanja);
			})
			$scope.singleCourse = kurs;
		}

		function findAttendingsByCourse(kurs) {
			new Pohadjanja().$findByKurs({"idKursa" : kurs.id}).then(function(item){
				return item;
			});
		}

		$scope.findObavezeByStudent = function(student) {
			console.log(student);
			$scope.predispitneObaveze = student.polaganje.predispitneObaveze;
		}

		$scope.findSum = function(obaveze) {
			var sum = 0;
			for(obaveza in obaveze) {
				sum += obaveze[obaveza].brojBodova;
			}

			return sum;
		}
	});


}(angular));
