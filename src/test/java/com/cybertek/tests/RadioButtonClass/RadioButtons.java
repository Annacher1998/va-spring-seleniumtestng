package com.cybertek.tests.RadioButtonClass;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
Thread.sleep(2000);
        //verify blue is selected by default

        WebElement blue=driver.findElement(By.id("blue"));
        WebElement red=driver.findElement(By.id("red"));

        Thread.sleep(2000);
        System.out.println("Blue: "+blue.isSelected());
        System.out.println("Red: "+red.isSelected());

        System.out.println("Selected red");
        red.click();


         //verify blue is not selected
        VerificationUtils.verifySelected(blue,false);
VerificationUtils.verifySelected(red,true);


// see if element is disabled or enabled

        WebElement green=driver.findElement(By.id("green"));
        System.out.println("Is green enabled: "+green.isEnabled());
        System.out.println("Is red enabled: "+red.isEnabled());

green.click();
VerificationUtils.verifySelected(green,false);
    }
}
