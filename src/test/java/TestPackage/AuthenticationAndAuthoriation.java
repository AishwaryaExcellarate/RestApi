package TestPackage;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
  // Authentication - user is valid or not Authorization - check access

import org.testng.annotations.Test;
public class AuthenticationAndAuthoriation
{
	//@Test(priority = 1)
	void testBasicauth()
	{
		given()
		  //.auth().basic("postman", "password")
		   .auth().digest("postman", "password")
		  // .auth().preemptive().basic("postman", "password")
		
		.when()
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		  .statusCode(200)
		  .body("authenticated", equalTo(true))
		  .log().all();
		  
	}
	
	//@Test(priority = 2)
	void testBaererToken()
	{
		String bearertoken="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";
		given()
		   .headers("Authorization", "Bearer "+bearertoken )
		
		.when()
		  .get("https://api.github.com/user/repos")
		
		.then()
		  .statusCode(200)
		  .log().all();
	}
	
	// deveoper will give this details of all consumer key , secret code , and access token then only we can use this authentication
	//@Test
	void testOauth() 
	{
		given()
		   .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
		
		.when()
		   .get("https://api.github.com/user/repos")
		
		.then()
		  .statusCode(200)
		  .log().all();
		
	}
	//@Test(priority = 3)
	void testOauth2()
	{
		given()
		   .auth().oauth2("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")
		
		.when()
		  .get("https://api.github.com/user/repos")
		
		.then()
		  .statusCode(200)
		  .log().all();
	}

}
