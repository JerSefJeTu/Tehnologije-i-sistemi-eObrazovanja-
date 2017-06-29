(function(angular) {
    angular.module('ocene', [])
           .factory('OceneResource', function($http) {

            const GET_PREDAVAC_BY_USERNAME = "api/predavac/findByUsername";

            var oceneObj = {};

            oceneObj.getPredavacByUsername = function(username) {
                return $http.get(GET_PREDAVAC_BY_USERNAME,
                {params:{"username" : username}})
                .then(function(data, status){
                    return data;
                })
                .catch(function(data, status){
                    console.log(status);
                });
            }

            return oceneObj;
           });
}(angular));
