app.factory("userService",function($http){
    var BASE_URL="http://localhost:7070/MYSocialRest";
	var userService ={};
	userService.getAllCountry=function(){
		return $http.get(BASE_URL+"/hello/AllCountry");		
	}
	
	
	
	userService.getAllUser=function(){
		return $http.get(BASE_URL+"/user/getAllUsers");		
	}
	return userService;
});
	/*userService.createUser=function(user){
		console.log("****** inside user service--createUser()*****")
		return $http.post(BASE_URL+"/user/register",user);		
	}*/
	
