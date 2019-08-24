package com.cybertek.tests.VYtrackTestCases;

import com.cybertek.utilities.SleepMethod;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveAndCancelClass {


    /*
    Test case: Save and Cancel options

Login as sales manager
Go to Activities --> Calendar Events
Click on Create Calendar Event
Verify Cancel button is displayed
Verify Save And Close button is displayed
Click on Save And Close dropdown
Verify Save And Close dropdown option is displayed
Verify Save And New dropdown option is displayed
Verify Save dropdown option is displayed
Click on Save And Close dropdown again
Verify Save And Close dropdown option is not displayed
     */

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
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        SleepMethod.sleep(3);

        driver.findElement(By.id("_submit")).click();
        SleepMethod.sleep(2);
        driver.findElement(By.linkText("Activities")).click();
        SleepMethod.sleep(2);


    //Go to Calendar Events
        driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(), 'Calendar Events')]")).click();
        SleepMethod.sleep(2);


        // Click on Create Calendar Event
        String createrCal="//a[@class='btn main-group btn-primary pull-right 'and contains(text(),'Create Calendar event')]";
        driver.findElement(By.xpath(createrCal)).click();
        SleepMethod.sleep(2);


        //VERIFICATION CANCEL BUTTON IS DISPLAYED
        String cancelBtn="//a[@data-action='cancel' and contains(text(), 'Cancel\n" +
                "    ')]";

        VerificationUtils.isElementDisplayed(driver,By.xpath(cancelBtn));


        //VERIFICATION Save And Close button is displayed


        String saveAndCloseBtn="//div[@type='submit' and contains(text(),'\n" +
                "            Save and Close\n" +
                "        ')]";

        VerificationUtils.isElementDisplayed(driver, By.xpath(saveAndCloseBtn));

        //Click on Save And Close dropdown


        driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']")).click();
        SleepMethod.sleep(2);


        //Verify Save And Close dropdown option is displayed
         String saveAndClodeBtn="//button[@type='submit' and contains(text(), '\n" +
                 "            Save and Close\n" +
                 "        ')]";

         VerificationUtils.isElementDisplayed(driver,By.xpath(saveAndClodeBtn));


         //Verify Save And New dropdown option is displayed

        String saveAndNewBtn="//button[@type='submit' and contains(text(), '\n" +
                "            Save and New\n" +
                "        ')]";

        VerificationUtils.isElementDisplayed(driver,By.xpath(saveAndNewBtn));

        //Verify Save dropdown option is displayed

        String savebtn="//button[@type='sumbit' and contains(text(), '\n" +
                "            Save\n" +
                "        ')]";

        VerificationUtils.isElementDisplayed(driver,By.xpath(savebtn));

        //Click on Save And Close dropdown again
        driver.findElement(By.cssSelector("a[class='btn-success btn dropdown-toggle']")).click();
        SleepMethod.sleep(2);

        //Verify Save And Close dropdown option is not displayed


String lastSaveAndCloseBtn="//a[@class='action-button dropdown-item' and contains(text(),'\n" +
        "            Save and Close\n" +
        "        ')]";
       Assert.assertFalse(VerificationUtils.isElementDisplayed(driver,By.xpath(lastSaveAndCloseBtn)));






    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
