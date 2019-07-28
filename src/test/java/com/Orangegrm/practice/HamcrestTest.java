package com.Orangegrm.practice;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

public class HamcrestTest {
	/*
	 * Retrieve quote of specific character (varys) and verify that response code is 200 
	 * and response contains "Power resides where men believe it resides" 
	 */
//	@Test
	public void verifyResponse() {
		RestAssured.baseURI = "https://got-quotes.herokuapp.com";
		
		// 1 way using JUnit assertions
		  Response rsp = 
		  given().queryParam("char", "varys"). 
		  when().get("/quotes");
		  String responseBody = rsp.asString(); System.out.println(responseBody);
		  Assert.assertEquals(200, rsp.getStatusCode());
		  Assert.assertTrue(responseBody.contains("Varys"));
		  
		 //2 way to complete request and assertions 
		 given().queryParam("char", "varys"). 
		 when().get("/quotes").
		 then().assertThat().statusCode(200).
		 and().assertThat().body("character", equalTo("Varys"));
		 
		 //3
		 Response rsp1 = 
		 given().queryParam("char", "varys"). 
		 when().get("/quotes");
		 rsp1.then().
		 assertThat().statusCode(200).
		 and().assertThat().body("character", equalTo("Varys"));
	}
	
	 //retrieve student with id 123 & verify that response code is 200 and first name is Vladimir 
	@Test
	public void verifyStudent() {
		RestAssured.baseURI= "https://pure-ravine-92491.herokuapp.com/syntax";
		given().pathParam("studentId", "123").
		when().get("/api/getStudentProfile/{studentId}").
		then().assertThat().statusCode(200).
		and().assertThat().body("firstName", equalTo("Vladimir"));
	}
}
