package com.cybertek.tests.dropdownClass;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DropDownWithoutSelectTag {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");


        WebElement dropdownLink=driver.findElement(By.partialLinkText("Dropdown link"));

        dropdownLink.click();

        Thread.sleep(1000);
        System.out.println(dropdownLink.getText());
        List<WebElement> allOptions=driver.findElements(By.className("dropdown-item"));
        System.out.println(allOptions.size());
        for (WebElement allOption : allOptions) {
            System.out.println(allOption.getText());
        }

Thread.sleep(1000);
        allOptions.get(2).click();
        VerificationUtils.verifyEquals("Yahoo",driver.getTitle());

    }
}
