package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo 
{
	@Test
	public void getheaders()
	{
		given()
		
		.when()
		  .get("https://www.google.com")
		
		.then()
		   .header("Content-Type", "text/html; charset=ISO-8859-1")
		   .and()
		   .header("Server", "gws")
		   .log().headers();
	}
	
	@Test
	public void getSingleheaderinfo()
	{
		Response res = given()
		
		.when()
		  .get("https://www.google.com");
		
		String header_value = res.getHeader("Content-Type");
		System.out.println(header_value);
		
		
	}
	
	@Test
	public void getAllheaderinfo()
	{
		Response res = given()
		
		.when()
		  .get("https://www.google.com");
		
		Headers headers = res.getHeaders();
		for( Header head:headers)
		{
			System.out.println(head.getName()+"   "+head.getValue());
		}
		
	}

}
