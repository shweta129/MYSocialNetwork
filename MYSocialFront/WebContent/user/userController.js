app.controller('loginController', function($scope) {
	$scope.message = 'Look! I am an login page.';
});

app.controller('registrationController', function($scope,userService) {
	$scope.message = 'Look! I am an registration page.';
		
	$scope.user={userID:'',firstName:'',lastName:'',password:'',email:'',Status:'',isOnline:'',contactNumber:'',address:'',dob:'',role:'',successMessage:'',errorMesssage:''};
	
	$scope.register= function(){
		
		console.log("**********in side the resgietr method****");
		userService.createUser($scope.user).then(function(response){
			console.log("Registerd Successfully");
			$scope.user.successMessage="Registerd Successfully";
			
		},function(error){
			console.error("Error while creating user");
			$scope.user.successMessage="Error while creating user";
		})
		
		
	}
	
	userService.getAllUser().then(function(response){
		$scope.users=response.data
		console.log("User List::"+$scope.users);
		})
	
});
