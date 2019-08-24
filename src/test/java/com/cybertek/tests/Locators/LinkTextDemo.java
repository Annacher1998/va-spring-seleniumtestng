package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class LinkTextDemo {

    public static void main(String[] args)  throws  InterruptedException{


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Dynamic Loading")).click();
driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        Thread.sleep(1000);


        driver.navigate().back();

        Thread.sleep(4000);
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
    }
}
