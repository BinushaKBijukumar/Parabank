package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

import java.util.Map;

public class RegisterSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    public RegisterSteps() {
        this.driver = Hooks.driver; // reuse driver from Hooks
        this.registerPage = new RegisterPage(driver);
    }

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        registerPage.goToRegisterPage();
    }

    @When("User enters registration details")
    public void user_enters_registration_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        registerPage.enterRegistrationDetails(data);
    }

    @When("Clicks on register")
    public void clicks_on_register() {
        registerPage.clickRegister();
    }

    @Then("User should see registration message {string}")
    public void user_should_see_registration_message(String message) {
        String actualMessage = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(message, actualMessage);
    }

}

