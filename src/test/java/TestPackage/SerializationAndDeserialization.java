package TestPackage;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import TestClassPackages.PojoRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class SerializationAndDeserialization
{
	  // Testcase on serialiation converting pojo class into json object
	//step 1- created student pojo class
	//step 2-created object for student pogo class
	//step 3- convert java object to json object
	//@Test
	public void convertPojoToJson() throws JsonProcessingException
	{
		Student studentdata=new Student();
		studentdata.setName("Scott");
		studentdata.setPlace("Rome");
		
		
		ObjectMapper objmappr=new ObjectMapper();
		String jsondata = objmappr.writerWithDefaultPrettyPrinter().writeValueAsString(studentdata);
		System.out.println(jsondata);
	}
	
	@Test
	public void convertJsonToPojo() throws JsonMappingException, JsonProcessingException
	{
		String jsonData ="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"place\" : \"Rome\"\r\n"
				+ "}";
		
		ObjectMapper objmapper=new ObjectMapper();
		Student stupojo = objmapper.readValue(jsonData, Student.class);
		System.out.println("Name:"+stupojo.getName());
		System.out.println("Place:"+stupojo.getPlace());
		
	}

}
