package com.cybertek.tests.page_object_model_test;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclePage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Vehicles extends TestBase {



    @BeforeMethod
    public void setUp2(){
        driver.get(ConfigurationReader.get("url"));
    }
@Test
    public void testFirstHeaderOption(){
        String username=ConfigurationReader.get("driverUsername");
        String password=ConfigurationReader.get("driverPassword");

        //creating new object and using
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        //creating and use the object in the same line . object is not saved
        new DashboardPage().selectMenuOption("Fleet","Vehicles");


        //verifying that first col named is license plate
        String expectedCol="License Plate";
    VehiclePage vehiclePage=new VehiclePage();
    WebElement firstColumn=vehiclePage.gridHeaders.get(0);
    Assert.assertEquals(firstColumn.getText(),expectedCol.toUpperCase());

    }


    @Test
    public void verifyingNoLicensePlate() throws InterruptedException {
        String username=ConfigurationReader.get("driverUsername");
        String password=ConfigurationReader.get("driverPassword");

        //creating new object and using
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        //creating and use the object in the same line . object is not saved
        new DashboardPage().selectMenuOption("Fleet","Vehicles");


        VerificationUtils.waitForUIOverlay();
        WebElement grid=driver.findElement(By.xpath("//a[contains(@title,'Grid Settings')]"));
        wait.until(ExpectedConditions.elementToBeClickable(grid));
        grid.click();


        WebElement uncheckPlate=driver.findElement(By.xpath("(//input[contains(@id,'column-c')])[2]"));
        Assert.assertTrue(uncheckPlate.isSelected());
        wait.until(ExpectedConditions.elementToBeClickable(uncheckPlate));
        uncheckPlate.click();

        VehiclePage vehiclePage=new VehiclePage();
        List<WebElement> allGridHeaders=vehiclePage.gridHeaders;
       // Assert.assertFalse(allGridHeaders.contains("LICENSE PLATE"));

        for (WebElement element:allGridHeaders){
            if(element.getText().equals("LICENSE PLATE")){
                Assert.fail();
            }
        }

    }

}
