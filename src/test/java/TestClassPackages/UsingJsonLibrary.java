package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class UsingJsonLibrary
{
	//@Test
	void testPostUsingJsonLibrary()
	{
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("place", "Rome");
		String coursesarr[]= {"RestApi","Python"};
		data.put("courses", coursesarr);
		
		given()
	      .contentType("application/json")
	      .body(data.toString())
	      
	      
	    .when()
	      .post("http://localhost:3000/Students")
	      
	      .then()
	       .statusCode(201)
	       .log().all();
	      
	      
	      }
	
	@Test
	public void testDeleteUsingJsonLibrary()
	{
		given()
		 .when()
		   .delete("http://localhost:3000/Students/16");
		   
		  
		   
		   
	}

}
