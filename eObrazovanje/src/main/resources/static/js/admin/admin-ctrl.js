(function(angular) {
   angular.module('admin',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
    .controller('AdminCtrl', function($scope, Predmet, Predavac, Student, $http){

        $scope.selectedStudentDTO = {};
        $scope.editedStudent = {};
        $scope.tempPredmeti = [];
        $scope.predavacUpdate = {};

    	var loadEntries = function () {

    		$scope.sviStudent = Student.query();
            $scope.sviPredmeti = Predmet.query();
            $http.get("api/predavac").then(function(data, status){
                $scope.sviPredavaci = data.data;
                console.log($scope.sviPredavaci);
            })
    		console.log($scope.sviStudent);
            console.log($scope.sviPredmeti);
		}

		loadEntries();

        function createCopy() {
            $scope.selectedStudentDTO.firstname = $scope.student.firstName;
            $scope.selectedStudentDTO.lastname = $scope.student.lastName;
            $scope.selectedStudentDTO.username = $scope.student.userName;
            $scope.selectedStudentDTO.dateOfBirth = $scope.student.dateOfBirth;
            $scope.selectedStudentDTO.placeOfOrigin = $scope.student.placeOfOrigin;
            $scope.selectedStudentDTO.currentAddress = $scope.student.currentAddress;
            $scope.selectedStudentDTO.phoneNumber = $scope.student.phoneNumber;
            $scope.selectedStudentDTO.email = $scope.student.eMail;
            $scope.selectedStudentDTO.jmbg = $scope.student.jmbg;
        }

		$scope.dodavanjeStudenta = function(){
            console.log($scope.student);
            createCopy();
            $http.post("api/student",$scope.student)
			.then(function(data, status, headers, config){
				//loadEntries();
                $scope.sviStudent.push($scope.selectedStudentDTO);
    		})
		}

        $scope.brisanjeStudenta = function() {
            var id = $scope.selectedStudent.id;
            var index = $scope.sviStudent
            .findIndex(i => i.id == id);
            $http.delete("api/student",
            {params:{"id" : id}})
            .then(function(data, status){
                $scope.sviStudent.splice(index, 1);
                return data;
            })
            .catch(function(data, status){
                console.log(status);
            })
        }

        $scope.pickStudent = function(student) {
            $scope.selectedStudent = student;
        }

        $scope.izmenaStudenta = function() {
            var temp = {};
            temp["firstName"] = $scope.selectedStudent.firstname;
            temp["lastName"] = $scope.selectedStudent.lastname;
            temp["jmbg"] = $scope.selectedStudent.jmbg;
            temp["userName"] = $scope.selectedStudent.username;
            temp["dateOfBirth"] = $scope.selectedStudent.dateOfBirth;
            temp["placeOfOrigin"] = $scope.selectedStudent.placeOfOrigin;
            temp["currentAddress"] = $scope.selectedStudent.currentAddress;
            temp["phoneNumber"] = $scope.selectedStudent.phoneNumber;
            temp["eMail"] = $scope.selectedStudent.email;

            $http.put("api/student", temp)
            .then(function(data, status, headers, config){
                var index = $scope.sviStudent
                .findIndex(i => i.id == $scope.selectedStudent.id);
                //copy();
                $scope.sviStudent[index] = $scope.selectedStudent;
            })
        }

        $scope.dateLabel = function(date) {
            var convertDate = new Date(date);
            student.dateOfBirth = convertDate.getDate() + "." +
            (convertDate.getMonth() + 1) + "." + convertDate.getFullYear() + ".";
            return student.dateOfBirth;
        }

        function copy() {
            $scope.selectedStudentDTO.id = $scope.editedStudent.id;
            $scope.selectedStudentDTO.firstname = $scope.editedStudent.firstName;
            $scope.selectedStudentDTO.lastname = $scope.editedStudent.lastName;
            $scope.selectedStudentDTO.username = $scope.editedStudent.userName;
            $scope.selectedStudentDTO.dateOfBirth = $scope.editedStudent.dateOfBirth;
            $scope.selectedStudentDTO.placeOfOrigin = $scope.editedStudent.placeOfOrigin;
            $scope.selectedStudentDTO.currentAddress = $scope.editedStudent.currentAddress;
            $scope.selectedStudentDTO.phoneNumber = $scope.editedStudent.phoneNumber;
            $scope.selectedStudentDTO.email = $scope.editedStudent.eMail;
            $scope.selectedStudentDTO.jmbg = $scope.editedStudent.jmbg;
        }

        $scope.deletePredavac = function(predavac) {
            var index = $scope.sviPredavaci
            .findIndex(i => i.id == predavac.id);
            $http.delete("api/predavac",
            {params:{"id" : predavac.id}})
            .then(function(data, status){
                $scope.sviPredavaci.splice(index, 1);
                return data;
            })
            .catch(function(data, status){
                console.log(status);
            })
        }

        $scope.dodajPredmetUtempListu = function(predmet) {
            $scope.tempPredmeti.push(predmet);
            var index = $scope.sviPredmeti
            .findIndex(i => i.id == predmet.id);
            $scope.sviPredmeti.splice(index, 1);
        }

        $scope.vratiPredmetUlistu = function(predmet) {
            $scope.sviPredmeti.push(predmet);
            var index = $scope.tempPredmeti
            .findIndex(i => i.id == predmet.id);
            $scope.tempPredmeti.splice(index, 1);
        }

        $scope.dodavanjePredavaca = function() {
            $http.post("api/predavac", $scope.predavac)
            .then(function(data){
                $http.get("api/predavac/findByUsername",{params:{"username":$scope.predavac.userName}
            }).then(function(data){
                $scope.predavac.predmeti = $scope.tempPredmeti;
                $scope.predavac.id = data.data.id;
                $http.put("api/predavac", $scope.predavac)
                .then(function(data){
                    console.log(data);
                    $scope.sviPredavaci.push(data.data);
                });
            });
        });
        }

        $scope.updatePredavac = function(predavac) {
            $scope.predavacUpdate = predavac;
            console.log($scope.predavacUpdate);
        }
   });
}(angular));
