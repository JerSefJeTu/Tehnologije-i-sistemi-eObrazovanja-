(function (angular) {
    angular.module('student')
           .factory('StudentsResource', function($http) {

               const GET_STUDENTS = "api/student";
               const GET_STUDENT_BY_ID = "api/student/";
               const GET_STUDENT_BY_USERNAME = "api/student/findByUsername";
               const PUT_STUDENT = "api/student";
               const POST_STUDENT = "api/student";
               const DELETE_STUDENT = "api/student";
               const GET_STUDENT_ATTENDING_BY_ID = "api/pohadjanje/findByStudent/";

               var students = [];
               var pohadjanja = [];
               var studentsObj = {};

               studentsObj.getStudents = function() {
                    return $http.get(GET_STUDENTS)
                    .then(function(data, status){
                        students = data;
                        return students;
                    })
                    .catch(function(data, status){
                        console.log(status);
                    });
               };

               studentsObj.getStudentById = function(id) {
                   return $http.get(GET_STUDENT_BY_ID,
                    {params:{"id" : id}})
                   .then(function(data, status) {
                       return data;
                   })
                   .catch(function(data, status) {
                       console.log(status);
                   });
               }

               studentsObj.getStudentByUsername = function(username) {
                   return $http.get(GET_STUDENT_BY_USERNAME,
                   {params:{"username" : username}}
                   .then(function(data, status) {
                       console.log("DATADATA: " + data);
                       return data;
                   })
                   .catch(function(data, status) {
                      console.log(status);
                   });
               }

               studentsObj.saveStudent = function(student) {
                   if(student.id) {
                       return $http.put(PUT_STUDENT,
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
                       return $http.post(POST_STUDENT,
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
                   return $http.delete(DELETE_STUDENT,
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

               studentsObj.getPohadjanja = function(id, page, size) {
                   return $http.get(GET_STUDENT_ATTENDING_BY_ID + id,
                   {params:{"page" : page,
                            "size" : size}
                    })
                    .then(function(data, status){
                        pohadjanja = data;
                        return pohadjanja;
                    })
                    .catch(function(data, status){
                        console.log(status);
                    });
               }

               return studentsObj;
           });

}(angular));
