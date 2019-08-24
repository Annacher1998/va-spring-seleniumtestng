package com.cybertek.tests.review1;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextVerification {
    /*
    TEST 003

open browser
go to http://practice.cybertekschool.com/forgot_password
enter any email
click on Retrieve password
verify new confirmation message 'Your e-mail's been sent!'


TEST 004

open browser
go to http://practice.cybertekschool.com/forgot_password
enter any email
verify that email text is displayed
     */

    public static void main(String[] args) throws InterruptedException {
//test003();
test004();
    }

public static void test003() throws InterruptedException {


    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("http://practice.cybertekschool.com/forgot_password");
    Thread.sleep(1000);
    // SendKeys()--> enters text on the webElement
    WebElement emailInput = driver.findElement(By.name("email"));
    emailInput.sendKeys("anna.chernyshova@gmail.com");

    Thread.sleep(4000);
    WebElement retriveBtn = driver.findElement(By.id("form_submit"));
    retriveBtn.click();

    WebElement message = driver.findElement(By.name("confirmation_message"));
    System.out.println(message);
    // getText() return text of a webElement
    System.out.println(message.getText());

    String exp = "Your e-mail's been sent!";

    String act = message.getText();
    VerificationUtils.verifyEquals(exp, act);
}
            public static void test004() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        // SendKeys()--> enters text on the webElement
        WebElement emailInput1 = driver1.findElement(By.name("email"));

        String exp="anna.chernyshova@gmail.com";

    emailInput1.sendKeys(exp);
    Thread.sleep(1000);

    //GET ATTRIBUTE-

                // getAttribute()--> returns value of the given attribute of the element
                System.out.println(emailInput1.getAttribute("name"));
                System.out.println(emailInput1.getAttribute("type"));

                //getAttribute(value)--> use this to get text from input box
    String act=emailInput1.getAttribute("value");
                System.out.println("act= "+act);
    VerificationUtils.verifyEquals(exp,act);


    // getAttribute(innerHTNL)--> if getAttribute(value) does not work.
                System.out.println(emailInput1.getAttribute("innerHTML"));

                //getAttribute(outerHTML)--> returns the HTML of given element
                System.out.println(emailInput1.getAttribute("outerHTML"));


                //HOW TO DELETE TEXT FROM INPUT FIELD
        }


}