package com.restbooker.testbase;

import com.restbooker.utils.GlobalVariables;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import static com.restbooker.bookingapitest.auth.TokenManager.generateToken;

/**
 * Created by Vishnu Ahir
 */
public class TestBase {

    public int id = 1;

    @BeforeMethod
    public void inIT(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";

        // Generate the token
        if (GlobalVariables.token == null || GlobalVariables.token.isEmpty()) {
            generateToken();
        }
    }

}