package Impl;

import JPathRepo.JsonPaths;
import ObjectRepo.BaseOR;
import ObjectRepo.UserResgisterOR;
import Util.UserUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserImpl implements UserResgisterOR , JsonPaths {
       WebDriver driver;
        String userName;
        public RegisterUserImpl(WebDriver driver){
            this.driver = driver;
        }
        public void ClicksRegisterLink(){
            driver.findElement(By.xpath(BaseOR.userRegister)).click();
        }
    public void fillUserDetails(ResponseBody respBody){
        JsonPath pathEval = respBody.jsonPath();
         userName = pathEval.get(JsonPaths.userName).toString();
        UserUtil.setUserName(userName);
        driver.findElement(By.cssSelector(UserResgisterOR.CustfirstName)).sendKeys(pathEval.get(firstName).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustlastName)).sendKeys(pathEval.get(lastName).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustAddress)).sendKeys(pathEval.
                get(streetName).toString()+" "+pathEval.
                get(streetNumber).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustCity)).sendKeys(pathEval.get(City).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustState)).sendKeys(pathEval.get(State).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustZipCode)).sendKeys(pathEval.get(PostCode).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustSSN)).sendKeys(pathEval.get(SSN)==null?UserUtil.getUniqueValue(""):pathEval.get(SSN).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustuserName)).sendKeys(pathEval.get(JsonPaths.userName).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustPassword)).sendKeys(pathEval.get(Password).toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustConfirmPassword)).sendKeys(pathEval.get(Password).toString());
        driver.findElement(By.xpath(UserResgisterOR.RegisterBtn)).click();
        userExistCheck(pathEval);
    }
    public void userExistCheck(JsonPath pathEval){
            if(!driver.findElements(By.cssSelector(UserResgisterOR.userExistErr)).isEmpty()){
                String uuserName = UserUtil.getUniqueValue(userName);
                UserUtil.setUserName(uuserName);
                driver.findElement(By.cssSelector(UserResgisterOR.CustuserName)).sendKeys(uuserName);
                driver.findElement(By.cssSelector(UserResgisterOR.CustPassword)).sendKeys(pathEval.get(Password).toString());
                driver.findElement(By.cssSelector(UserResgisterOR.CustConfirmPassword)).sendKeys(pathEval.get(Password).toString());
                driver.findElement(By.xpath(UserResgisterOR.RegisterBtn)).click();
            }
    }
}
