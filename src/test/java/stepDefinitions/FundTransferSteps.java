package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FundTransferPage;
import pages.LoginPage;

public class FundTransferSteps {

    private WebDriver driver;
    private FundTransferPage fundTransferPage;

    public FundTransferSteps() {
        this.driver = Hooks.driver;
        this.fundTransferPage = new FundTransferPage(driver);
    }



    @When("User navigates to the fund transfer page")
    public void user_navigates_to_the_fund_transfer_page() {
        fundTransferPage.goToFundTransferPage();
    }

    @When("User enters amount {string} and selects from account {string} to account {string}")
    public void user_enters_amount_and_selects_from_account_to_account(String amount, String fromAcc, String toAcc) {
        fundTransferPage.enterAmount(amount);
        fundTransferPage.selectFromAccount(fromAcc);
        fundTransferPage.selectToAccount(toAcc);
    }

    @When("Clicks on submit transfer")
    public void clicks_on_submit_transfer(){
        fundTransferPage.submitTransfer();
    }

    @Then("User should see {string} message")
    public void user_should_see_message(String expectedMessage) throws InterruptedException {

        fundTransferPage.verifyTransferMessage(expectedMessage);
    }



}
