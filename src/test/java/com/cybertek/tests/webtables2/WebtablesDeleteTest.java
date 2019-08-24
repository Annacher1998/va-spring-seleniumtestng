package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebtablesDeleteTest  extends TestBase {

    /*
    click on delete for tconway@earthlink.net
    verify tconway@earthlink.net	does not exist in emails table

     */

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/tables");
//WebElement conway=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[3]"));

        //clicking on DELETE BTN
        String xpath="//table[@id='table1']//td[.='tconway@earthlink.net']/../td[6]/a[2]";
       WebElement deleteBtn= driver.findElement(By.xpath(xpath));
        deleteBtn.click();



       List<WebElement>emails=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
       List<String> emailStr= BrowserUtils.getElementsText(emails);

        Assert.assertFalse(emailStr.contains("tconway@earthlink.net"));


    }


}
