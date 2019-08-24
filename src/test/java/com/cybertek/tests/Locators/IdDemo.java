package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;

public class IdDemo {


    public static void main(String[] args) throws InterruptedException {
//id1();

    }

    public  static void id1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(4000);

        WebElement logBtn=driver.findElement(By.id("wooden_spoon"));
        logBtn.click();

        Thread.sleep(2000);

        driver.quit();
    }


}
