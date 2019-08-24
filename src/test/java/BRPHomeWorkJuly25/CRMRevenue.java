package BRPHomeWorkJuly25;


import com.cybertek.pages.LoginPageBRP;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMRevenue extends TestBase {

public CRMRevenue (){
    PageFactory.initElements(Driver.get(),this);
}


@BeforeMethod
    public void setUp3(){
    driver.get(ConfigurationReader.get("url2"));
}

@Test
    public void VerifyingRevenue(){

    String username=ConfigurationReader.get("eventManagerUsername");
    String password=ConfigurationReader.get("eventManagerPassword");


    LoginPageBRP loginPage=new LoginPageBRP();

    loginPage.loginBRP(username,password);


    //go to CRM module

    WebElement crm=driver.findElement(By.linkText("CRM"));
    wait.until(ExpectedConditions.elementToBeClickable(crm));
    crm.click();


    WebElement pivot=driver.findElement(By.xpath("//button[contains(@data-view-type,'pivot')]"));
    wait.until(ExpectedConditions.elementToBeClickable(pivot));
    pivot.click();

    WebElement totalMinus=driver.findElement(By.xpath("//td[@class='o_pivot_header_cell_opened']"));
    wait.until(ExpectedConditions.elementToBeClickable(totalMinus));
    totalMinus.click();

    WebElement totalPlus=driver.findElement(By.xpath("//td[@class='o_pivot_header_cell_closed']"));
    wait.until(ExpectedConditions.elementToBeClickable(totalPlus));
    totalPlus.click();


    WebElement opportunity=driver.findElement(By.partialLinkText("Opportunity"));
    opportunity.click();

String pivotRevenue=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed table')]/tbody/tr[3]/td[2]")).getAttribute("value");

WebElement list=driver.findElement(By.xpath("//button[@accesskey='l']"));
wait.until(ExpectedConditions.elementToBeClickable(list));
list.click();

String listRevenue=driver.findElement(By.xpath("//table[contains(@class,'o_list_view table table-condensed table-striped')]/tbody/tr[4]/td[9]")).getAttribute("value");

    Assert.assertEquals(pivotRevenue,listRevenue);

}
@Test
    public void sumAllRevenues(){
    String username=ConfigurationReader.get("eventManagerUsername");
    String password=ConfigurationReader.get("eventManagerPassword");


    LoginPageBRP loginPage=new LoginPageBRP();

    loginPage.loginBRP(username,password);


    //go to CRM module

    WebElement crm=driver.findElement(By.linkText("CRM"));
    wait.until(ExpectedConditions.elementToBeClickable(crm));
    crm.click();


    WebElement pivot=driver.findElement(By.xpath("//button[contains(@data-view-type,'pivot')]"));
    wait.until(ExpectedConditions.elementToBeClickable(pivot));
    pivot.click();

    WebElement totalMinus=driver.findElement(By.xpath("//td[@class='o_pivot_header_cell_opened']"));
    wait.until(ExpectedConditions.elementToBeClickable(totalMinus));
    totalMinus.click();

    WebElement totalPlus=driver.findElement(By.xpath("//td[@class='o_pivot_header_cell_closed']"));
    wait.until(ExpectedConditions.elementToBeClickable(totalPlus));
    totalPlus.click();


    WebElement opportunity=driver.findElement(By.partialLinkText("Opportunity"));
    opportunity.click();


    String total=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed')]/tbody/tr[1]/td[2]")).getText();
    String value1=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed')]/tbody/tr[2]/td[2]")).getText();
    String value2=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed')]/tbody/tr[3]/td[2]")).getText();
    String value3=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed')]/tbody/tr[4]/td[2]")).getText();
    String value4=driver.findElement(By.xpath("//table[contains(@class,'table-hover table-condensed')]/tbody/tr[5]/td[2]")).getText();


    //TODO SUBDTRING TOTAL
    total=total.replace(",","");
    total=total.substring(0,total.indexOf("."));

    // TODO SUBSTRING VALUE1
    value1=value1.substring(0,value1.indexOf("."));

   //TODO SUBSTRING VALUE2
    value2=value2.replace(",","");
   value2=value2.substring(0,value2.indexOf("."));

   //TODO SUBSTRING VALUE3
    value3=value3.substring(0,value3.indexOf("."));

    //TODO SUBSTRING VALUE4
    value4=value4.substring(0,value4.indexOf("."));



int total1=Integer.parseInt(total);
int v1=Integer.parseInt(value1);
int v2=Integer.parseInt(value2);
int v3=Integer.parseInt(value3);
int v4=Integer.parseInt(value4);

int summary=v1+v2+v3+v4;
Assert.assertEquals(summary,total1);


//TODO REMAKE IT AS DYNAMIC VALUES ,ANNA!


}



}
