package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FundTransferPage {

    private final WebDriver driver;

    private final By amountField = By.id("amount");
    private final By fromAccountSelect = By.id("fromAccountId");
    private final By toAccountSelect = By.id("toAccountId");
    private final By submitButton = By.xpath("//input[@value='Transfer']");

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }


    public void goToFundTransferPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds"))).click();
    }


    public void enterAmount(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }


    public void selectFromAccount() {
        Select fromDropdown = new Select(driver.findElement(fromAccountSelect));
        fromDropdown.selectByIndex(0); // selects the first option
    }

    public void selectToAccount() {
        Select toDropdown = new Select(driver.findElement(toAccountSelect));
        toDropdown.selectByIndex(0); // selects the first option
    }



    public void submitTransfer(){
        driver.findElement(submitButton).click();
        System.out.println(driver.getPageSource());

    }




    public void verifyTransferMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showResult")));

        String actualMessage = driver.findElement(By.xpath("//div[@id='showResult']//h1[@class='title']")).getText();

        Assert.assertEquals("mismatch", expectedMessage, actualMessage);
    }




}

