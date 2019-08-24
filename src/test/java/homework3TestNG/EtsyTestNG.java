package homework3TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.cybertek.utilities.SleepMethod.sleep;

public class EtsyTestNG {
    WebDriver driver;
    String expectedURL = "https://www.ebay.com/";

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(expectedURL);
        sleep(2);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }


    @Test
            (priority = 0)
    public void test1(){
        WebElement wooden=driver.findElement(By.id("gh-ac"));
        wooden.sendKeys("wooden spoon");
        wooden.submit();
    }

    @Test
    public void test2(){
        WebElement number=driver.findElement(By.className("srp-controls__count-heading"));
        System.out.println("Save the total number of results: "+number.getText());
        WebElement linkAll = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
        linkAll.click();
        WebElement numberAfter=driver.findElement(By.className("srp-controls__count-heading"));
        System.out.println("New number of searching: "+numberAfter.getText());


    }

    @Test
    public void test5(){
        WebElement empty=driver.findElement(By.id("gh-ac-box2"));
        boolean empty1=empty.isEnabled();
        System.out.println("Search blank is blank: "+empty1);
    }
    @AfterClass
    public void closingBrowser(){
        driver.quit();
    }
}

