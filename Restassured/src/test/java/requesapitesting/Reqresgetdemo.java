package requesapitesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class Reqresgetdemo 
{
	@Test
	void testGetUsersPage1()
	{
	
		Response response = get("https://reqres.in/api/users?page=1");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.asString());
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void GetUsersPage2()
	{
Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.asString());
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	

}