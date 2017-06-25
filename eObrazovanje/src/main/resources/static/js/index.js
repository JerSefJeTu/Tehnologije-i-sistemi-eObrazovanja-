(function (angular) {
	var app = angular.module('app',['authentication','login','ui.router','ui.router.state.events']);


	app
    .config(config)
    .run(run);
    function config($stateProvider, $urlRouterProvider, $locationProvider) {
        $urlRouterProvider.otherwise('/student');
        $stateProvider
		.state('index', {
			url: '/',
			templateUrl: 'index.html',
			controller: 'mainCtrl'
		})
       .state('student', {
          url: '/student',
          templateUrl: 'studentFrame.html',
          


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
      .state('predavac', {
          url: '/predavac',
          templateUrl: 'predavacFrame.html'

      })
      
       .state('predavac.nastava', {
          url: '/nastava',
          templateUrl: 'predavacNastavaTop.html'

      })
          .state('predavac.nastava.kursevi', {
          url: '/kursevi',
          templateUrl: 'predavacNastavaKurs.html'

      })
      
            .state('predavac.nastava.kursevi.info', {
          url: '/info',
          templateUrl: 'predavacNastavaInfoKursa.html'

      })
      
      .state('predavac.ocene', {
          url: '/ocene',
          templateUrl: 'predavacOcene.html'

      })


       .state('login', {
        url: '/login',
        templateUrl: 'login.html',
        controller: 'loginCtrl'
    });

	
   }
    // pogledati run
   function run($rootScope, $http, $location, $localStorage, AuthenticationService, $state) {
        if ($localStorage.currentUser) {
            $http.defaults.headers.common['X-Auth-Token'] = $localStorage.currentUser.token;

        }

        $rootScope.$on('$stateChangeStart', function(e, toState  , toParams
                , fromState, fromParams) {

				var isLogin = toState.name === "login";
				if(isLogin){
				return; // no need to redirect 
				}
				
				// now, redirect only not authenticated
				
				
				
				if($rootScope.isLoggedIn()===false) {
					console.log("redirekcija na login")
				e.preventDefault(); // stop current execution
				$state.go('login');// go to login
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