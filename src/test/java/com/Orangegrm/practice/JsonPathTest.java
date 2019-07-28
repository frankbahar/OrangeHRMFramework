package com.Orangegrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathTest {
	//retrieve value of specific key from JSON object
	
	//@Test
	public void rettrieveJSONValue() {
		RestAssured.baseURI= "https://pure-ravine-92491.herokuapp.com/syntax";
		Response resp = 
		given().pathParam("studentId", "123").
		when().get("/api/getStudentProfile/{studentId}");
		resp.prettyPrint();
		
		resp.
		then().assertThat().statusCode(200).
		and().assertThat().body("firstName", equalTo("Vladimir"));
		JsonPath jPath = resp.jsonPath();
		String firstName = jPath.get("firstName");
		System.out.println(firstName);
		System.out.println(jPath.getString("lastName"));
	}
	
//	@Test
	public void retrieveAllStudent() {
		RestAssured.baseURI= "https://pure-ravine-92491.herokuapp.com/syntax";
		Response resp = 
		given().
		when().get("/api/getAllStudentProfiles");
		resp.prettyPrint();
		
		JsonPath jPath = resp.jsonPath();
	//	String firstName = jPath.get("firstName");
	//	System.out.println(firstName);
		System.out.println(jPath.getString("lastName[2]"));
	
//		resp.
	//	then().assertThat().statusCode(200).
		//and().assertThat().body("firstName", equalTo("Vladimir"));

		List<String> fnames = jPath.get("firstName");
		for(String fname:fnames) {
			System.out.println(fname);
		}
	}
	
	//
	
	@Test
	public void verifyStudents() {
		RestAssured.baseURI= "https://pure-ravine-92491.herokuapp.com/syntax";
		Response resp = 
		given().
		when().get("/api/getAllStudentProfiles");
		resp.then().statusCode(200);
		JsonPath jPath = resp.jsonPath();
		String firstName = jPath.get("firstName[1]");
		System.out.println("First name of Second student is " + firstName);
		List<String> lNames = jPath.get("lastName");
		System.out.println("All student's Last Names");
		for(String lName:lNames)
			System.out.println(lName);
			
	}
}
