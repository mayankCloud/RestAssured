package com.rest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class SingleValueFromResponse {

    @Test
    public void singleResponse(){
        Response response = given()
                .baseUri("https://api.postman.com")
                .header("x-api-key", "PMAK-61838a2e3cd2d600519ea2d4-9ddd2cf830dd9109292d980b35b475a4de")
                .when()
                .get("/workspaces")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        System.out.println("Workspace name is : "+response.path("workspaces[0].name"));

    }
}
