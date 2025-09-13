package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

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
        driver.findElement(By.linkText("Transfer Funds")).click();
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }

    public void selectFromAccount(String fromAcc) {
        Select fromDropdown = new Select(driver.findElement(fromAccountSelect));
        fromDropdown.selectByVisibleText(fromAcc);
    }

    public void selectToAccount(String toAcc) {
        Select toDropdown = new Select(driver.findElement(toAccountSelect));
        toDropdown.selectByVisibleText(toAcc);
    }


    public void submitTransfer(){
        driver.findElement(submitButton).click();
    }


    public void verifyTransferMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath("//input[@class='title']")).getText();
        Assert.assertEquals("mismatch", expectedMessage, actualMessage);
    }
}

