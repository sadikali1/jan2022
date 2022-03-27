package com.api.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SoapRequest {
	
	@Test
	public void post() {
		RestAssured.baseURI = "http://www.dneonline.com/calculator.asmx";
		int a = 10;
		int b = 20;
		
		String xmlData = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "    <Body>"
				+ "        <Add xmlns=\"http://tempuri.org/\">"
				+ "            <intA>"+a+"</intA>"
				+ "            <intB>"+b+"</intB>"
				+ "        </Add>"
				+ "    </Body>"
				+ "</Envelope>";
		
		Response response = given().header("Content-Type", "text/xml").body(xmlData).when().post();

		System.out.println(response.asString());
				
	}

}
