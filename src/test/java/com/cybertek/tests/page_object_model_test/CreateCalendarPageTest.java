package com.cybertek.tests.page_object_model_test;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateCalendarPageTest  extends TestBase {

    @BeforeMethod
    public void setting(){
        driver.get(ConfigurationReader.get("url"));


    }

    @Test
    public void repeatOptionsTest() {
        LoginPage  loginPage=new LoginPage();
        String username=ConfigurationReader.get("salesUsername");
        String password=ConfigurationReader.get("salesPassword");
        loginPage.login(username,password);



        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        VerificationUtils.waitForUIOverlay();
        calendarEventsPage.createCalendarEvent.click();
        VerificationUtils.waitForUIOverlay();

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        String selectedValue=createCalendarEventsPage.repeatOptinsList().getFirstSelectedOption().getText();
        System.out.println(selectedValue);

        Assert.assertEquals(selectedValue,"Daily");
    }
}
