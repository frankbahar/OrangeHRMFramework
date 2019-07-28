package com.Orangegrm.practice;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class HeaderTest {
	/*
	 * when I send GET request to the "/api/getAllStudentProfiles"
	 * Then response status code is 200
	 * And response header "Content-Type" contains " application/json";
	 */
	@Test
	public void verifyStudents() {
		RestAssured.baseURI= "https://pure-ravine-92491.herokuapp.com/syntax";
		Response resp = 
		given().
		when().get("/api/getAllStudentProfiles");
	
		resp.then().statusCode(200).
		and().header("Content-Type", equalTo("application/json;charset=UTF-8"));
		
	 }
}
