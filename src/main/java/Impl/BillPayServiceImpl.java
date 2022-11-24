package Impl;

import JPathRepo.JsonPaths;
import ObjectRepo.BaseOR;
import ObjectRepo.BillPayServiceOR;
import Util.UserUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BillPayServiceImpl implements JsonPaths {
    WebDriver driver;
    public static String fromAccountIdVal;
    public static String PayeeAmount = Amount;
    public static String payeeName;
    public BillPayServiceImpl(WebDriver driver){
        this.driver = driver;
    }
    public void billPaylinkClick(){
        driver.findElement(By.xpath(BaseOR.billPayLink)).click();
    }
    public void fillBillPayInfo(){
        ResponseBody newUser = UserUtil.CreateUser();
        JsonPath pathEval = newUser.jsonPath();
         payeeName = pathEval.get(userName).toString();
        driver.findElement(By.xpath(BillPayServiceOR.PayeeName)).sendKeys(payeeName);
        driver.findElement(By.xpath(BillPayServiceOR.PayeeAddress)).sendKeys(pathEval.
                get(streetName).toString()+" "+pathEval.
                get(streetNumber).toString());
        driver.findElement(By.xpath(BillPayServiceOR.PayeeCity)).sendKeys(pathEval.get(City).toString());
        driver.findElement(By.xpath(BillPayServiceOR.PayeeState)).sendKeys(pathEval.get(State).toString());
        driver.findElement(By.xpath(BillPayServiceOR.PayeeZipCode)).sendKeys(pathEval.get(PostCode).toString());
        driver.findElement(By.xpath(BillPayServiceOR.PayeePhone)).sendKeys(pathEval.get(Cell).toString());
        driver.findElement(By.xpath(BillPayServiceOR.PayeeAccNo)).sendKeys(AccNo);
        driver.findElement(By.xpath(BillPayServiceOR.PayeeVerifyAccNo)).sendKeys(AccNo);
        driver.findElement(By.xpath(BillPayServiceOR.PayeeAmount)).sendKeys(PayeeAmount);
        Select sel = new Select(driver.findElement(By.xpath(BillPayServiceOR.fromAccountId)));
        String fromAccountId = sel.getFirstSelectedOption().getAttribute("value");
        System.out.println("fromAccountId VLAUE IS : "+fromAccountId);
        fromAccountIdVal = fromAccountId;
        driver.findElement(By.xpath(BillPayServiceOR.SendPaymentBtn)).click();
    }
}
