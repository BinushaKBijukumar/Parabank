package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage login;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        login = new LoginPage(driver);
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            boolean dashboardVisible = wait.until(ExpectedConditions
                    .textToBePresentInElementLocated(By.tagName("h1"), "Accounts Overview"));

            System.out.println("Login successful");
        } catch (Exception e) {
            throw new AssertionError("Login failed", e);
        } finally {
            driver.quit();
        }
    }

}
