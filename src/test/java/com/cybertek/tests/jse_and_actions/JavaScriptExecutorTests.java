package com.cybertek.tests.jse_and_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {



    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }



    @Test
    public void  jse1(){
        driver.get("http://practice.cybertekschool.com");

        // this is JavascriptExecutor object is created
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        // jse will execute the command we passing in String
        jse.executeScript("alert('Welcome to Cybertek') ;");


        }


@Test
public void scroll() throws InterruptedException {
// this is JavascriptExecutor object is created
    JavascriptExecutor jse =(JavascriptExecutor) driver;


    driver.get("http://practice.cybertekschool.com/infinite_scroll");
    Thread.sleep(2000);

// scrolling page 5 times
    for(int i=0;i<5;i++) {
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }
}

@Test
public void scrollToElement() throws InterruptedException {
    JavascriptExecutor jse =(JavascriptExecutor) driver;
    driver.get("http://practice.cybertekschool.com/large");
    Thread.sleep(2000);
    WebElement link=driver.findElement(By.linkText("Cybertek School"));
    Thread.sleep(1000);
//executeScript is overloaded method and can take string ans web-element param
    jse.executeScript("arguments[0].scrollIntoView(true)",link);




}

   @Test
    public void click() throws InterruptedException {
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        driver.get("http://practice.cybertekschool.com/large");
        Thread.sleep(2000);
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(1000);
//executeScript is overloaded method and can take string ans web-element param
        jse.executeScript("arguments[0].click()",link);
        Thread.sleep(2000);


    }

    @Test
    public void type(){
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement enable=driver.findElement(By.cssSelector("#input-example>input"));
//jse.executeScript("arguments[0].setAttribute('value','blah blah')",enable) ;
        String string="blah blah";
        jse.executeScript("arguments[0].setAttribute('value','"+string+"')",enable) ;
    }



    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
