package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIRequestHelper {

    public static Response sendGetRequest(String baseUrl, Map<String, Object> params) {
        RequestSpecification request = RestAssured.given().baseUri(baseUrl).log().all();

        if (params != null && !params.isEmpty()) {
            request.queryParams(params);
        }

        return request.get();
    }
}