(function (angular) {
	var app = angular.module('app',['authentication',
	'login','ui.router','student','main']);


	app
    .config(config)
    .run(run);
    function config($stateProvider, $urlRouterProvider, $locationProvider) {
        //$urlRouterProvider.otherwise('/index');
        $stateProvider
		.state('index', {
			url: '/',
			templateUrl: 'index.html',
			controller: 'mainCtrl'
		})
       .state('student', {
          url: '/student',
          templateUrl: 'studentFrame.html',
          controller: 'studentCtrl'


      })
      .state('student.studije', {
          url: '/studije',
          templateUrl: 'studentStudije.html'



      })
      .state('student.finansije', {
          url: '/finansije',
          templateUrl: 'studentFinansije.html'



      })
      .state('student.profil', {
          url: '/profil',
          templateUrl: 'studentProfil.html'



      })

       .state('login', {
        url: '/login',
        templateUrl: 'login.html',
        controller: 'loginCtrl'
    });

	$locationProvider.html5Mode(true);
   }
    // pogledati run
   function run($rootScope, $http, $location, $localStorage, AuthenticationService, $state) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common['X-Auth-Token'] = $localStorage.currentUser.token;

        }

        /*$rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
          var publicStates = ['login','main','entry',''];
          var restrictedState = publicStates.indexOf(toState.name) === -1;
          if(restrictedState && !AuthenticationService.getCurrentUser()){
            $state.go('login');
          }
        });*/

        $rootScope.$on("$routeChangeStart", function(event){
        	if(!AuthenticationService.isLoggedIn()) {
				event.preventDefault();
				$state.go('login');
			} else {
				console.log("ULOGOVAn");
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
		/*
        $rootScope.isLoggedIn = function () {
            if (AuthenticationService.getCurrentUser()){
              return true;
            }
            else{
              return false;
            }
        }
		*/
        $rootScope.getCurrentState = function () {
          return $state.current.name;
        }
    }

}(angular));