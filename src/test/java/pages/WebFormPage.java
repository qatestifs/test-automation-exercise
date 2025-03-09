package pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {
    private final WebDriver driver;

    @FindBy(name = "my-select")
    private WebElement dropdown;

    @FindBy(name = "my-datalist")
    private WebElement datalistInput;

    @FindBy(id = "my-check-2")
    private WebElement checkbox;

    @FindBy(id = "my-radio-1")
    private WebElement radioButton;

    @FindBy(css = "input[type='color']")
    private WebElement colorPicker;

    @FindBy(css = "input[name='my-date']")
    private WebElement datePicker;

    @FindBy(css = "input[type='range']")
    private WebElement rangeSlider;


    public WebFormPage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void fillField(String fieldName, String value) {
        By locator = null;
        switch (fieldName.toLowerCase()) {
            case "text input":
                locator = By.id("my-text-id");
                break;
            case "password":
                locator = By.name("my-password");
                break;
            case "text area":
                locator = By.name("my-textarea");
                break;
        }
        if (locator != null) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(value);
        }
    }

    public void selectOption(String option) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    public void selectFromDatalist(String city) {
        datalistInput.clear();
        datalistInput.sendKeys(city); // Type the city name
    }

    public void selectCheckbox() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void selectRadioButton() {
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }


    public void selectColor(String colorHex) {
        colorPicker.sendKeys(colorHex); // Bypass popup by sending value directly
    }

    public void selectDate(String date) {
        datePicker.sendKeys(date); // Format should be YYYY-MM-DD
    }

    public void selectRange(String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", rangeSlider, value);
    }

    public void submitForm() {
        driver.findElement(By.cssSelector("button")).click();
    }

}