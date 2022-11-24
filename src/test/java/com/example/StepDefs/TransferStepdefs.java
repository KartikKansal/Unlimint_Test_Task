package com.example.StepDefs;

import Impl.BillPayServiceImpl;
import ObjectRepo.PayCompleteOR;
import Util.DriverUtil;
import com.example.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TransferStepdefs extends BaseClass {
    BillPayServiceImpl payService = new BillPayServiceImpl(driver);
    @Given("User Click BillPay")
    public void userClickBillPay() {
        payService.billPaylinkClick();
    }

    @When("User Fills Pay Transfer Details")
    public void userFillsPayTransferDetails() {
        payService.fillBillPayInfo();
    }

    @Then("Amount Tranfers Successfully")
    public void amountTranfersSuccessfully() {
        DriverUtil.waitforPage(driver,By.cssSelector("#rightPanel"),"Bill Payment Complete");
        Assert.assertEquals(BillPayServiceImpl.fromAccountIdVal.equals(driver.findElement(By.cssSelector(PayCompleteOR.fromAccountId)).getText()),true);
        Assert.assertEquals(BillPayServiceImpl.PayeeAmount.equals(driver.findElement(By.cssSelector(PayCompleteOR.Amount)).getText().split("\\.")[0].substring(1)),true);
        Assert.assertEquals(BillPayServiceImpl.payeeName.equals(driver.findElement(By.cssSelector(PayCompleteOR.payeeName)).getText()),true);
    }

    @Given("Browser Close")
    public void browserClose() {
        driver.quit();
    }
}
