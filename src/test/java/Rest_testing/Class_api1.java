package Rest_testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;
import junit.framework.Assert;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Class_api1 {
	public String url ="https://reqres.in/api/users?page=2";
	@Test (enabled = false)
	public void get_testcase() {
		Response rep =RestAssured.get(url);
		int actual = rep.statusCode();
		Assert.assertEquals(actual,200);
	}
	@Test(enabled = false)
	public void get_tc2() {
//		given().get(url).then().statusCode(200).log().all();
//		given().get(url).then().statusCode(200).body("data.id",hasItems(7));
		given().get(url).then().statusCode(200).body("data.id[2]",equalTo(9)).log().all();
	}
			
	@Test(enabled = false)
	public void get_tc3() {
		JSONObject js= new JSONObject();
		js.put("name","suresh");
		js.put("name","tester");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/users").then()
		.statusCode(201).log().all();
		
	}
		@Test(enabled = true)
		public void get_tc4() {
			given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
			
		}
		@Test(enabled = true)
		public void get_tc5() {
			given().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
			
		}
		@Test(enabled = false)
		public void get_tc6() {
		JSONObject js= new JSONObject();
		js.put("email","suresh@gmail.com");
		js.put("password","tester@123");
		given().body(js.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(200).log().all();
		
		}
		@Test(enabled = true)
		public void get_tc7() {
			JSONObject js = new JSONObject();
			js.put("email","suresh@gmail.com");
			js.put("password","tester@123");
			given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/login").then().statusCode(200).log().all();
		}
		@Test(enabled = true)
		public void get_tc8() {
			JSONObject js =new JSONObject();
			given().body(js.toJSONString()).when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
			
		}
		@Test(enabled =  true)
		public void get_tc9() {
			JSONObject js = new JSONObject();
			given().body(js.toJSONString()).when().put("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
		}
		
	}


