package com.cybertek.tests.page_object_model_test;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class positiveLoginTests  extends TestBase {


    @BeforeMethod
    public void setup(){
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void loginDriverTest(){

        //give name to the test
        extentLogger=report.createTest("Positive login as Driver");
        //prints the passed string to the report, used to capture test steps...
        extentLogger.info("Getting user credentials");

        System.out.println("getting username");
        String username=ConfigurationReader.get("driverUsername");
        String password=ConfigurationReader.get("driverPassword");

        LoginPage loginPage=new LoginPage();
        extentLogger.info("Entering username and password");
        System.out.println("entering username");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        extentLogger.info("clicking on submit");
        loginPage.login.click();

        BrowserUtils.waitFor(2);

        extentLogger.info("Verifying title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
        extentLogger.pass("PASSED: Positive login as a Driver");

    }

    @Test
    public void salesManagerTest(){

        // give name to the test
        extentLogger = report.createTest("Positive login as Sales manager");
        // prints the passed string to the report, used to capture test steps ...
        extentLogger.info("Getting user credentials");
        String username = ConfigurationReader.get("salesUsername");
        String password = ConfigurationReader.get("salesPassword");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Entering username and salesmanager_password");
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);

        extentLogger.info("Clicking on submit");
        loginPage.login.click();
        BrowserUtils.waitFor(2);

        extentLogger.info("Verifying title contains Dashboard");
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));

        extentLogger.pass("PASSED: Positive login as Sales manager");

    }



    @Test
    public void storemanagerTest(){

        String username=ConfigurationReader.get("storemanagerUsername");
        String password=ConfigurationReader.get("storemanagerPassword");
        LoginPage loginPage=new LoginPage();

        loginPage.login(username,password);

        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));

    }





}
