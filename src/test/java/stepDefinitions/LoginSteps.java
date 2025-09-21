package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage login;

    public LoginSteps() {
        this.driver = Hooks.driver;
        login = new LoginPage(driver);
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        login.clickLogin();
    }

    @Then("User should be navigated to the dashboard")
    public void user_should_be_navigated_to_the_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean dashboardVisible = wait.until(ExpectedConditions
                .textToBePresentInElementLocated(By.tagName("h1"), "Accounts Overview"));
        assertTrue("Dashboard not visible", dashboardVisible);
    }
}
