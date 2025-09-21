package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class RegisterPage {

    private WebDriver driver;

    private By firstNameField = By.id("customer.firstName");
    private By lastNameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipCodeField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By registerButton = By.cssSelector("input[value='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegisterPage() {
        driver.findElement(By.linkText("Register")).click();
    }

    public void enterRegistrationDetails(Map<String, String> data) {
        driver.findElement(firstNameField).sendKeys(data.get("firstName"));
        driver.findElement(lastNameField).sendKeys(data.get("lastName"));
        driver.findElement(addressField).sendKeys(data.get("address"));
        driver.findElement(cityField).sendKeys(data.get("city"));
        driver.findElement(stateField).sendKeys(data.get("state"));
        driver.findElement(zipCodeField).sendKeys(data.get("zipCode"));
        driver.findElement(phoneField).sendKeys(data.get("phone"));
        driver.findElement(ssnField).sendKeys(data.get("ssn"));
        driver.findElement(usernameField).sendKeys(data.get("username"));
        driver.findElement(passwordField).sendKeys(data.get("password"));
        driver.findElement(confirmPasswordField).sendKeys(data.get("password"));
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
}
