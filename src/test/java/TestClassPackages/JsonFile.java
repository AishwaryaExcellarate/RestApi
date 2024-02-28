package TestClassPackages;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class JsonFile 
{
	@Test
	 // Testcase on Post request using external json file
	void testPostUsingJson() throws FileNotFoundException
	{
		File f=new File(".\\Body.json");     // To open the file from io library
		FileReader fr=new FileReader(f);    // To read the data from file from io library
		JSONTokener jt=new JSONTokener(fr);  //from org library
		JSONObject data=new JSONObject(jt);
		
		given()
		  .contentType("application/json")
		  .body(data.toString())
		  
		  .when()
		    .post("http://localhost:3000/Students")
		    
		    .then()
		    .statusCode(201)
		    .log().all();
		
	}

}
