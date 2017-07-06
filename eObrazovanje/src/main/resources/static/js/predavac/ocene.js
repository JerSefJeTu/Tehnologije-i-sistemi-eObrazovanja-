(function (angular) {
	angular.module('ocene',['pohadjanja.resource', 'predavac.resource','predmet.resource','student.resource','kurs.resource','predispitna.resource'])
	.controller('OceneCtrl', function($scope, $location,Predmet ,Predavac,$localStorage,$http, Pohadjanja,PredispitnaObaveza) {
		var loadEntries = function () {


			$scope.predavac = new Predavac.get({username: $localStorage.currentUser.username});
		}
		loadEntries();

		$scope.pickSubjects = function(predmet) {
			$scope.selectedCourses = predmet.kursevi;
		}

		$scope.pickCourseInformation = function(kurs) {

			$scope.studentsByCourse = Pohadjanja.findByKurs({"idKursa": kurs.id})
			$scope.singleCourse = kurs;
		}

		function findAttendingsByCourse(kurs) {
			new Pohadjanja().$findByKurs({"idKursa" : kurs.id}).then(function(item){
				return item;
			});
		}

		$scope.findObavezeByStudent = function(student) {
			console.log(student);
			$scope.student=student;
			$scope.predispitneObaveze = student.polaganje.predispitneObaveze;
		}

		$scope.oceniObavezuInit = function(obaveza){
			console.log(obaveza);
			$scope.obaveza=obaveza;
			$scope.obavezaInitCopy= angular.copy(obaveza);
		}
		$scope.updateOcene = function(){
			console.log($scope.obavezaInitCopy);
			PredispitnaObaveza.update($scope.obavezaInitCopy)
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
