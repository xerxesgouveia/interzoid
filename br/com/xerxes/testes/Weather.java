package br.com.xerxes.testes;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Weather {
	private String validRequest = "{\n" +
            "  \"email\": \"xerxesfalcao09@gmail.com\",\n" +
            "  \"password\": \"cabo090890\" \n}";
	private String path;
	
	@Before
    public void setup() {
        RestAssured.baseURI = "https://www.interzoid.com";
        path = "/services/getweathercity";
    }
	
	@Test
	public void getWeatherTest() {
				given()
                .auth()
                .preemptive()
                .basic("xerxesfalcao09@gmail.com", "cabo090890")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validRequest)
                .when()
                	.get("https://www.interzoid.com?license=6d42963c972fb7111d6d9dafd119cd31&city=Brownsville&state=TX")
                .then()
                .statusCode(200);
		
		
		
	}
}
