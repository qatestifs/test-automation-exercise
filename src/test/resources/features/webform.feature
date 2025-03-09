@web @sanity
Feature: Web Form Submission

  Scenario: User fills out the form with multiple values
    Given I am on the web form page
    When I enter the following details:
      | Field      | Value             |
      | Text Input | TestUser          |
      | Password   | Secret            |
      | Text Area  | Test Data Entered |
    And I select Option "Two" from the dropdown
    And I select label Option "Los Angeles" from the dropdown datalist
    And I select the "Default checkbox", "Checked radio"
    When I select the following details:
      | Field         | Value      |
      | Color Picker  | #333dff    |
      | Date Picker   | 25/02/2025 |
      | Example Range | 7          |
    When I submit the form
    Then I should see the title contains "Web form - target page"
    Then I close the browser
