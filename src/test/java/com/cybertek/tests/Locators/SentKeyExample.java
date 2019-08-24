package com.cybertek.tests.Locators;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SentKeyExample {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

// SendKeys()--> enters text on the webElement
        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("anna.chernyshova@gmail.com");

Thread.sleep(4000);
        WebElement retriveBtn=driver.findElement(By.id("form_submit"));
        retriveBtn.click();
String expected="http://practice.cybertekschool.com/forgot_password";
String actual=driver.getCurrentUrl();

        VerificationUtils.verifyEquals(expected,actual);


    }



}
