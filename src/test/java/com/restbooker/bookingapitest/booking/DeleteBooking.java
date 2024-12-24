package com.restbooker.bookingapitest.booking;

import com.restbooker.testbase.TestBase;
import com.restbooker.utils.GlobalVariables;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking extends TestBase {

    @Test
    public void deleteBookingData() {

        if (GlobalVariables.bookingId == 0 ) {
            new GetBookingData().getBookingIds();
        }

        Response response = given().log().all()
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .header("cookie", GlobalVariables.token)
                .pathParam("id", GlobalVariables.bookingId)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}
