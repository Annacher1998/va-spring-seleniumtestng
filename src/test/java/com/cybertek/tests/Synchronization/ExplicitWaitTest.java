package com.cybertek.tests.Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    @Test
    public void waitForVisible() {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();




        //create WebDriverWait  object and pass driver ans wait duration
        WebDriverWait wait =new WebDriverWait(driver,10);

        //start waiting for certain element to visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
         driver.findElement(By.id("username")).sendKeys("tomsmith@yahoo.com");
//        driver.findElement(By.id("pwd")).sendKeys("1244");
//
//driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Submit')]")).click();

    }
//
//    @AfterMethod
//    public void afterMethod(){
//        driver.quit();
//    }


    @Test
    public void waitForClickable(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.cssSelector("#input-example>button")).click();

        WebElement input=driver.findElement(By.cssSelector("#input-example>input"));
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys("hello word");

    }

    @Test
    public void explicitNotHelpingUsingThreadSleepTest(){
        driver.get("http://qa3.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        ////*[.='Loading...'


        driver.findElement(By.id("_submit")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.='Loading...']")));
        driver.findElement(By.xpath("//a[@class='dashboard-btn  dashboard-link' and contains(text(),'My Calendar')]")).click();

    }
}
