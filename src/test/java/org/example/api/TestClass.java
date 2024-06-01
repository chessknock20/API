package org.example.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestClass extends BaseClass {

    @Test
    public void getSingleUser() {
        given().log().all()
                .when().get("/api/users/2")
                .then().log().all().statusCode(200);

    }
    @Test
    public void getListUsers() {
        given().log().uri()
                .when().get("/api/users?page=2")
                .then().log().all().statusCode(200);
    }
    @Test
    public void createUser(){
//        given().log().all().contentType(ContentType.JSON).body("{\n" +
//                        "    \"name\": \"morpheus\",\n" +
//                        "    \"job\": \"leader\"\n" +
//                        "}")
        File file = new File("src/test/resourses/json/user.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().post("/api/users")
                .then().log().body().statusCode(201);
    }

    @Test
    public void updateUser(){
        Map<String, String> bodyInfo= new HashMap<>();
        bodyInfo.put("name", "morpheus");
        bodyInfo.put("job", "zion resident");
        given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/2")
                .then().log().body().statusCode(200);
    }

    @Test
    public void deleteUser(){
        given().log().uri()
                .when().delete("/api/users/2")
                .then().log().all().statusCode(204);
    }


}
