package org.training.POJO;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class PostRequestSimple {
	
	public static void main(String[] args) {
		
		PojoPostReqSimple data = new PojoPostReqSimple();
		
		data.setFirstName("Anusha");
		data.setLastName("Morampudi");
		data.setId("1024");
		data.setDesignation("software Engineer");
		data.setMentorName("Bharadwaj");
		data.setCourseName("API_Testing");
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(data)
				.when()
				.post("http://localhost:3000/friends");
		       // .put("http://localhost:3000/friends/1024");
				//.delete("http://localhost:3000/friends/1024");
		
		System.out.println("Status code for post request is:"+res.getStatusCode());
		System.out.println("Data is");
		System.out.println(res.asString());
	}

}

