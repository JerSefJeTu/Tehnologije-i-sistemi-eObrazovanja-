(function(angular){
    angular.module('student', ['authentication'])
           .controller('StudentsCtrl',
            function($scope, $localStorage, StudentsResource, AuthenticationService){
               var username = AuthenticationService.getCurrentUser().username;
               var student = {};
               var pohadjanja = {};

            StudentsResource.getStudentByUsername(username).then(function(item){
                var obj = item.data;
                createStudent(obj);
            });

            $scope.student = student;
            console.log($scope.student);

            StudentsResource.getPohadjanja(student.id).then(function(item){
                pohadjanja = item;
                $scope.pohadjanja = pohadjanja;
                console.log($scope.pohadjanja);
                examComputation(pohadjanja);
            });

            function examComputation(pohadjanja) {
                for(pohadjanje in pohadjanja) {
                    let sum = 0;
                    let sumMax = 0;
                    let sumMin = 0;

                    for(obaveza in pohadjanje.predispitneObaveze) {
                        if(!obaveza.toLowerCase().includes("kolokvijum")) {
                            sum += obaveza.brojBodova;
                            sumMax += obaveza.maxBodova;
                            sumMin += obaveza.minBodova;
                        }
                    }

                    let onePercent = sumMax / 100;
                    let totalPercent = sum / onePercent;
                    let maxPercent = sumMax / onePercent;
                    let minPercent = sumMin / onePercent;

                    pohadjanje.totalBodovaPredispitne = totalPercent;
                    pohadjanje.maxBodovaPredispitne = maxPercent;
                    pohadjanje.minBodovaPredispitne = minPercent;
                }
                console.log(pohadjanja);
            }

            $scope.show = function() {
                console.log(pohadjanja);
            }

            function createStudent(obj) {
                student.id = obj.id;
                student.stanje = obj.stanje;
                student.firstname = obj.firstname;
                student.lastname = obj.lastname;
                student.username = obj.username;
                student.dateOfBirth = obj.dateOfBirth;
                student.placeOfOrigin = obj.placeOfOrigin;
                student.currentAddress = obj.currentAddress;
                student.phoneNumber = obj.phoneNumber;
                student.email = obj.email;
                student.dokumenti = obj.dokumenti;
                student.uplate = obj.uplate;
                student.jmbg = obj.jmbg;
            }

           });
}(angular));
