package com.cybertek.tests.jse_and_actions;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {



    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
      driver.quit();
    }


    @Test
    public void hover() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement  element=driver.findElement(By.tagName("img"));
        // moveToElement()--> move mouse ot given target
        actions.moveToElement(element).perform();
        Thread.sleep(1000);

        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.linkText("View profile")));


    }

    @Test
    public void hover2() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(2000);


        WebElement firstOne=driver.findElement(By.id("ui-id-3"));
        WebElement secondOne=driver.findElement(By.id("ui-id-4"));
        Thread.sleep(1000);
        actions.moveToElement(firstOne).perform();
        Thread.sleep(1000);
        actions.moveToElement(secondOne).perform();


    }
    @Test
    public void chainingActions() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(2000);


        WebElement firstOne=driver.findElement(By.id("ui-id-3"));
        WebElement secondOne=driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).pause(1000).moveToElement(secondOne).build().perform();


    }

    @Test
    public void dragDrop() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(2000);


WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(source,target).build().perform();
        Thread.sleep(2000);


    }

    @Test
    public void dragDropChain() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(2000);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        //click on source
        //move and let it go

        actions.clickAndHold(source).pause(1000).moveToElement(target).build().perform();


    }

    @Test
    public void scroll() throws InterruptedException {
        //Action class that enables advanced interactions
        Actions actions=new Actions(driver);
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(2000);

        //arrow down

        actions.sendKeys(Keys.ARROW_DOWN).pause(1000).
                sendKeys(Keys.ARROW_DOWN).pause(1000).
                sendKeys(Keys.ARROW_DOWN).pause(1000).build().perform();

        //arrow up
        actions.sendKeys(Keys.ARROW_UP).pause(1000).
                sendKeys(Keys.ARROW_UP).pause(1000).
                sendKeys(Keys.ARROW_UP).pause(1000).build().perform();
        //page down

        actions.sendKeys(Keys.PAGE_DOWN).pause(1000).
                sendKeys(Keys.PAGE_DOWN).pause(1000).
                sendKeys(Keys.PAGE_DOWN).pause(1000).build().perform();
        //page up
        actions.sendKeys(Keys.PAGE_UP).pause(1000).
                sendKeys(Keys.PAGE_UP).pause(1000).
                sendKeys(Keys.PAGE_UP).pause(1000).build().perform();




    }
}
