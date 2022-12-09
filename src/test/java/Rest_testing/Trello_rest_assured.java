package Rest_testing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Trello_rest_assured {
	public String url ="https://api.trello.com";
	public String key="e81687031a92bd7e871327beb2059d04";
	public String token ="65626d76d506dea6ec0f7099045bead2b08ded85581e8fa5b952cb63816ccc02";
	public String id;
	public String str;
	
 //create board
	@Test(enabled = true)
	public void get_tc2() {
		RestAssured.baseURI=url;
		Response response=given().queryParam("name", "suresh68")
			.queryParam("key", key)
			.queryParam("token", token)
			.header("Content-Type", "application/json")
			.when()
			.post("/1/boards/")
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
			String jsonresponse = response.asString();
			JsonPath js= new JsonPath(jsonresponse);
			
			id = js.get("id");
			System.out.println(id);
	
	}
	//delete board
	@Test(enabled = true)
	public void get_tc3() {
		JSONObject  js = new JSONObject();
		given().queryParam("name", "suresh68")
		.queryParam("key", key)
		.queryParam("token", token)
		.header("Content-Type", "application/json")
		.when()
		.delete("/1/boards/"+id)
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
	}
	}
