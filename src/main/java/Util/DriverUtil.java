package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtil {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            return driver;
        }else{
            return driver;
        }
    }
    public static void waitforPage(WebDriver driver , By obj , String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(obj,msg));
    }
}
