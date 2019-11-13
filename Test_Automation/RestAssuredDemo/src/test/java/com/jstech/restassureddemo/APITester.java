package com.jstech.restassureddemo;

import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.given;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Pet;

public class APITester {

	RestAssuredHelper rah = new RestAssuredHelper();

	@Test
	public void testStatusCode() {
		String url = "https://petstore.swagger.io/#/pet/81582912969613913";
		RequestSpecification httpRequest = rah.sendRequest(url);

		Response response = httpRequest.request(Method.GET);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
	}

	@Test
	public void testPostWithPojo() throws JsonProcessingException {
		String url = "https://petstore.swagger.io/v2/pet";
		RequestSpecification httpRequest = rah.sendRequest(url);
		Pet pet = new Pet(8245, "Sally", "pending");
		ObjectMapper mapper = new ObjectMapper();
		String jsonObject = mapper.writeValueAsString(pet);
		httpRequest.header("content-type", "application/json");
		httpRequest.body(jsonObject);
		Response response = httpRequest.request(Method.POST);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void testPostWithGivenWhenThen() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		ObjectMapper mapper = new ObjectMapper();
		
		String objectAsJson;
		try {
			Pet pet = new Pet(828, "IEid" , "pending");
			objectAsJson = mapper.writeValueAsString(pet);
			given().
	        contentType("application/json").
	        body(objectAsJson).
	    when().
	        post("/pet").
	    then().
	        assertThat().
	        statusCode(200);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testPostmethod() {
		String url = "https://petstore.swagger.io/v2/pet";
		RequestSpecification httpRequest = rah.sendRequest(url);

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 1010);
		requestParams.put("name", "Brownie");
		requestParams.put("status", "available");

		httpRequest.header("content-type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST);
		System.out.println(response.getBody());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void testHeaderContent() {
		String url = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = rah.sendRequest(url);

		String expectedHeader = "application/json; charset=utf-8";
		Response response = httpRequest.request(Method.GET);
		String header = response.getContentType();
		Assert.assertEquals(header, expectedHeader);
	}

	@Test
	public void testLengthOfArrayOfUsers() {

		String url = "https://jsonplaceholder.typicode.com/users";
		RequestSpecification httpRequest = rah.sendRequest(url);

		int expectedSize = 10;
		Response response = httpRequest.request(Method.GET);
		List<Integer> ids = response.getBody().jsonPath().getList("id");
		int actualSize = ids.size();
		Assert.assertEquals(actualSize, expectedSize);
	}

	@Test
	public void testDeletePet() {

		String url = "https://petstore.swagger.io/v2/pet/824568";
		RequestSpecification httpRequest = rah.sendRequest(url);

		Response response = httpRequest.request(Method.DELETE);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
	}
}
