package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

public class APITests {

	private long id;
	
	// End point Url
		// https://petstore.swagger.io
		// resource url: /v2/pet/findByStatus
	
	// query parameter
		//status 
	// Form parameter
		// No
	// Autherization token
		// No
	
	// Path parameter
		// 
	// Body
		// No 
	
	// Header
		//'accept: application/json'
	
	@Test
	public void testGetPetStatus() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
					.when().get("/pet/findByStatus?status=sold");
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);		
	}
	
	
	// End point Url
			// https://petstore.swagger.io
			// resource url: /v2/pet
		
	// query parameter
			//status 
	// Form parameter
			// No
	// Autherization token
			// No
		
	// Path parameter
			// 
	// Body
		// Yes
		
	// Header
			//'accept: application/json'
			// Content-Type", "application/json
	
	@Test
	public void addPet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		
		Header header1 = new Header("accept" ,"application/json");
		Header header2 = new Header("Content-Type" ,"application/json");
		Headers headers = new Headers(header1, header2);
		
		String jsonBody = "{"
				+ "  \"id\": 0,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"Cat\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"Tag1\""
				+ "    },"
				 		+"{"
							+ "      \"id\": 0,"
							+ "      \"name\": \"Tag2\""
							+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		
		Response response = given().headers(headers).body(jsonBody)
				.when().post("/pet");
		
		response.then().statusCode(200).contentType("application/json");
		response.then().body("status",  Matchers.equalTo("available")).body("category.name",  Matchers.equalTo("Cat"))
				.and().body("tags[0].name",  Matchers.equalTo("Tag1")).and().body("tags[1].name",  Matchers.equalTo("Tag2"));
		
		this.id =  response.path("id");
		System.out.println(id);
		System.out.println(response.asPrettyString());
	}
	
	
	@Test
	public void addPet1() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";	
		String jsonBody = "{"
				+ "  \"id\": 0,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		
		given().header("accept" ,"application/json").header("Content-Type" ,"application/json").body(jsonBody)
				.when().post("/pet")
				.then().statusCode(200).contentType("application/json");
		
	}
	
	@Test(dependsOnMethods = {"addPet"} )
	public void getPetsById() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";	
		
		Response response = given().header("accept" ,"application/json")
				.when().get("/pet/"+this.id );
		System.out.println(response.asPrettyString());
				
		response.then().statusCode(200).and().contentType("application/json");
		
	}
	
	
	@Test(dependsOnMethods = {"getPetsById", "addPet"})
	public void deletePetsById() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";	
		
		Response response = given().header("accept" ,"application/json")
				.when().delete("/pet/"+this.id );
		System.out.println(response.asPrettyString());
				
		response.then().statusCode(200).and().contentType("application/json");
		
	}
}
