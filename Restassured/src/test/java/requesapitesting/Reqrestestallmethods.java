package requesapitesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Reqrestestallmethods
{
  
    @Test
    public void getUserList() {
        Response responseGet = RestAssured.given().when().get("https://reqres.in/api/unknown");
        responseGet.prettyPrint();
        responseGet.statusCode();
        int statusCode = responseGet.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        
    }

    @Test
    public void getByID() {
        Response responseGetId = RestAssured.given().when().get("https://reqres.in/api/users/2");
        responseGetId.prettyPrint(); 
        JsonPath newData = responseGetId.jsonPath();
        String first_name = newData.get("first_name");
        Assert.assertEquals(first_name, "Janet");
        
    }

    @Test
    public void deleteUser() {
    	Response responseDel = RestAssured.given().when().delete("https://reqres.in/api/users/5");
        responseDel.prettyPrint();
        responseDel.getStatusCode();
        int statusCode1 = responseDel.getStatusCode();
        Assert.assertEquals(statusCode1, 200);
        
    }

    @Test
    public void updateUser() {
        String payloadUpdate = "{\n" + "    \"name\": \"Capper\",\n" + "    \"job\": \"SDET\"\n" + "}\n";

        Response responseUp = RestAssured.given().header("Content-Type", " application/json").body(payloadUpdate).when()
                .put("https://reqres.in/api/users/2");
        responseUp.prettyPrint();
        responseUp.getStatusCode();
        int statusCode2 = responseUp.getStatusCode();
        Assert.assertEquals(statusCode2, 200);
    }
}
