(function(angular) {
    angular.module('ocene', ['predavac.resource'])
           .controller('OceneCtrl',
            function($scope, $localStorage, OceneResource, Predavac) {

                var username = AuthenticationService.getCurrentUser().username;
                var predavac = {};

                OceneResource.getPredavacByUsername(username).then(function(item){
                    predavac = item.data;
                    $scope.predavac = predavac;

                    
                });

            });
}(angular));
