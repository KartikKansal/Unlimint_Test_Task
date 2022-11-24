package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public  static void initializeDriver(){
       if(driver==null) {
           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
        }

    }
}
