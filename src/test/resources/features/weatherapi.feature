@api @sanity
Feature: 7Timer Weather API Validation

  Scenario: Validate Weather API response with multiple parameters
    Given the weather API is available
    When I send a request with the following details:
      | key       | value    |
      | lon       | 113.2    |
      | lat       | 23.1     |
      | ac        | 0        |
      | unit      | metric   |
      | output    | json     |
      | tzshift   | 0        |
    Then the response should contain the following weather data:
      | key          | expected_value |
      | temp2m       | not_null       |
      | rh2m         | not_null       |
      | cloudcover   | not_null       |
      | seeing       | not_null       |
      | transparency | not_null       |