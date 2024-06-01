package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResponseTest extends BaseClass {

    @Test
    void testJsonResponse() {
        Response response = given().log().all()
                .when().get("/api/users/2")
                .then().log().all().extract().response();
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getHeader("Transfer-Encoding"), "chunked");
        System.out.println("ID: " + response.jsonPath().getInt("data.id"));
        System.out.println("EMAIL: " + response.jsonPath().getString("data.email"));
    }


    
}
