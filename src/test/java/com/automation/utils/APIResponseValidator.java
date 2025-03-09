package com.automation.utils;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class APIResponseValidator {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public static void validateJsonFieldIsNotNull(Response response, String jsonPath) {
        response.then().body(jsonPath, notNullValue());
    }

    public static void validateJsonFieldEquals(Response response, String jsonPath, Object expectedValue) {
        response.then().body(jsonPath, equalTo(expectedValue));
    }
}