(function(angular){
    angular.module('student', ['authentication'])
           .controller('StudentsCtrl',
            function($scope, $localStorage, StudentsResource, AuthenticationService){
               console.log('uslo u kontroler');
               var username = AuthenticationService.getCurrentUser().username;
            StudentsResource.getStudentByUsername(username).then(function(item){
                   console.log(item.data);
                });
           });
}(angular));
