package Apichaining;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser
{
	@Test
	void getuser(ITestContext context)
	{
		//int id=(Integer) context.getAttribute("user_id");        //this should come from create user request
		int id=(Integer) context.getSuite().getAttribute("user_id");
		String bearertoken="55b9b2c48e8ab7e6ad8c373fc589fb996aa5b3133c45384ac11c75e79652e097";
		given()
		   .headers("Authorization","Bearer "+bearertoken)
		   .pathParam("id", id)
		
		.when()
		   .get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		   .statusCode(200)
		   .log().all();
	}

}
