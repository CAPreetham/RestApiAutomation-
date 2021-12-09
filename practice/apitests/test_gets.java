package apitests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class test_gets {

	@Test
	public void test1()
	{
		given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			log().all();
			
	}
}
