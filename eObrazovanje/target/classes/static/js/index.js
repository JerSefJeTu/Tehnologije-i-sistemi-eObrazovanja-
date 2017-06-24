(function (angular) {
	var app = angular.module('app',['proba','login','ui.router', 'authentication']);
	
	
	app
    .config(config)
    .run(run);
    function config($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/student');
        $stateProvider
       .state('student', {
          url: '/student',
          templateUrl: 'studentFrame.html',
          controller: 'probaCtrl'
        
         
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
   }
   function run($rootScope, $transitions, $http, $location, $localStorage, AuthenticationService, $state) {
     
        if ($localStorage.currentUser) {
            $http.defaults.headers.common['X-Auth-Token'] = $localStorage.currentUser.token;
            
        }

        /*$rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            var publicStates = ['login','main','entry',''];
            var restrictedState = publicStates.indexOf(toState.name) === -1;
            console.log("SEGEDINAC!!!");
            if(restrictedState && !AuthenticationService.getCurrentUser()){
              $state.go('login');
            }
          });*/
        
        $transitions.onStart({} , function() {
        	  //var $state = trans.router.stateService;
        	  //var MyAuthService = trans.injector().get('MyAuthService');

        	  // If the user is not authenticated
        	  /*if (!MyAuthService.isAuthenticated()) {

        	    // Then return a promise for a successful login.
        	    // The transition will wait for this promise to settle

        	    return MyAuthService.authenticate().catch(function() {

        	      // If the authenticate() method failed for whatever reason,
        	      // redirect to a 'guest' state which doesn't require auth.
        	      return $state.target("guest");
        	    });
        	  }*/
        	  console.log("TRANSITIONS!!!");
        	});
        
        $rootScope.$on('$stateChangeStart', function(e, toState  , toParams
                , fromState, fromParams) {

        		console.log("STATE CHANGED!!!");
        	
				var isLogin = toState.name === "login";
				if(isLogin){
				return; // no need to redirect 
				}
				
				// now, redirect only not authenticated
				
				if($rootScope.isLoggedIn() === false) {
				e.defaultPrevented(); // stop current execution
				$state.go('login');// go to login
				}
				});
    
        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
          var publicStates = ['login','student',/*'entry',*/''];
          console.log("PERAAAA!!!");
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