package com.cybertek.tests.dropdownClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenu {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement select=driver.findElement(By.id("dropdown"));
        Select dropdownList=new Select(select);


        // READ THE SELECT OPTION
        //getFirstSelectedOption()--> return first selected option
        WebElement selectedOPtion=dropdownList.getFirstSelectedOption();
        System.out.println(selectedOPtion.getText());

        //get all availible options
//getOptions()--> returns all avaible options

        List<WebElement> alloptions=dropdownList.getOptions();
        System.out.println("Number of options : "+ alloptions.size());


        for(WebElement option:alloptions){
            System.out.println(option.getText());
        }
Thread.sleep(1000);
        //how to select using visible text
        System.out.println("**** Selecting Option 1 ****");
        dropdownList.selectByVisibleText("Option 1");
        selectedOPtion=dropdownList.getFirstSelectedOption();
        System.out.println(selectedOPtion.getText());
Thread.sleep(1000);
        System.out.println("**** Selecting Option 2 ****");
        dropdownList.selectByVisibleText("Option 2");
        selectedOPtion=dropdownList.getFirstSelectedOption();
        System.out.println(selectedOPtion.getText());

        //HOW TO SELECT USING INDEX

        System.out.println(" **** Selecting Option 1 using SelectByIndex method *****");
Thread.sleep(500);
        dropdownList.selectByIndex(1);
        selectedOPtion=dropdownList.getFirstSelectedOption();
        System.out.println(selectedOPtion.getText());


        //HOW TO SELECT USING VALUE

        System.out.println(" **** Selecting Option 2 using SelectByValue method *****");
Thread.sleep(1000);
        dropdownList.selectByValue("2");
        selectedOPtion=dropdownList.getFirstSelectedOption();
        System.out.println(selectedOPtion.getText());



    }
}
