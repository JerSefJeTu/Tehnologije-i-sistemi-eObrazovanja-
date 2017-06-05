(function () {
    angular
        .module('authentication',['ngStorage', 'ui.router', 'angular-jwt'])
        .factory('AuthenticationService', Service);

    function Service($http, $localStorage, $log, $state, jwtHelper) {
        var service = {};

        service.login = login;
        service.logout = logout;
        service.getCurrentUser = getCurrentUser;

        return service;

        function login(user, callback) {
            $http.post('/api/login', user)
                .then(function (response) {
                   
                	var token = response.data;
                	console.log(token);
                   
                        
                        var currentUser = { username: user.username, token: token.payload}
                        console.log(currentUser);
                        var tokenPayload = jwtHelper.decodeToken(token.payload);
                        if(tokenPayload.role){
                        	console.log(tokenPayload);
                        	console.log(tokenPayload.role);
                            currentUser.role = tokenPayload.role;
                        }
                      
                        $localStorage.currentUser = currentUser;
                        console.log($localStorage);
                        
                        $http.defaults.headers.common.Authorization = response.token;
                        
                        callback(true);
                        $state.go('main');
                     
                }).catch( function(response) {
                	callback(false);
                console.log("invalid login");
              });
        }

        function logout() {
        	console.log("logout");
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
            $state.go('login');
        }

        function getCurrentUser() {
            return $localStorage.currentUser;
        }
    }
})();