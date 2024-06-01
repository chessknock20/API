package org.example.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://reqres.in";
    }
}
