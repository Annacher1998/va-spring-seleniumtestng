package com.cybertek.tests.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClassDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");

        System.out.println(driver.findElement(By.className("subheader")).getText());
        Thread.sleep(4000);
       driver.findElement(By.className("nav-link")).click();





        driver.get("http://practice.cybertekschool.com/multiple_buttons");
Thread.sleep(2000);
        System.out.println(driver.findElement(By.className("btn btn-primary")).getText());

    }
}
