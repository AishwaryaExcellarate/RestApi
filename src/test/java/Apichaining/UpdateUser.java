package Apichaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser 
{
	@Test
	void updateuser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearertoken="55b9b2c48e8ab7e6ad8c373fc589fb996aa5b3133c45384ac11c75e79652e097";
		//int id=(Integer) context.getAttribute("user_id");  //this should come from create request 
		int id=(Integer) context.getSuite().getAttribute("user_id");
	      given()
		    .headers("Authorization","Bearer "+bearertoken)
		    .contentType("application/json")
		    .pathParam("id", id)
		    .body(data.toString())
		    
		    .when()
		       .put("https://gorest.co.in/public/v2/users/{id}")
		       
		    .then()
		       .statusCode(200)
		       .log().all();
	      
		       
	}

}
