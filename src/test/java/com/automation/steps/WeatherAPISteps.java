package com.automation.steps;

import com.automation.utils.APIUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class WeatherAPISteps {
    private Response response;

    @Given("the weather API is available")
    public void theWeatherAPIIsAvailable() {
        response = APIUtils.getWeatherData(Map.of("lon", "113.2", "lat", "23.1", "ac", "0", "unit", "metric", "output", "json", "tzshift", "0"));
        assertEquals(200, response.getStatusCode());
    }

    @When("I send a request with the following details:")
    public void iSendARequestWithTheFollowingDetails(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        Map<String, String> queryParams = new HashMap<>();
        for (Map<String, String> row : data) {
            queryParams.put(row.get("key"), row.get("value"));
        }
        response = APIUtils.getWeatherData(queryParams);
    }

    @Then("the response should contain the following weather data:")
    public void theResponseShouldContainFollowingWeatherData(DataTable table) {
        List<Map<String, String>> expectedData = table.asMaps(String.class, String.class);

        for (Map<String, String> row : expectedData) {
            String key = row.get("key");
            String expectedValue = row.get("expected_value");
            if (expectedValue.equalsIgnoreCase("not_null")) {
                response.then().body("dataseries[1]." + key, notNullValue());
            } else {
                response.then().body("dataseries[1]." + key, equalTo(expectedValue));
            }
        }
    }
}