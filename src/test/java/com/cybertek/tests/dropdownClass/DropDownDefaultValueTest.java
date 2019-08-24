package com.cybertek.tests.dropdownClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class DropDownDefaultValueTest {
    /*
    Test1
Open url
Verify default option is Please select Option

Test 2
Open url
Verify default option for year is 2019

Test 3
Open url
Verify default option for states is Please select a state
Close browser

     */

    @BeforeClass
    public void beforeClass(){
        System.out.println("starting setting up workflow");
    }
    @BeforeMethod
            public void beforeMethod(){
        System.out.println("setting path");
    }
WebDriver driver;
    @Test
    public void dropDown1Test(){

        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select dropdown=new Select(driver.findElement(By.id("dropdown")));
        String exp="Please select an option";

        //getting the string value of the selected option of the dropdown
        String actual=dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(exp,actual);

    }

    @Test
    public void dropDownTest2(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select dropdown=new Select(driver.findElement(By.id("year")));
        String exp="2019";

        //getting the string value of the selected option of the dropdown
        String actual=dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(exp,actual);


    }

    @Test
    public void dropDownTest3(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select dropdown=new Select(driver.findElement(By.id("state")));
        String exp="Select a State";

        //getting the string value of the selected option of the dropdown
        String actual=dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(exp,actual);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @AfterClass
    public static  void afterClass(){
        System.out.println("all work is done");
    }
}
