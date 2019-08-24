package com.cybertek.tests.RadioButtonClass;

import com.cybertek.utilities.SleepMethod;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ButtonActivitiesClass {

    WebDriver driver;
    @BeforeClass

        public void beforeClass(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.get("http://qa3.vytrack.com/user/login");
    }



    //SCENARIO #1
/*
Scenario: Verify for store manager

Login as store manager
Go to Activities --> Calls
Verify that Log Call button is displayed
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed
 */
    @Test
    public void test1(){
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        SleepMethod.sleep(3);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        SleepMethod.sleep(3);

        driver.findElement(By.id("_submit")).click();
        SleepMethod.sleep(2);

        driver.findElement(By.linkText("Activities")).click();
        SleepMethod.sleep(2);
        driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(), 'Calls')]")).click();
        SleepMethod.sleep(1);

        String logCall ="//a[@title='Log call' and contains(text(), '\n" +
                "        Log call\n" +
                "    ')]";

        VerificationUtils.isElementDisplayed(driver,By.xpath((logCall)));

    }
@Test
public void test2(){
    SleepMethod.sleep(3);
    driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
    SleepMethod.sleep(3);
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
    SleepMethod.sleep(3);

    driver.findElement(By.id("_submit")).click();
    SleepMethod.sleep(2);

    driver.findElement(By.linkText("Activities")).click();
    SleepMethod.sleep(2);


    driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(), 'Calendar Events')]")).click();
    SleepMethod.sleep(2);

    String createrCal="//a[@class='btn main-group btn-primary pull-right 'and contains(text(),'Create Calendar event)]";
    VerificationUtils.isElementDisplayed(driver, By.xpath(createrCal));
}






    //SCENARIO #2
/*
Scenario: Verify for sales manager
Login as sales manager
Go to Activities --> Calls
Verify that Log Call button is displayed
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed
 */

@Test
    public void SaleManager1(){
    SleepMethod.sleep(3);
    driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
    SleepMethod.sleep(3);
    driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
    SleepMethod.sleep(3);

    driver.findElement(By.id("_submit")).click();
    SleepMethod.sleep(2);

    driver.findElement(By.linkText("Activities")).click();
    SleepMethod.sleep(2);
    driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(), 'Calls')]")).click();
    SleepMethod.sleep(1);

    String logCall ="//a[@title='Log call' and contains(text(), '\n" +
            "        Log call\n" +
            "    ')]";

    VerificationUtils.isElementDisplayed(driver,By.xpath((logCall)));
}

@Test
    public void SaleManager2(){
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

    String createrCal="//a[@class='btn main-group btn-primary pull-right 'and contains(text(),'Create Calendar event')]";
    VerificationUtils.isElementDisplayed(driver, By.xpath(createrCal));
}

    @AfterClass
    public void afterMethod(){
        driver.quit();
    }
}
