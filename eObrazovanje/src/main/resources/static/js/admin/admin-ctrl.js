(function(angular) {
   angular.module('admin',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
    .controller('AdminCtrl', function($scope, Predmet, Predavac, Student, $http){

        $scope.placeholder = {};
        $scope.selectedStudentDTO = {};

    	var loadEntries = function () {


    		$scope.sviStudent = new Student.query();
    		console.log($scope.sviStudent);
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
			if($scope.mode == 'create') {
                $http.post("api/student",$scope.student)
    			.then(function(data, status, headers, config){
    				//loadEntries();
                    $scope.sviStudent.push($scope.selectedStudentDTO);
        		})
            }
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

        $scope.currentMode = function(modeStr) {
            $scope.mode = modeStr;
            $scope.placeholder.firstname = "Unesite ime studenta...";
            $scope.placeholder.lastname = "Unesite prezime studenta...";
            $scope.placeholder.jmbg = "Unesite JMBG studenta...";
            $scope.placeholder.username = "Unesite korisnicko ime studenta...";
            $scope.placeholder.password = "Unesite lozinku studenta...";
            $scope.placeholder.password2 = "Ponovite lozinku studenta...";
            $scope.placeholder.date = "(YYYY-MM-DD)";
            $scope.placeholder.placeOfBirth = "Unesite mesto rođenja studenta...";
            $scope.placeholder.address = "Unesite adresu studenta...";
            $scope.placeholder.phoneNumber = "Unesite broj telefona studenta...";
            $scope.placeholder.email = "Unesite e-mail studenta...";
        }

        $scope.pickStudentForUpdate = function(student, modeStr) {
            console.log(student);
            $scope.mode = modeStr;

            $scope.placeholder.id = student.id;
            $scope.placeholder.firstname = student.firstname;
            $scope.placeholder.lastname = student.lastname;
            $scope.placeholder.jmbg = student.jmbg;
            $scope.placeholder.username = student.username;
            $scope.placeholder.date = student.dateOfBirth;
            $scope.placeholder.placeOfBirth = student.placeOfOrigin;
            $scope.placeholder.address = student.currentAddress;
            $scope.placeholder.phoneNumber = student.phoneNumber;
            $scope.placeholder.email = student.email;
        }

        $scope.izmenaStudenta = function() {
            $http.put("api/student", $scope.placeholder)
            .then(function(data, status, headers, config){
                var index = $scope.sviStudent
                .findIndex(i => i.id == $scope.placeholder.id);
                $scope.sviStudent.push($scope.placeholder);
            })
        }
   });
}(angular));
