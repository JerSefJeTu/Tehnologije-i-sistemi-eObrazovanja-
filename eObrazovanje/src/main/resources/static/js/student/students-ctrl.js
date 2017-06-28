(function(angular){
    angular.module('student', ['authentication'])
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
                        let totalPercentCol = sumColloquium / onePercent;
                        let maxPercentCol = sumColloquiumMax / onePercentCol;
                        let minPercentCol = sumColloquiumMin / onePercentCol;

                        pohadjanje['totalBodovaPredispitne'] = totalPercent;
                        pohadjanje['maxBodovaPredispitne'] = maxPercent;
                        pohadjanje['minBodovaPredispitne'] = minPercent;
                    }
                    console.log(pohadjanja);
                }


                StudentsResource.getPohadjanja(student.id).then(function(item){
                   $scope.pohadjanja = item.data;
                   examComputation(item.data);
               });
           });
        });
}(angular));
