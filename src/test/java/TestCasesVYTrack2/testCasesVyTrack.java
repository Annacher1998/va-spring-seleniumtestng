package TestCasesVYTrack2;
import java.util.List;
import java.util.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VerificationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCasesVyTrack extends TestBase {





    @Test
    public void VerifyRepeatOptions() throws Exception{
    driver.get("http://qa3.vytrack.com/user/login");
    String username= ConfigurationReader.get("driverUsername");
    String password=ConfigurationReader.get("driverPassword");

    VerificationUtils.login(driver,username,password);

    Actions actions=new Actions(driver);
//VerificationUtils.selectMenuOption(driver,"Activities","Calendar Events");
    WebElement activities=driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(), ' Activities')]"));
    WebElement calendar=driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]"));

    actions.moveToElement(activities).pause(1000).moveToElement(calendar).click().build().perform();


Thread.sleep(2000);
    WebElement create=driver.findElement(By.xpath("//a[@title='Create Calendar event' and contains(text(),'\n" +
            "        Create Calendar event\n" +
            "    ')]"));
    create.click();
    Thread.sleep(4000);


    WebElement repeat=driver.findElement(By.xpath("//div/input[@type='checkbox'and contains(@id,'recurrence')]"));
    repeat.click();
    Thread.sleep(2000);
    Select select=new Select(driver.findElement(By.xpath("//select[contains(@id,'recurrence')]")));
    List<WebElement> options = select.getOptions();

    List<String> expected = new ArrayList<>();
    expected.add("Daily");
    expected.add("Weekly");
    expected.add("Monthly");
    expected.add("Yearly");
    for (int i = 0; i < options.size(); i++) {
      Assert.assertEquals(options.get(i).getText(), expected.get(i));
    }


}
    @Test
    public void DailyRepeatOption() throws InterruptedException {
/*
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day
  Check the weekday checkbox
Verify that days input now disabled
Verify summary says Daily every weekday

 */


        driver.get("http://qa3.vytrack.com/user/login");
        String username= ConfigurationReader.get("driverUsername");
        String password=ConfigurationReader.get("driverPassword");

        VerificationUtils.login(driver,username,password);

        Actions actions=new Actions(driver);

        WebElement activities=driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(), ' Activities')]"));
        WebElement calendar=driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]"));

        actions.moveToElement(activities).pause(1000).moveToElement(calendar).click().build().perform();


        Thread.sleep(2000);
        WebElement create=driver.findElement(By.xpath("//a[@title='Create Calendar event' and contains(text(),'\n" +
                "        Create Calendar event\n" +
                "    ')]"));
        create.click();
        Thread.sleep(4000);


        WebElement repeat=driver.findElement(By.xpath("//div/input[@type='checkbox'and contains(@id,'recurrence')]"));
        repeat.click();
        Thread.sleep(2000);

        String expected="Daily";
        String actual="//select[contains(@id,'recurrence')]";

        //VERIFYING THAT DAILY IS DISPLAYED
        WebElement daily=driver.findElement(By.cssSelector("option[value='daily']"));
        System.out.println(daily.getText());
        System.out.println(daily.isDisplayed());
        //VERIFYING THAT REPEAT BUTTON IS SELECTED
        WebElement repeatEveryBtn=driver.findElement(By.xpath("//input[contains(@checked,'checked')]"));
        System.out.println(repeatEveryBtn.isSelected());

        //VERIFYING THAT DEFAULT VALUE IS 1
        System.out.println("Verifying default value is 1");
String expectedValue="1";
       String actualValue=driver.findElement(By.cssSelector("input[class= 'recurrence-subview-control__number'][value='1']")).getText();
        System.out.println(actualValue);
        VerificationUtils.verifyEquals(expectedValue,actualValue);

        //VERIFY SUMMARY
        System.out.println("Verify summary");
        String expectedSummary="Daily every 1 day";
        String actualSummary=driver.findElement(By.xpath("//span[contains(text(), 'Daily every 1 day')]")).getText();
        VerificationUtils.verifyEquals(expectedSummary,actualSummary);



        //Check the weekday checkbox
        driver.findElement(By.xpath("(//label/input[contains(@type,'radio')])[2]")).click();

        //Verify that days input now disabled

        Assert.assertFalse(VerificationUtils.isElementDisplayed(driver, By.xpath("//input[contains(@name,'temp-validation-name')]")));


        //Verify summary says Daily every weekday

        String expectedWeedkaySummary="Daily, every weekday";
        String actualWeekdaySummary=driver.findElement(By.xpath("//div/span[contains(text(),'Daily, every weekday')]")).getText();

        VerificationUtils.verifyEquals(expectedWeedkaySummary,actualWeekdaySummary);

    }

    @Test
    public void RepeatEveryErrorMessages() throws InterruptedException {

        /*
        Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Test the day(s) checkbox entering different values( the boundary value analysis)
Verify error messages The value have not to be less than 1. and The value have not to be more than 99. occur when values are too big or small
Verify that error messages disappear when valid values are entered
         */
        driver.get("http://qa3.vytrack.com/user/login");
        String username= ConfigurationReader.get("driverUsername");
        String password=ConfigurationReader.get("driverPassword");

        VerificationUtils.login(driver,username,password);

        Actions actions=new Actions(driver);

        WebElement activities=driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(), ' Activities')]"));
        WebElement calendar=driver.findElement(By.xpath("//span[@class='title title-level-2' and contains(text(),'Calendar Events')]"));

        actions.moveToElement(activities).pause(1000).moveToElement(calendar).click().build().perform();


        Thread.sleep(2000);
        WebElement create=driver.findElement(By.xpath("//a[@title='Create Calendar event' and contains(text(),'\n" +
                "        Create Calendar event\n" +
                "    ')]"));
        create.click();
        Thread.sleep(4000);


        WebElement repeat=driver.findElement(By.xpath("//div/input[@type='checkbox'and contains(@id,'recurrence')]"));
        repeat.click();
        Thread.sleep(2000);


        //Test the day(s) checkbox entering different values( the boundary value analysis)
//Verify error messages The value have not to be less than 1.
// and The value have not to be more than 99. occur when values are too big or small

       WebElement value=driver.findElement(By.xpath("//label/input[contains(@class,'recurrence-subview-control__number error')]"));
        BrowserUtils.waitForVisibility(value,10);
       int value1=1;
       String expectedValue1="The value have not to be less than 1.";
       String actualValue1=driver.findElement(By.xpath("//span[contains(text(), 'The value have not to be less than 1.')]")).getText();
        value.sendKeys(""+value1);
        String expectedValue2="The value have not to be more than 99.";
        String actualValue2=driver.findElement(By.xpath("//span[contains(text(),'The value have not to be more than 99.')]")).getText();
       if(value1==0){
          VerificationUtils.verifyEquals(expectedValue1,actualValue1);
       }else if(value1>99){
           VerificationUtils.verifyEquals(expectedValue2,actualValue2);
       }else {
           while (value1 <= 11) {
               value.sendKeys(""+value1++);



           }


       }


    }

}
