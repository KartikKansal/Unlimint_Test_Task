package Impl;

import ObjectRepo.BaseOR;
import ObjectRepo.UserResgisterOR;
import Util.UserUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserImpl implements UserResgisterOR {
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
         userName = pathEval.get("results[0].login.username").toString();
        UserUtil.setUserName(userName);
        driver.findElement(By.cssSelector(UserResgisterOR.CustfirstName)).sendKeys(pathEval.get("results[0].name.first").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustlastName)).sendKeys(pathEval.get("results[0].name.last").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustAddress)).sendKeys(pathEval.
                get("results[0].location.street.name").toString()+" "+pathEval.
                get("results[0].location.street.number").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustCity)).sendKeys(pathEval.get("results[0].location.city").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustState)).sendKeys(pathEval.get("results[0].location.state").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustZipCode)).sendKeys(pathEval.get("results[0].location.postcode").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustSSN)).sendKeys(pathEval.get("results[0].id.value")==null?UserUtil.getUniqueValue(""):pathEval.get("results[0].id.value".toString()));
        driver.findElement(By.cssSelector(UserResgisterOR.CustuserName)).sendKeys(pathEval.get("results[0].login.username").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustPassword)).sendKeys(pathEval.get("results[0].login.password").toString());
        driver.findElement(By.cssSelector(UserResgisterOR.CustConfirmPassword)).sendKeys(pathEval.get("results[0].login.password").toString());
        driver.findElement(By.xpath(UserResgisterOR.RegisterBtn)).click();
        userExistCheck(pathEval);
    }
    public void userExistCheck(JsonPath pathEval){
            if(!driver.findElements(By.cssSelector(UserResgisterOR.userExistErr)).isEmpty()){
                String uuserName = UserUtil.getUniqueValue(userName);
                UserUtil.setUserName(uuserName);
                driver.findElement(By.cssSelector(UserResgisterOR.CustuserName)).sendKeys(uuserName);
                driver.findElement(By.cssSelector(UserResgisterOR.CustPassword)).sendKeys(pathEval.get("results[0].login.password").toString());
                driver.findElement(By.cssSelector(UserResgisterOR.CustConfirmPassword)).sendKeys(pathEval.get("results[0].login.password").toString());
                driver.findElement(By.xpath(UserResgisterOR.RegisterBtn)).click();
            }
    }
}
