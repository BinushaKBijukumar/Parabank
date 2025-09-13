package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Binusha122");
        loginPage.enterPassword("303030");
        loginPage.clickLogin();
    }


    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
