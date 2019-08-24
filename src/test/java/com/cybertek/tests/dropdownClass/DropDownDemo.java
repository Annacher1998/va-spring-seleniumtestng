package com.cybertek.tests.dropdownClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement select=driver.findElement(By.id("state"));
        Select states=new Select(select);

        List<WebElement> alloptions=states.getOptions();
        System.out.println("Number of options : "+ alloptions.size());

        //iterate through the options and compare one option to next one
        String str="";
        for(int i=1;i<alloptions.size();i++){
            str=(alloptions.get(i).getText());
            String next=alloptions.get(i+1).getText();
            System.out.println(str+"\n");

            System.out.println("Comparing: "+str+" "+ next);
            if(str.compareTo(next)<0){
                System.out.println("Pass");
            }else{
                System.out.println("FAIL");
            }
        }
        //verify isAlphabetic






    }
}
