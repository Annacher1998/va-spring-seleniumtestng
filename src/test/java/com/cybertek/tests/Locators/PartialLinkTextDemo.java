package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class PartialLinkTextDemo {

    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.partialLinkText("Loading")).click();
Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Example 1:")).click();
        Thread.sleep(3000);
        driver.findElement(By.tagName("button")).click();
Thread.sleep(3000);
        driver.quit();


    }
}
