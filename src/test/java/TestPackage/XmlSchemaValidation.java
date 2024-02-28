package TestPackage;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 // xml schema respinse is in xsd format

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
public class XmlSchemaValidation
{
	@Test
	public void testxmlschemavalidation()
	{
		given()
		
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
		   .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
	}

}
