package com.example.StepDefs;

import Impl.RegisterUserImpl;
import Util.UserUtil;
import com.example.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserRegStepDefs extends BaseClass {
    ResponseBody response;
    RegisterUserImpl registerUser;
    @Given("User Opens Page")
    public void userOpensPage() {
        registerUser = new RegisterUserImpl(driver);
    }

    @And("User Clicks Register Link")
    public void userClicksRegisterLink() {
        registerUser.ClicksRegisterLink();
    }

    @When("User Fill Register Form")
    public void userFillRegisterForm() {
        response = UserUtil.CreateUser();
        registerUser.fillUserDetails(response);
    }

    @Then("User Registers Successfully")
    public void userRegistersSuccessfully() {
        String successMsg = driver.findElement(By.cssSelector("#rightPanel")).getText();
        System.out.print("successMsg is : "+successMsg);
        Assert.assertEquals(successMsg.contains("Your account was created successfully. You are now logged in."),true);
    }
}
