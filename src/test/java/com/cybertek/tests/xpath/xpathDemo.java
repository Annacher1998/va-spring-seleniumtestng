package com.cybertek.tests.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class xpathDemo {

@Test
    public void absoluteXpath(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    String expectedUrl="http://practice.cybertekschool.com/signup_confirmation";
driver.get("http://practice.cybertekschool.com/signup_confirmation");
    System.out.println("Expected url: "+expectedUrl);
    System.out.println("Printing the first link");

    System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/div/a/i")).getText());


    System.out.println("Printing second link");
    System.out.println(driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());



}

@Test
    public void relativeXpathUsingParentChild(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    String expectedUrl="http://practice.cybertekschool.com/signup_confirmation";
    driver.get("http://practice.cybertekschool.com/signup_confirmation");
    System.out.println("Expected url: "+expectedUrl);
    System.out.println("Printing the first link");
    System.out.println(driver.findElement(By.xpath("//body/nav/ul/li/a")).getText());

    System.out.println("Printing the first link again " );
    System.out.println(driver.findElement(By.xpath("//body/nav//a")).getText());

}
@Test
    public void relativeXpathUsingAttribute(){
  //A CERTAIN TAG WITH ATTRI VALUE COMBO
    WebDriverManager.chromedriver().setup();

    WebDriver driver=new ChromeDriver();

    String expectedUrl="http://practice.cybertekschool.com/multiple_buttons" ;
    driver.get("http://practice.cybertekschool.com/multiple_buttons");

    System.out.println("click on button: Dont click");

    driver.findElement(By.xpath("//button[@id='disappearing_button']")).click();

    //ANY TAG
    driver.navigate().refresh();
    driver.findElement(By.xpath("//*[@id='disappearing_button']")).click();

    //CONTAINS CERTAIN STRING IN VALUE OF SOME ATTRIBUTE

    driver.findElement(By.xpath("//button[contains(@id,'button_')]")).getText();

}
@Test
    public void relativeXpathUsingText(){
    WebDriverManager.chromedriver().setup();

    WebDriver driver=new ChromeDriver();

    String expectedUrl="http://practice.cybertekschool.com/multiple_buttons" ;
    driver.get("http://practice.cybertekschool.com/multiple_buttons");

    //USING EXACT TEXT

    //System.out.println(driver.findElement(By.xpath("//button[.='Button 3']")).getText());
    System.out.println(driver.findElement(By.xpath("//*[.='Button 3']")).getText());

    //USING PATRIAL TEXT

    System.out.println(driver.findElement(By.xpath("//button[contains(text(),'click')]")).getText());
}

@Test
    public void relativeXpathByIndex(){
    WebDriverManager.chromedriver().setup();

    WebDriver driver=new ChromeDriver();

    String expectedUrl="http://practice.cybertekschool.com/multiple_buttons" ;
    driver.get("http://practice.cybertekschool.com/multiple_buttons");

    //NTH CHILD
    System.out.println(driver.findElement(By.xpath("//button[2]")).getText());
    System.out.println(driver.findElement(By.xpath("//button[6]")).getText());
    driver.findElement(By.xpath("//button[6]")).click();
    System.out.println(driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/p")).getText());






}

}
