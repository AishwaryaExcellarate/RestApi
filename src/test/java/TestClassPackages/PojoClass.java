package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
   // Test case on pojo by using pogoclass request
public class PojoClass
{
	@Test
	void testUsingPojo()
	{
		PojoRequest data=new PojoRequest();
		data.setName("Scott");
		data.setPlace("Rome");
		String coursearr[]= {"RestApi","Python"};
		data.setCourse(coursearr);
		
		
		given()
	      .contentType("application/json")
	      .log().all()
	      .body(data)
	      
	      
	    .when()
	      .post("http://localhost:3000/Students");
	      
	      
	        
	}

}
