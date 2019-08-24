package com.cybertek.tests.VYtrackTestCases;

import com.cybertek.utilities.SleepMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllDayOptionTestCase {
    /*
    Login as sales manager
Go to Activities --> Calendar Events
Click on Create Calendar Event
All day option checkbox should not be selected
Start time and End time fields should be displayed
Check the All day option checkbox
Start time and End time fields should not be displayed
     */
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }

    @Test
    public void test1() {

        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        SleepMethod.sleep(3);

        driver.findElement(By.id("_submit")).click();
        SleepMethod.sleep(2);
        driver.findElement(By.linkText("Activities")).click();
        SleepMethod.sleep(2);


        driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(), 'Calendar Events')]")).click();
        SleepMethod.sleep(2);

//Click on Create Calendar Event
        String createrCal="//a[@class='btn main-group btn-primary pull-right 'and contains(text(),'Create Calendar event')]";
        driver.findElement(By.xpath(createrCal)).click();
        SleepMethod.sleep(2);


        //All day option checkbox should not be selected




Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());


//Start time and End time fields should be displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='control-group start control-group-datetime']")).isDisplayed());
Assert.assertTrue(driver.findElement(By.xpath("//div[@class='control-group end control-group-datetime']")).isDisplayed());



//Check the All day option checkbox
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        SleepMethod.sleep(2);


        //Start time and End time fields should not be displayed
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='control-group start control-group-datetime']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='control-group end control-group-datetime']")).isDisplayed());

    }



}
