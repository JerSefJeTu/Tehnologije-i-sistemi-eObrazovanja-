(function(angular){
    angular.module('student', ['authentication'])
           .controller('StudentsCtrl',
            function($scope, $localStorage, StudentsResource, AuthenticationService){
               var username = AuthenticationService.getCurrentUser().username;
            StudentsResource.getStudentByUsername(username).then(function(item){
                   console.log(item);
                   console.log($localStorage.currentUser);
                });
           });
}(angular));
