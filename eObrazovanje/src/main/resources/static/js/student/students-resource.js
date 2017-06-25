(function (angular) {
    angular.module('student')
           .factory('StudentsResource', function($http) {

               var students = [];
               var studentsObj = {};

               studentsObj.getStudents = function() {
                    return $http.get("api/student")
                    .then(function(data, status){
                        students = data;
                        return students;
                    })
                    .catch(function(data, status){
                        console.log(status);
                    });
               };

               studentsObj.getStudent = function(id) {
                   return $http.get("api/student/",
                    {params:{"id" : id}})
                   .then(function(data, status) {
                       return data;
                   })
                   .catch(function(data, status) {
                       console.log(status);
                   });
               }

               studentsObj.saveStudent = function(student) {
                   if(student.id) {
                       return $http.put("api/student",
                       {params:{"student" : student}})
                       .then(function(data, status) {
                           var index = students
                           .findIndex(i => i.id == student.id);
                           students[index] = student;
                       })
                       .catch(function(data, status) {
                           console.log(status);
                       });
                   } else {
                       return $http.post("api/student",
                       {params:{"student" : student}})
                       .then(function(data, status){
                           students.push(student);
                       })
                       .catch(function(data, status){
                           console.log(status);
                       });
                   }
               }

               studentsObj.deleteStudent = function(id) {
                   return $http.delete("api/student",
                   {params:{"id" : id}})
                   .then(function(data, status){
                       var index = students
                       .findIndex(i => i.id == id);
                       students.splice(index, 1);
                   })
                   .catch(function(data, status){
                       console.log(status);
                   });
               }

               //studentsObj --> TODO napraviti da student ima pristup svemu sto
               //je vezano za njega

               return studentsObj;
           });

}(angular));
