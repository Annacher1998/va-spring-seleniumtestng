package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VytrackTestProperties {

    @Test
    public void logintest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        String url= ConfigurationReader.get("url");
        driver.get(url);
        String username=ConfigurationReader.get("driverUsername");
String username1=ConfigurationReader.get("salesUsername");
        String password=ConfigurationReader.get("driverPassword");
String password1=ConfigurationReader.get("salesPassword");
       // VerificationUtils.login(driver,username1,password1);

        VerificationUtils.login(driver,username,password);


    }
}
