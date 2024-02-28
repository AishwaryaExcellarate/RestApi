package Apichaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser 
{
	@Test
	void deleteuser(ITestContext context)
	{
		
		String bearertoken="55b9b2c48e8ab7e6ad8c373fc589fb996aa5b3133c45384ac11c75e79652e097";
		
		//int id=(Integer) context.getAttribute("user_id"); // this should come from create request
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
		  .headers("Authorization","Bearer "+bearertoken)
		  .pathParam("id", id)
		
		.when()
		  .delete("https://gorest.co.in/public/v2/users/{id}")
		  
		  .then()
		    .statusCode(204)
		    .log().all();
		
		
	}

}
