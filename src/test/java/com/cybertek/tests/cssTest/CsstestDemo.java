package com.cybertek.tests.cssTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CsstestDemo {

    @Test
    public void byAttributeAndValue() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //CERATAIN ELEMENT WITH ATTRIBUTE AND VALUE COMBO
        System.out.println(driver.findElement(By.cssSelector("button[name='button6']")).getText());

        //ANY ELEMENT WITH ATTRIBUTE AND VALUE
        System.out.println(driver.findElement(By.cssSelector("[onclick='button6()']")).getText());


        System.out.println(driver.findElement(By.cssSelector("button[class='btn btn-primary'][name='button2']")).getText());


    }
    @Test
    public void dynamicElements(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //starts with
        System.out.println(driver.findElement(By.cssSelector("button[id^='button_']")).getText());

        //End of the text

        System.out.println(driver.findElement(By.cssSelector("button[id$='_button']")).getText());

        //contains
        System.out.println(driver.findElement(By.cssSelector("button[id*='disappearing']")).getText());


    }
    @Test
    public void IdAndClass(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        //ID
        System.out.println(driver.findElement(By.cssSelector("#page-footer")).getText());


        //
    }
    @Test
    public void ClassNameCss(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        //ONE CLASS
        System.out.println(driver.findElement(By.cssSelector(".nav-item")).getText());
        //TWO CLASS
        System.out.println(driver.findElement(By.cssSelector(".btn.btn-primary")).getText());

        //CERTAIN ELEMENT WITH CLASS

        System.out.println(driver.findElement(By.cssSelector("a.nav-link")).getText());



    }
    @Test
    public void parentToChild(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println();
    }
}
