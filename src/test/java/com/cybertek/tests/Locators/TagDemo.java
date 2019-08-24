package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagDemo {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement tagName=driver.findElement(By.tagName("h2"));
        System.out.println(tagName.getText());
driver.findElement(By.tagName("input")).sendKeys("Admiral Kenka");

        driver.findElement(By.name("email")).sendKeys("AdmiralKenka@gmail.com");

        driver.findElement(By.tagName("button")).click();
//go back to home page
driver.findElement(By.tagName("a")).click();



    }

}
