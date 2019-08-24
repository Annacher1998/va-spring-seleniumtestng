package com.cybertek.tests.review1;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterExample {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

// SendKeys()--> enters text on the webElement
        WebElement emailInput=driver.findElement(By.name("email"));

       //Keys.ENTER--> enter a button "enter"
      // emailInput.sendKeys("anna.chernyshova@gmail.com"+ Keys.ENTER);
        emailInput.sendKeys("anna.chernyshova@gmail.com");
//submit()--> submits in the current form
       // emailInput.submit();

Thread.sleep(4000);

String expected="http://practice.cybertekschool.com/forgot_password";
String actual=driver.getCurrentUrl();

        VerificationUtils.verifyEquals(expected,actual);


    }



}
