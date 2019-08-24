package review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.VerificationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WaitReviewTest extends TestBase {

    @Test
    public void implicitWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(message.getText());

    }

    @Test
    public void implicitWaitTes2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
WebElement start=driver.findElement(By.tagName("button"));
start.click();
        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(message.getText());

    }

    @Test
    public void waitForInvisibleExplicitWait(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        //until-->this is when waiting starts
        //2.ExpectedConditions.invisibilityOfElementLocated-->what are we waiting for
        //3. which element --> By.id("id");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        WebElement message=driver.findElement(By.id("finish"));
        System.out.println(message.getText());
    }

    @Test
    public void waitForInvisibleExplicitWait2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement submit=driver.findElement(By.tagName("button"));


        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        username.sendKeys("AnnaCher");
        password.sendKeys("12121");
        submit.click();
    }

    @Test
    public void testTitle() throws  Exception{
        driver.get("http://qa3.vytrack.com/user/login");
        VerificationUtils.login(driver,"user1","UserUser123");
        System.out.println(driver.getTitle());
        VerificationUtils.selectMenuOption(driver,"Fleet","Vehicle");

        //waits untill title changes and conatains string "car"
wait.until(ExpectedConditions.titleContains("Car"));
        System.out.println(driver.getTitle());
    }

}
