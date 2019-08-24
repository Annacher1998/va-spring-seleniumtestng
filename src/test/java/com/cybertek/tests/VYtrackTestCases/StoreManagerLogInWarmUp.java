package com.cybertek.tests.VYtrackTestCases;

import com.cybertek.utilities.SleepMethod;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreManagerLogInWarmUp {
    WebDriver driver;


    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }

    @Test
    public void test1(){



        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        SleepMethod.sleep(3);

        driver.findElement(By.id("_submit")).click();
        SleepMethod.sleep(2);

        WebElement saleOption=driver.findElement(By.linkText("Sales"));
        System.out.println(saleOption.isDisplayed());
    }

    @Test
    public void test2(){
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        SleepMethod.sleep(3);

        driver.findElement(By.id("_submit")).click();
        SleepMethod.sleep(2);


//try{
            //WebElement saleOption=driver.findElement(By.linkText("Sales"));
//            Assert.assertFalse(saleOption.isDisplayed());
//        }catch (Exception e){
//            System.out.println("Not displayed");
//        }

        Assert.assertFalse(VerificationUtils.isElementDisplayed(driver, By.linkText("Sales")));

    }
    @Test
    public void iWillDeleteItLater(){
        String ex="1";
        String ac="1";
        VerificationUtils.verifyEquals(ex,ac);


    }





}
