package RestApiAzure;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class RestApiAzureDemo {
	@Test
	public void restApiGetAuthorsList()
	{
	Response responseGet =  RestAssured.given().when().get("https://fakerestapi.azurewebsites.net/api/v1/Authors");
    responseGet.statusCode();
    responseGet.getTime();
    responseGet.prettyPrint();
    int statusCode = responseGet.getStatusCode();
    Assert.assertEquals(statusCode, 200);
    
	}
	@Test
	public void restApiGetAuthorByID()
	{
		Response responseup = given().when().get("https://fakerestapi.azurewebsites.net/api/v1/Authors/3");
		responseup.prettyPrint();
		JsonPath newData = responseup.jsonPath();
        String firstname = newData.get("firstName");
        Assert.assertEquals(firstname, "First Name 3");
		
	}
	@Test
	public void restApiAddBook()
	{
		String payloadUpdate = "{\n" + "    \"id\": \"666\",\n" + "    \"title\": \"stringer\",\n" + "  \"description\": \"stringer\",\n" + "    \"pageCount\": \"300\",\n" + "    \"excerpt\": \"string\",\n" + "      \"publishDate\": \"2021-12-06T17:29:50.579Z\"\n" + "}\n";
        Response responseUp = RestAssured.given().header("Content-Type", " application/json").body(payloadUpdate).when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Books");
        responseUp.prettyPrint();
        responseUp.getStatusCode();
        int statusCode1 = responseUp.getStatusCode();
        Assert.assertEquals(statusCode1, 200);
	
	}
	@Test
	public void userDeleteById()
	{
		Response responseDel = RestAssured.given().when().delete("https://fakerestapi.azurewebsites.net/api/v1/Users/55");
        responseDel.prettyPrint();
        responseDel.getStatusCode();
        responseDel.prettyPrint();
        int statusCode2 = responseDel.getStatusCode();
        Assert.assertEquals(statusCode2, 200);
        
	}
}
