package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPage {

    private WebDriver driver;

    // Locators
    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By address = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By confirmPassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By welcomeMessage = By.xpath("//h1");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to registration page
    public void goToRegisterPage() {
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    // Fill details using DataTable
    public void enterRegistrationDetails(Map<String, String> data) {
        driver.findElement(firstName).sendKeys(data.get("firstName"));
        driver.findElement(lastName).sendKeys(data.get("lastName"));
        driver.findElement(address).sendKeys(data.get("address"));
        driver.findElement(city).sendKeys(data.get("city"));
        driver.findElement(state).sendKeys(data.get("state"));
        driver.findElement(zipCode).sendKeys(data.get("zipCode"));
        driver.findElement(phone).sendKeys(data.get("phone"));
        driver.findElement(ssn).sendKeys(data.get("ssn"));
        driver.findElement(username).sendKeys(data.get("username"));
        driver.findElement(password).sendKeys(data.get("password"));
        driver.findElement(confirmPassword).sendKeys(data.get("password"));
    }

    // Click Register
    public void clickRegister() {
        driver.findElement(registerButton).click();
        System.out.println(driver.getPageSource());
    }

    // Get Welcome Message
    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}
