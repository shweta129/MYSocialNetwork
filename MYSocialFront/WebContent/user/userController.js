app.controller('loginController', function($scope) {
	$scope.message = 'Look! I am an login page.';
});

app.controller('registrationController', function($scope,userService) {
	$scope.message = 'Look! I am an registration page.';
	
	userService.getAllCountry().then(function(response){
		$scope.countries=response.data
		console.log("Country List::"+$scope.countries);
		})
	
});
