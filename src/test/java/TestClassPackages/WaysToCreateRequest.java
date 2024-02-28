package TestClassPackages;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.HashMap;
   // Different ways to create Request 1) By using Hashmap object which is in key and value pair.
public class WaysToCreateRequest
{
	int id;
	
	//@Test
	void testPostUsingHashMap()
	{
		HashMap data =new HashMap<String, String>();
		data.put("name", "John");
		data.put("place", "France");
		String	coursearr[] = {"java","c++"};
	    data.put("courses", coursearr);
	  
	    
	    id=given()
	      .contentType("application/json")
	      .body(data)
	      .log().all()
	      
	    .when()
	      .post("http://localhost:3000/Students")
	      .jsonPath().getInt("id");
	    
	  
	}
	
	   // deleting the student record
	       @Test   
	        void  testDeleteUser()
	     {
	           given()
	          
	          .when()
	    	   .delete("http://localhost:3000/Students/16");
	    	   
	    	   
	    	   
	    	 
	     }
 
} 
