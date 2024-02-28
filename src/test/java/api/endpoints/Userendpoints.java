package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//created for crud operations here creating only endpoints methods
public class Userendpoints
{
	public static Response createUser(User payload)
	{
	Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .header("Content-Type","application/json")
		  .body(payload)
		  
		.when()
		  .post(Routes.userposturl);
		
		 return response;
	}
	public static Response readUser(String userName)
	{
	Response response=given()
			            .pathParam("username", userName)
		  
		
		.when()
		  .get(Routes.usergeturl);
		
		 return response;
	}
	public static Response updateUser(String userName, User payload)
	{
	Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .pathParam("username", userName)
		  .body(payload)
		
		.when()
		  .put(Routes.userupdateurl);
		
		 return response;
	}
	public static Response deleteUser(String userName)
	{
	Response response=given()
			            .pathParam("username", userName)
		  
		
		.when()
		  .delete(Routes.userdeleteurl);
		
		 return response;
	}	

}
