package org.example.api;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class JsonSchemaTest extends BaseClass{

    @Test
    public void testJsonSchema() {

        given().log().all()
                .when().get("/api/users/2")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));
    }
    @Test
    public void requiredFieldsTest(){
        Map<String, String> bodyInfo= new HashMap<>();
        bodyInfo.put("name", "morpheus");
     //   bodyInfo.put("job", "zion resident");
        given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/2")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/putjsonschema.json"));
    }
}
