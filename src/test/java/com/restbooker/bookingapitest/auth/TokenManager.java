package com.restbooker.bookingapitest.auth;
import com.restbooker.model.BookingPojo;
import com.restbooker.testbase.TestBase;
import com.restbooker.utils.GlobalVariables;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Created by Vishnu Ahir
 */
public class TokenManager extends TestBase {

    public static void generateToken() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername("admin");
        bookingPojo.setPassword("password123");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();

        if (response.getStatusCode() == 200) {
            GlobalVariables.token = "token="+response.jsonPath().getString("token");
            System.out.println("Generated Token: " + GlobalVariables.token);
        } else {
            throw new RuntimeException("Failed to generate token: " + response.prettyPrint());
        }

    }
}