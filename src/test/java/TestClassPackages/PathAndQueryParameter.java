package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

  // Testcase on Path and query parameter
public class PathAndQueryParameter 
{
	@Test
	 void testPathandQueryParameter()
	 {
		//https://reqres.in/api/users?page=2
		given()
		 .pathParam("mypath", "users")  //path parameter
		 .queryParam("page", 2)         //query parameter
		 .queryParam("id", 5)           //query parameter
		.when()
		  .get("https://reqres.in/api/{mypath}")
		.then()
		.statusCode(200)
		.log().all();
	 }

}
