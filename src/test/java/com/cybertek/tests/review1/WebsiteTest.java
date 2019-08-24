package com.cybertek.tests.review1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebsiteTest {

    public static void main(String[] args) throws InterruptedException {
amazonTest();
//ebayTest();
//wikipedia();
    }


    public static void amazonTest() throws InterruptedException {
        /*
        go to amazon
enter any search term
click on search button
verify title contains search term
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoons");
        Thread.sleep(2000);
        driver.findElement(By.className("nav-input")).click();
        String title=driver.getTitle();


if(title.contains("wooden spoons")){
    System.out.println("PASS");

}else{
    System.out.println("FAIL");
}
        driver.quit();
    }

    public static void ebayTest()throws InterruptedException{
        /*
       go to ebay
enter ny search term
click on search button
print the number of results
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("Watches");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(1000);
       System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());

driver.quit();

    }

    public static void wikipedia() throws InterruptedException {
        /*
        EST 3
go to wikipedia.org
enter search term 'selenium webdriver'
click on search button
click on search result 'Selenium (software)'
verify url ends with 'Selenium_(software)'
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.wikipedia.org");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        Thread.sleep(2000);

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(1000);

        String url=driver.getCurrentUrl();

        if(url.endsWith("Selenium_(software)")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

driver.quit();
    }
}
