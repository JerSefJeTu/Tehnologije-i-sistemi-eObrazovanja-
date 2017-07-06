(function (angular) {
	angular.module('login',['authentication'])
	.controller('loginCtrl', function($scope, $log, AuthenticationService){
		$scope.user={};
		$scope.login=function () {
			AuthenticationService.login($scope.user,loginCbck);
		};
		function loginCbck(success) {
			if (success) {
				$log.info('success!');
			}
			else{
				$scope.errormsg="Pogresan username ili password";
				
            	$scope.user.username="";
            	$scope.user.password="";
				$log.info('failure!');
			}
		}
	});
}(angular));
