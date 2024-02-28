package TestPackage;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
   // json schema response is in json format 
public class JsonSchemaValidation 
{
	
	@Test
	void jsonschemavalidation()
	{
		given()
		
		
		.when()
		   .get("http://localhost:3000/Animals")
		
		.then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("animalsschema.json"));
	}

}
