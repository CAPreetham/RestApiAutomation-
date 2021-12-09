package RestApiAzure;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAPIAzureBooks {
	@Test
	public void restApiGetBookByID()
	{
		Response responseup = given().when().get("https://fakerestapi.azurewebsites.net/api/v1/Books/5");
		responseup.prettyPrint();
		JsonPath newData = responseup.jsonPath();
        String title = newData.get("title");
        Assert.assertEquals(title, "Book 5");
        
	}
	@Test
	public void restApiAddBook()
	{
		String payloadUpdate = "{\n" + "    \"id\": \"777\",\n" + "    \"title\": \"stringers\",\n" + "  \"description\": \"stringers\",\n" + "    \"pageCount\": \"350\",\n" + "    \"excerpt\": \"stringers\",\n" + "      \"publishDate\": \"2021-12-06T17:29:50.579Z\"\n" + "}\n";
        Response responseUp = RestAssured.given().header("Content-Type", " application/json").body(payloadUpdate).when()
                .post("https://fakerestapi.azurewebsites.net/api/v1/Books");
        responseUp.prettyPrint();
        responseUp.getStatusCode();
        int statusCode1 = responseUp.getStatusCode();
        Assert.assertEquals(statusCode1, 200);
	
	}
		
	@Test
	public void restApiEditBook()
	{
		String payloadUpdate = "{\n" + "    \"id\": \"5\",\n" + "    \"title\": \"stringers\",\n" + "  \"description\": \"stringers\",\n" + "    \"pageCount\": \"350\",\n" + "    \"excerpt\": \"stringers\",\n" + "      \"publishDate\": \"2021-12-06T17:29:50.579Z\"\n" + "}\n";
        Response responseUp = RestAssured.given().header("Content-Type", " application/json").body(payloadUpdate).when()
                .put("https://fakerestapi.azurewebsites.net/api/v1/Books/5");
        responseUp.prettyPrint();
        responseUp.getStatusCode();
        int statusCode1 = responseUp.getStatusCode();
        Assert.assertEquals(statusCode1, 200);
	}
	public void DeleteBookById()
	{
		Response responseDel = RestAssured.given().when().delete("https://fakerestapi.azurewebsites.net/api/v1/Books/5");
        responseDel.prettyPrint();
        responseDel.getStatusCode();
        responseDel.prettyPrint();
        int statusCode2 = responseDel.getStatusCode();
        Assert.assertEquals(statusCode2, 200);
        
	}
	@Test
	public void restApiGetBooksList()
	{
	Response responseGet =  RestAssured.given().when().get("https://fakerestapi.azurewebsites.net/api/v1/Books");
    responseGet.statusCode();
    responseGet.getTime();
    responseGet.prettyPrint();
    int statusCode = responseGet.getStatusCode();
    Assert.assertEquals(statusCode, 200);
	}
	
}
