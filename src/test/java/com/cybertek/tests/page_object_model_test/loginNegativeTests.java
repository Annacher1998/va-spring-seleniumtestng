package com.cybertek.tests.page_object_model_test;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginNegativeTests  extends TestBase {

    @BeforeMethod
    public void beforeMethod2(){
        driver.get(ConfigurationReader.get("url"));


    }

    @Test
    public void blankUsernamePasswordTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.login.click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.vytrack.com/user/login");
    }
    @Test
    public void wrongCredentialstest(){
        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys("superusername");
        loginPage.password.sendKeys("dfdfd");
        loginPage.login.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://qa3.vytrack.com/user/login");

    }

}
