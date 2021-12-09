package apitests;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_all {
  
    @Test
    public void get() {
        Response responseGet = RestAssured.given().when().get("https://reqres.in/api/unknown");
        responseGet.prettyPrint();
    }

    @Test
    public void geter() {
        Response responseGetId = RestAssured.given().when().get("https://reqres.in/api/users/2");
        responseGetId.prettyPrint();
    }

    @Test
    public void delete() {
        Response responseDel = RestAssured.given().when().delete("https://reqres.in/api/users/3");
        responseDel.prettyPrint();
    }

    @Test
    public void update() {
        String payloadUpdate = "{\n" + "    \"name\": \"Capper\",\n" + "    \"job\": \"SDET\"\n" + "}\n";

        Response responseUp = RestAssured.given().header("Content-Type", " application/json").body(payloadUpdate).when()
                .put("https://reqres.in/api/users/2");
        responseUp.prettyPrint();
    }
}
