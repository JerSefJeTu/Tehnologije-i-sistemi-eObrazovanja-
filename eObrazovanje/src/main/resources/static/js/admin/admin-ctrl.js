(function(angular) {
   angular.module('admin',['pohadjanja.resource','predavac.resource','predmet.resource','student.resource','kurs.resource'])
    .controller('AdminCtrl', function($scope, Predmet, Predavac, Student, $http){
       
       $scope.izmenaStudentaInit = function(student){
           $scope.tempStudentIzmena = angular.copy(student);
           console.log($scope.tempStudentIzmena);
           var convertDate = new Date($scope.tempStudentIzmena.dateOfBirth);
           var retVal = convertDate.getDate() + "." +
           (convertDate.getMonth() + 1) + "." + convertDate.getFullYear() + "."
           $scope.tempStudentIzmenaDate= retVal;
       }
       
       $scope.izmenaStudenta = function(){
           var split= $scope.tempStudentIzmenaDate.split(".");
           var stringToDate=new Date(split[2],split[1]-1,split[0],0,0,0,0);
           $scope.tempStudentIzmena.dateOfBirth=stringToDate;
           var kajkut={};
           kajkut["id"]=$scope.tempStudentIzmena.id;
           kajkut["uplate"]=$scope.tempStudentIzmena.uplate;
           kajkut["firstname"]=$scope.tempStudentIzmena.firstname;
           kajkut["lastname"]=$scope.tempStudentIzmena.lastname;
           kajkut["username"]=$scope.tempStudentIzmena.username;
           kajkut["dateOfBirth"]=$scope.tempStudentIzmena.dateOfBirth;
           kajkut["placeOfOrigin"]=$scope.tempStudentIzmena.placeOfOrigin;
           kajkut["currentAddress"]=$scope.tempStudentIzmena.currentAddress;
           kajkut["phoneNumber"]=$scope.tempStudentIzmena.phoneNumber;
           kajkut["eMail"]=$scope.tempStudentIzmena.email;
           kajkut["JMBG"]=$scope.tempStudentIzmena.jmbg;
           console.log("!!!");
           console.log(kajkut)
           Student.update(kajkut);
       }
       
       
        $scope.placeholder = {};
        $scope.selectedStudentDTO = {};
        $scope.editedStudent = {};

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

//        $scope.izmenaStudenta = function() {
//            var temp = {};
//            temp["firstName"] = $scope.selectedStudent.firstname;
//            temp["lastName"] = $scope.selectedStudent.lastname;
//            temp["jmbg"] = $scope.selectedStudent.jmbg;
//            temp["userName"] = $scope.selectedStudent.username;
//            temp["dateOfBirth"] = $scope.selectedStudent.dateOfBirth;
//            temp["placeOfOrigin"] = $scope.selectedStudent.placeOfOrigin;
//            temp["currentAddress"] = $scope.selectedStudent.currentAddress;
//            temp["phoneNumber"] = $scope.selectedStudent.phoneNumber;
//            temp["eMail"] = $scope.selectedStudent.email;
//
//            $http.put("api/student", temp)
//            .then(function(data, status, headers, config){
//                var index = $scope.sviStudent
//                .findIndex(i => i.id == $scope.selectedStudent.id);
//                //copy();
//                $scope.sviStudent[index] = $scope.selectedStudent;
//            })
//        }

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
   });
}(angular));
