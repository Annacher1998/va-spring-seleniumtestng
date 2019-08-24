package com.cybertek.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class VerificationUtils {

    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.ENTER);
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

    }

public static void verifyEquals(String expected, String actual) {


    if (expected.equals(actual)) {
        System.out.println("PASS");

    } else {
        System.out.println("FAIL");
        System.out.println("Expected= " + expected);
        System.out.println("Actual= " + actual);


    }
}

    public static void verifySelected(WebElement element, boolean checked){
    //if we want to verify is  selected
        if(checked){
            if(element.isSelected()){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("Element must be selected ");
            }
        }
        //if we want to verify is not selected

        if(!checked) {
            if (element.isSelected()) {
                System.out.println("FAIL");
                System.out.println("Element must not  be selected ");
            } else {
                System.out.println("PASS");
            }
        }

}

/*
returns false when:
 1.if element is found and not visible;
 2. element not found, returns true of element found and displayed

 */
public static boolean isElementDisplayed(WebDriver driver, By by){

    try{

       return driver.findElement(by).isDisplayed();
    }catch(NoSuchElementException e) {
        return false;
    }
}
    public static void selectMenuOption(WebDriver driver, String tab, String module) throws InterruptedException {
        // click on tab
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '"+tab+"')]";
        driver.findElement(By.xpath(tabXpath)).click();
        WebElement tabEl=driver.findElement(By.xpath(tabXpath));
        BrowserUtils.hover(tabEl);
        // click on module
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '"+module+"')]";
       WebElement moduleEl= driver.findElement(By.xpath(moduleXpath));
       BrowserUtils.waitForClickablility(moduleEl,5);

    }
    public static void waitForUIOverlay(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader-mask.shown")));
    }
}
