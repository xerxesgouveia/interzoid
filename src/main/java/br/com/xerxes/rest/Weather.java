package br.com.xerxes.rest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Weather {
	private String validRequest = "{\n" +
            "  \"email\": \"xerxesfalcao09@gmail.com\",\n" +
            "  \"password\": \"cabo090890\" \n}";
	private String path;
	
	@BeforeTest
	public void setup() {
        RestAssured.baseURI = "https://www.interzoid.com";
        path = "/services/getweathercity";
        
        //Response request = RestAssured.request(Method.GET, "https://api.interzoid.com/getweather?license=6d42963c972fb7111d6d9dafd119cd31&city=Brownsville&state=TX");
        //System.out.println(request.prettyPrint());
        
    }
	
	@Test
	public void getWeatherTexasSucessTest() {
		
		
				given()
                .auth()
                .preemptive()
                .basic("xerxesfalcao09@gmail.com", "cabo090890")
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(validRequest)
                .when()
                	.get("https://api.interzoid.com/getweather?license=6d42963c972fb7111d6d9dafd119cd31&city=Brownsville&state=TX")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
               
	}
	
	@Test
	public void getWeatherTexasNotFoundTest() {
		
		
				given()
                .auth()
                .preemptive()
                .basic("xerxesfalcao09@gmail.com", "cabo090890")
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(validRequest)
                .when()
                	.get("https://api.interzoid.com/getweather?license=6d42963c972fb7111d6d9dafd119cd31&city=Tampa&state=TX")
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");
               
	}
	
	
	@Test
	public void getWeatherTexasBadRequestTest() {
		
		
				given()
                .auth()
                .preemptive()
                .basic("xerxesfalcao09@gmail.com", "cabo090890")
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(validRequest)
                .when()
                	.get("https://api.interzoid.com/getweather?license=6d42963c972fb7111d6d9dafd119cd31&city=&state=")
                .then()
                .statusCode(400)
                .statusLine("HTTP/1.1 400 Bad Request");
               
	}
	
}



