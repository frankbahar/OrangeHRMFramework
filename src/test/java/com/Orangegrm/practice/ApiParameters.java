package com.Orangegrm.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//import org.junit.Assert;
import org.junit.Test;

public class ApiParameters {

	// @Test
	public void queryParameters() {
		RestAssured.baseURI = "https://reqres.in/";

		Response resp = given().queryParam("page", "2").when().get("/api/users");
		// jUnit
	//	Assert.assertEquals(200, resp.getStatusCode());
	//	Assert.assertTrue(resp.asString().contains("Tracey"));
	}

	//@Test
	public void pathParameters() {

		RestAssured.baseURI = "https://reqres.in";

		given().pathParam("id", "3").
		when().get("/api/users/{id}").
		then().statusCode(200);

	}
	
	//@Test
	public void pathParametersTest(
			) {

		RestAssured.baseURI = "https://pure-ravine-92491.herokuapp.com/syntax";

		given().pathParam("studentId", "92").
		when().get("/api/getStudentProfile/{studentId}").
		prettyPrint();

	}
	
	//@Test
	public void queryParametersTest() {
		RestAssured.baseURI = "https://got-quotes.herokuapp.com";
		given().queryParam("char", "tyrion").
		when().get("/quotes").
		then().statusCode(200);
	}
	
	@Test
		public void getwithassertion() {

			RestAssured.baseURI = "https://pure-ravine-92491.herokuapp.com/syntax";

			given().pathParam("studentId", "92").
			when().get("/api/getStudentProfile/{studentId}").
			then().assertThat().body("firstName", equalTo("Peter"));

		}
}
