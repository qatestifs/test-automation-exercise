package com.automation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import pages.WebFormPage;

import java.util.List;
import java.util.Map;

import static com.automation.utils.DriverManager.tearDown;


public class WebFormSteps {
    WebFormPage webFormPage = new WebFormPage();
    BasePage basePage = new BasePage();


    @Given("I am on the web form page")
    public void iAmOnTheWebFormPage() {
        basePage.navigateTo();
    }

    @When("I enter the following details:")
    public void iEnterThe_FollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String field = row.get("Field");
            String value = row.get("Value");
            webFormPage.fillField(field, value);
        }
    }

    @And("I select Option {string} from the dropdown")
    public void iSelectOptionTwoFromDropdown(String option) {
        webFormPage.selectOption(option);
    }

    @And("I select label Option {string} from the dropdown datalist")
    public void iSelectOptionFromDatalist(String city) {
        webFormPage.selectFromDatalist(city);
    }

    @And("I select the {string}, {string}")
    public void iSelectTheDefaultCheckboxAndCheckedRadio(String field, String value) {
        webFormPage.selectCheckbox();
        webFormPage.selectRadioButton();
    }

    @When("I select the following details:")
    public void iSelectTheFollowingDetails(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);

        if (data.containsKey("Color Picker")) {
            webFormPage.selectColor(data.get("Color Picker"));
        }

        if (data.containsKey("Date Picker")) {
            webFormPage.selectDate(data.get("Date Picker"));
        }

        if (data.containsKey("Example Range")) {
            webFormPage.selectRange(data.get("Example Range"));
        }
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        webFormPage.submitForm();
    }

    @Then("I should see the title contains {string}")
    public void iShouldSeeTheTitleContains(String expectedTitle) {
        Assert.assertTrue(basePage.getPageTitle().contains(expectedTitle));
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        tearDown();
    }
}