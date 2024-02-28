package Apichaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser
{
	@Test
	void createuser(ITestContext context)
	{
		//55b9b2c48e8ab7e6ad8c373fc589fb996aa5b3133c45384ac11c75e79652e097
		Faker  faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearertoken="55b9b2c48e8ab7e6ad8c373fc589fb996aa5b3133c45384ac11c75e79652e097";
	int id=given()
		   .headers("Authorization","Bearer "+bearertoken)
		   .contentType("application/json")
		   .body(data.toString())
		
		.when()
		   .post("https://gorest.co.in/public/v2/users") 
		   .jsonPath().getInt("id");
	
	  System.out.println("generated id is:"+id);
	  
	  //context.setAttribute("user_id", id); // this will execute in testlevel
	  context.getSuite().setAttribute("user_id", id);
		
	
		    
		
	}

}
