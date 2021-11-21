package com.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostmanApiGET {

    @Test
    public void validateStatusCode(){
    given().baseUri("https://api.postman.com")
            .header("x-api-key", "PMAK-61838a2e3cd2d600519ea2d4-9ddd2cf830dd9109292d980b35b475a4de")
            .when()
            .get("/workspaces")
            .then()
            .log().all()
            .assertThat()
            .statusCode(200)
            .body("workspaces.name", hasItems("Team Workspace","My Workspace"),
                    "workspaces.type",hasItems("team","personal"),
                    "workspaces.size()",equalTo(3),
                    "workspaces.name",hasItems("Team Workspace"))

    ;
    }
}
