package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

public class NameDemo {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");
       // Thread.sleep(2000);
        WebElement name=driver.findElement(By.name("full_name"));
        name.click();

        name.sendKeys("AnnaCher");
        Thread.sleep(2000);

        WebElement email=driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("random@gmail.com");
        Thread.sleep(2000);

        WebElement signBtn=driver.findElement(By.name("wooden_spoon"));
        signBtn.click();
        Thread.sleep(2000);


        WebElement text=driver.findElement(By.name("signup_message"));
        String text1=text.getText();
        System.out.println("Sign in successfully: "+text1);

        driver.quit();
    }
}
