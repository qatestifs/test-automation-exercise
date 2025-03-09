package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class APIUtils {

    public static Response getWeatherData(Map<String, String> queryParams) {
        return RestAssured
                .given()
                .queryParams(queryParams).log().all()
                .when()
                .get(ConfigReader.getProperty("apiBaseUrl"));
    }
}
