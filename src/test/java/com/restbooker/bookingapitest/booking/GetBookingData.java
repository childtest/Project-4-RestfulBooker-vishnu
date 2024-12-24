package com.restbooker.bookingapitest.booking;


import com.restbooker.testbase.TestBase;
import com.restbooker.utils.GlobalVariables;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingData extends TestBase {


    @Test(priority = 1)
    public void getBookingIds() {

        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

        if (response.getStatusCode() == 200) {
            GlobalVariables.bookingId = (int) response.jsonPath().getList("bookingid").get(1);
            System.out.println(response.jsonPath().getList("bookingid").get(1));
            System.out.println("booking id: " + GlobalVariables.bookingId);
        }
    }


    @Test(priority = 2)
    public void getBookingById() {

        Response response = given().log().all()
                .pathParam("id", GlobalVariables.bookingId)
                .when()
                .get("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
