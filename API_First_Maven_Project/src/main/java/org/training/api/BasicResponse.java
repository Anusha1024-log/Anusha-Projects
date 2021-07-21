package org.training.api;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
public class BasicResponse {

	public static void main(String[] args) {
		Response res=
				 given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/posts");
		System.out.println("Status code"+res.getStatusCode());
		System.out.println("Data is");
		System.out.println(res.asString());
	}

}
