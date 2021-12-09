package requesapitesting;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class ReqresPatchdemo
{
	@Test 
	public void testCreateUser()
	{
		Map<String, Object > map = new HashMap<String, Object>();

		map.put("name","Capper");
		map.put("job", "SDET");

		System.out.println(map);

		JSONObject request = new JSONObject(map);
	

		given().
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201).log().all();
	}

	@Test 
	public void testEditUser()
	{		
		JSONObject request = new JSONObject();

		request.put("name", "Santosh");
		request.put("Job", "Assosiate Test Manager");

		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
		
	}

	}
