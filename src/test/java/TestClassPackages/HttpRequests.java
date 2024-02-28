package TestClassPackages;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.core.IsEqual.*;
import java.util.HashMap;

   // Test case on Creating requests , reading requests and update the request which were already created request
public class HttpRequests
{
	int id;
	@Test(priority = 1)
	void getUsers()
	{
		
		given()  
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)
		  .assertThat().body("page",equalTo(2))
		  .log().all();
		  
		  
	}
	
	
	@Test(priority = 2)
	void CreateUser()
	{
	
		 
		HashMap map1=new HashMap<String,String>();
		map1.put("name","Aishu");
		map1.put("job","software engineer");
		id=given()
		  .contentType("application/json")
		  .body(map1)
		  
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");
		
		  
		  }
	
	@Test(priority = 3,dependsOnMethods= {"CreateUser"})
	void UpdateUser()
	{
		HashMap map2=new HashMap<String,String>();
		map2.put("name","Aishwarya");
		map2.put("job","software engineer");
		given()
		  .contentType("application/json")
		  .body(map2)
		  
		.when()
		  .put("https://reqres.in/api/users/"+id)
		  
		  .then()
		  .statusCode(200)
		  .log().all();
		
		
	}
	
	
	
}
