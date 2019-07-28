package com.Orangegrm.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiGetDemo {
	//@Test
	public void getWeather() {
		//get method will give you back response
		Response response = RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/Fairfax");
		response.prettyPrint();
		int code = response.getStatusCode();
		System.out.println(code);
	}
	
	//get status and print response from country API
	@Test
	public void getCountry() {
		//get method will give you back response
		Response response = RestAssured.get("http://restcountries.eu/rest/v1/name/Turkey");
		
		//response.prettyPrint();
		int code = response.getStatusCode();
		Assert.assertEquals(200,code);
		
		//retrieve body response as String
		String body = response.asString();
		System.out.println("Response body : " + body);
		Assert.assertTrue(body.contains("Ankara"));
		
		//retrieve body header date as String
		String header = response.getHeader("Date");
		System.out.println(header);
	}
	
	

}
