package com.restbooker.bookingapitest.booking;

import com.restbooker.model.BookingPojo;
import com.restbooker.testbase.TestBase;
import com.restbooker.utils.GlobalVariables;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBooking extends TestBase {

    @Test
    public void partialUpdateBookingData() {

        if (GlobalVariables.bookingId == 0) {
            new GetBookingData().getBookingIds();
        }

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("child");
        bookingPojo.setLastname("test");

        Response response = given().log().all()
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .header("cookie", GlobalVariables.token)
                .pathParam("id", GlobalVariables.bookingId)
                .body(bookingPojo)
                .when()
                .patch("/booking/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
