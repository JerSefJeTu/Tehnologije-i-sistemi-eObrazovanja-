(function(angular){
    angular.module('student', ['authentication'])
           .controller('StudentsCtrl',
            function($scope, $localStorage, StudentsResource, AuthenticationService){
               console.log('uslo u kontroler');
               console.log(AuthenticationService.getCurrentUser());
               
           });
}(angular));
