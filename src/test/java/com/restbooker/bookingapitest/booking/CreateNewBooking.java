package com.restbooker.bookingapitest.booking;

import com.restbooker.model.BookingPojo;
import com.restbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateNewBooking extends TestBase {

    @Test
    public void createBooking() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("child");
        bookingPojo.setLastname("test");
        bookingPojo.setTotalprice(3443);
        bookingPojo.setDepositpaid(true);
        Map<String, String> dates = new HashMap<>();
        dates.put("checkin", "2018-01-01");
        dates.put("checkout", "2019-01-01");
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
