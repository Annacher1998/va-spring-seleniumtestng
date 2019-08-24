package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class VytrackShortcutFunctionality {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //GO TO WEBSITE
        driver.get("http://qa3.vytrack.com/user/login");
        Thread.sleep(2000);

        //USERNAME INPUT

        WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager103");
        Thread.sleep(1000);

        //PASSWORD INPUT
        WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        Thread.sleep(1000);



        // CLICKING ON LOG IN BUTTON
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(1000);
        System.out.println(driver.getTitle());

        // CLICKING ON SHTORCUTS BUTTON
        WebElement shortcut=driver.findElement(By.xpath("//i[@class='fa-share-square']"));
        shortcut.click();
        Thread.sleep(500);

        //CLICKING ON FULL LIST BUTTON
        driver.findElement(By.xpath("//a[contains(text(),'See full list')]")).click();
        Thread.sleep(2000);

        //CLICKING ON OPPORTUNITIES BUTTON
       // WebElement click=driver.findElement(By.xpath("//a[@href='/opportunity']"));
        WebElement click=driver.findElement(By.linkText("Opportunities"));
        click.click();
        Thread.sleep(1000);


        //CLICKING ON Shortcuts BUTTON
       WebElement shCut= driver.findElement(By.xpath("//i[@class='fa-share-square']"));
       shCut.click();
        Thread.sleep(1000);

        //CLICKING ON See full list BUTTON

        driver.findElement(By.xpath("//a[contains(text(),'See full list')]")).click();
        Thread.sleep(1000);

        //CLICKING ON Vehicle Service Logs BUTTON

    }
}
