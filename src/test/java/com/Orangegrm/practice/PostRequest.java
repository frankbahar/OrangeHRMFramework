package com.Orangegrm.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequest {

	// @Test
	public void createStudent() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("firstName", "Enes");
		map.put("lastName", "Kanter");
		map.put("age", 45);
		map.put("batchEndDate", "2020-03-01");
		map.put("batch", 5);
		map.put("batchStartDate", "2019-09-14");
		map.put("course", "SDET");
		map.put("attendanceNature", "nj");
		map.put("streetAddress", "2 Commonwealth");
		map.put("city", "Clifton");
		map.put("state", "MA");
		map.put("id", 45);
		map.put("zipCode", "02412");

		RestAssured.baseURI = "http://pure-ravine-92491.herokuapp.com/syntax";

		Response rsp = given().accept(ContentType.JSON).header("Content-Type", "application/json").body(map).when()
				.post("/api/createStudentProfile");

		rsp.then().assertThat().statusCode(201);
		rsp.prettyPrint();

		JsonPath jsonpath = rsp.jsonPath();
		int createdId = jsonpath.getInt("id");
		System.out.println("created id is : " + createdId);
		Map<String, Object> responseMap = rsp.as(Map.class);
		System.out.println(responseMap);
	}

//	@Test
	public void updateStudent() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("firstName", "EnesU");
		map.put("lastName", "KanterU");
		map.put("age", 45);
		map.put("batchEndDate", "2020-03-01");
		map.put("batch", 5);
		map.put("batchStartDate", "2019-09-14");
		map.put("course", "SDET");
		map.put("attendanceNature", "nj");
		map.put("streetAddress", "2 Commonwealth");
		map.put("city", "Boston");
		map.put("state", "NJ");
		map.put("id", 367);
		map.put("zipCode", "12412");

		RestAssured.baseURI = "https://pure-ravine-92491.herokuapp.com/syntax";

		Response rsp = given().accept(ContentType.JSON).header("Content-Type", "application/json").body(map).when()
				.put("/api/updateStudentProfile");

		rsp.then().assertThat().statusCode(200);

		rsp.prettyPrint();

		JsonPath jsonpath = rsp.jsonPath();
		int createdId = jsonpath.getInt("id");
		System.out.println("created id is : " + createdId);
		Map<String, Object> responseMap = rsp.as(Map.class);
		System.out.println(responseMap);
	}

	@Test
	public void deleteStudent() {

		RestAssured.baseURI = "https://pure-ravine-92491.herokuapp.com/syntax";

		Response rsp = 
				given().pathParams("studentId", "367").
				when().delete("/api/deleteStudentProfile/{studentId}");
			
		rsp.then().assertThat().statusCode(200);

		rsp.prettyPrint();
		

	}
}