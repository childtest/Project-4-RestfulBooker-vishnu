package com.restbooker.bookingapitest.ping;

import com.restbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HealthCheckByPing extends TestBase {

    @Test
    public void healthCheck() {

        Response response = given().log().all()
                .when()
                .get("/ping");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
