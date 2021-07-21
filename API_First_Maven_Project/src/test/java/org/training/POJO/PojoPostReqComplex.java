package org.training.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PojoPostReqComplex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PostRequestComplex complex = new PostRequestComplex();
		
		complex.setH_No("353-1");
		complex.setStreet("Chandanagar");
		complex.setZipcode("500056");
		
		PojoBasicInfo basicInfo = new PojoBasicInfo();
		
		basicInfo.setFirstName("Ram");
		basicInfo.setLastName("Pamarthi");
		basicInfo.setId("1060");
		basicInfo.setDesignation("software Engineer");
		basicInfo.setMentorName("Bharadwaj");
		basicInfo.setCourseName("API_Testing");
		basicInfo.setComplex(complex);
		
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(basicInfo)
				.when()
				.post("http://localhost:3000/friends");
		     // .put("http://localhost:3000/friends/1024");
		      //.delete("http://localhost:3000/friends/1024");

			System.out.println("Status code for post request is:"+res.getStatusCode());
			System.out.println("Data is");
			System.out.println(res.asString());

	}

}
