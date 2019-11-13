package com.jstech.restassureddemo;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHelper {

	public RequestSpecification sendRequest(String url) {
		RestAssured.baseURI =  url;
		return RestAssured.given();
	}
	
}
