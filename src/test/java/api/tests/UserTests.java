package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests 
{
	Faker faker;
	User userPayload;
	
	@BeforeTest
	public void setup()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test
	public void testPostUser()
	{
		Response response = Userendpoints.createUser(userPayload);
		response.then().log().all();
		//Assert.assertEquals(response.getStatusCode(), 200);

		
	}
	//@Test
	public void testGetuserByname()
	{
		Response response = Userendpoints.readUser(this.userPayload.getUsername());
		response.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void updateuserByName()
	{
		
		//update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = Userendpoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after  updated
		Response responseafterupdate = Userendpoints.readUser(this.userPayload.getUsername());
		responseafterupdate.then().log().all();
		//Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		
	}

}
