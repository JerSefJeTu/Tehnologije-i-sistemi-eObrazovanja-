(function (angular) {
	var app = angular.module('app',['authentication','login','ui.router','ui.router.state.events','predavac', 'student', 'ocene','admin']);

	app
    .config(config)
    .directive("tooltip", function(){
    	return {
	        restrict: 'A',
	        link: function(scope, element, attrs){
	            $(element).hover(function(){
	                $(element).tooltip('show');
	            }, function(){
	                $(element).tooltip('hide');
	            });
	        }
    	}
    })
    .run(run);
    function config($stateProvider, $urlRouterProvider, $locationProvider) {



        $stateProvider
		.state('index', {
			url: '/',
			templateUrl: 'index.html',
			controller: 'mainCtrl'
		})
       .state('student', {
          url: '/student',
          templateUrl: 'studentFrame.html',
		  controller: 'StudentsCtrl'
      })
        .state('admin',{
            url: '/admin',
            templateUrl: 'adminFrame.html'
        })
        .state('admin.studenti',{
            url: '/studenti',
            templateUrl: 'adminStudenti.html',
            controller:'AdminCtrl'
        })
        .state('admin.predavaci',{
            url: '/predavaci',
            templateUrl: 'adminPredavaci.html'
            	
        })
      .state('student.studije', {
          url: '/studije',
          templateUrl: 'studentStudije.html'



      })
      .state('student.finansije', {
          url: '/finansije',
          templateUrl: 'studentFinansije.html',
          controller:'uplateController'

      })
      .state('student.profil', {
          url: '/profil',
          templateUrl: 'studentProfil.html',
          controller: 'StudentsCtrl'
      })
      .state('predavac', {
          url: '/predavac',
          templateUrl: 'predavacFrame.html'


      })

       .state('predavac.nastava', {
          url: '/nastava',
          templateUrl: 'predavacNastavaTop.html',
          controller:'PredavacCtrl'


      })
          .state('predavac.nastava.kursevi', {
          url: '/kursevi',
          templateUrl: 'predavacNastavaKurs.html',
          controller:'kursCtrl'


      })

        .state('predavac.nastava.kursevi.info', {
          url: '/info',
          templateUrl: 'predavacNastavaInfoKursa.html',
          controller:'kursCtrl'


      })

      .state('predavac.ocene', {
          url: '/ocene',
          templateUrl: 'predavacOceneTop.html',
		  controller: 'OceneCtrl'
      })

	  .state('predavac.ocene.kurs', {
		  url: '/kurs',
		  templateUrl: 'predavacOceneKurs.html'
	  })

	  .state('predavac.ocene.kurs.information', {
		  url: '/information',
		  templateUrl: 'predavacOceneInfoKursa.html'
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
