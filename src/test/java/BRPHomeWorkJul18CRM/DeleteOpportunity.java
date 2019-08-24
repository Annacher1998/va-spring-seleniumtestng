package BRPHomeWorkJul18CRM;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeleteOpportunity {



    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://54.148.96.210/web/login");

    }

    @Test
    public void test1() throws InterruptedException {

        WebElement email=driver.findElement(By.id("login"));
        email.sendKeys("eventscrmmanager10@info.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("eventscrmmanager");
        WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Log in')]"));
        loginBtn.click();

        WebElement crm=driver.findElement(By.xpath("//span[@class= 'oe_menu_text' and contains(text(),'\n" +
                "                CRM\n" +
                "            ')]"));
        crm.click();
        WebDriverWait wait =new WebDriverWait(driver,10);

WebElement create=driver.findElement(By.xpath("//button[@type='button' and contains(text(),'\n" +
        "            Create\n" +
        "        ')]"));

create.click();

String expectedLine="Create an Opportunity";
String actualLine=driver.findElement(By.xpath("//h4[@class='modal-title' and contains(text(),'Create an Opportunity')]")).getText();
        VerificationUtils.verifyEquals(expectedLine,actualLine);

        WebElement opportunityTitle=driver.findElement(By.xpath("//input[contains(@class,'o_field_char o_field_widget o_input o_required_modifier')]"));
        opportunityTitle.sendKeys("Business lunch");

      WebElement revenue=driver.findElement(By.xpath("//input[contains(@name,'planned_revenue')]"));
      revenue.clear();
      revenue.sendKeys("23.44");


      //Click to save opportunity
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/span[contains(text(),'Create')]")));
driver.findElement(By.xpath("//button/span[contains(text(),'Create')]")).click();



         //Click on list View
        Thread.sleep(1000);
        WebElement listView=driver.findElement(By.xpath("//button[@type='button' and contains(@class,'list')]"));
        wait.until(ExpectedConditions.visibilityOf(listView));
        listView.click();
        Thread.sleep(1000);


        WebElement clickOnOp=driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
        clickOnOp.click();


        Actions actions=new Actions(driver);
        WebElement actionsBtn=driver.findElement(By.xpath("(//button[contains(@class,'o_dropdown_toggler_btn btn btn-sm dropdown-toggle')])[2]"));
        WebElement deleteBtn=driver.findElement(By.xpath("//a[contains(text(),'\n" +
                "                        Delete\n" +
                "                        \n" +
                "                    ')]"));
        actions.moveToElement(actionsBtn).click().moveToElement(deleteBtn).click().perform();

        //Clicking on OK button

        driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();





}



    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
