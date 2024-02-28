package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo 
{
	//@Test
	public void testonCookies()
	{
		given()
		
		.when()
		   .get("https://www.google.com")
		
		.then()
		  .log().all();
	}
	
	//@Test
	public void getSinglecookieinfo()
	{
		Response res = given()
		
		.when()
		 .get("https://www.google.com");
		
		String cookie_value = res.cookie("AEC");
		System.out.println("value of cookie===="+cookie_value);
		 
	}
	//@Test
	public void getAllcookies()
	{
		Response res = given()
		
		.when()
		 .get("https://www.google.com");
		
		Map<String, String> cookie_values = res.getCookies();
		System.out.println(cookie_values.keySet());
		 
	}
	
	@Test
	public void getDetailedcookies()
	{
		Response res = given()
		
		.when()
		 .get("https://www.google.com");
		
		Map<String, String> cookie_values = res.getCookies();
		
		 for( String c:cookie_values.keySet())
		 {
			 String cookies = res.getCookie(c);
			 System.out.println("All cookies===="+cookies);
		 }
	}

}
