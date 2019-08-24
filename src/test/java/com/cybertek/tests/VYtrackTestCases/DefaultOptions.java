package com.cybertek.tests.VYtrackTestCases;

import com.cybertek.utilities.SleepMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultOptions {


    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }

    /*
    Login as sales manager
Go to Activities --> Calendar Events
Click on Create Calendar Event
Default owner name should be current user
Default title should be blank
Default start date should be current date
Default start time should be current time
     */

    @Test
    public void test1(){

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

        //Default owner name should be current user

        String expectedOwner=driver.findElement(By.cssSelector("#user-menu>a")).getText().trim();
        String actual="span[class='select2-chosen']";

        System.out.println(driver.findElement(By.cssSelector(actual)).getText().trim());
        Assert.assertEquals(expectedOwner,driver.findElement(By.cssSelector(actual)).getText().trim());



        //Default title should be blank

        String title="input[data-ftid='oro_calendar_event_form_title']";

        System.out.println(driver.findElement(By.cssSelector(title)).getAttribute("value"));
        Assert.assertEquals(driver.findElement(By.cssSelector(title)).getAttribute("value"),"");

        //Default start date should be current date

        LocalDateTime localDateTime= LocalDateTime.now();

        String date=date=localDateTime.format(DateTimeFormatter.ofPattern("mm-dd-yyyy"));
        String time=localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));

        String actualTime=driver.findElement(By.cssSelector("input[id*='time_selector_oro_calendar_event_form_start']")).getAttribute("value");
        String actualDate=driver.findElement(By.cssSelector("input[id*='date_selector_oro_calendar_event_form_start']")).getAttribute("value");

        Assert.assertEquals(actualDate,date);
        Assert.assertEquals(actualTime,time);


    }
}
