(function (angular) {
	var app = angular.module('app',['proba','login','ui.router', 'authentication']);
	
	
	app
    .config(config)
    .run(run);
    function config($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/main');
        $stateProvider
       .state('main', {
          url: '/main',
          templateUrl: 'proba.html',
          controller: 'probaCtrl'
        
         
      })
     
       .state('login', {
        url: '/login',
        templateUrl: 'login.html',
        controller: 'loginCtrl'
    });
   }
   function run($rootScope, $http, $location, $localStorage, AuthenticationService, $state) {
     
        if ($localStorage.currentUser) {
            $http.defaults.headers.common['X-Auth-Token'] = $localStorage.currentUser.token;
            
        }

    
        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
          var publicStates = ['login','main',/*'entry',*/''];
          var restrictedState = publicStates.indexOf(toState.name) === -1;
          if(restrictedState && !AuthenticationService.getCurrentUser()){
            $state.go('login');
          }
        });

        $rootScope.logout = function () {
            AuthenticationService.logout();
        }
        
        $rootScope.getCurrentUserRole = function () {
            if (!AuthenticationService.getCurrentUser()){
              return undefined;
            }
            else{
              return AuthenticationService.getCurrentUser().role;
            }
        }
        $rootScope.isLoggedIn = function () {
            if (AuthenticationService.getCurrentUser()){
              return true;
            }
            else{
              return false;
            }
        }
        $rootScope.getCurrentState = function () {
          return $state.current.name;
        }
    }

}(angular));