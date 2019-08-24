package FleetManagment;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LogIn {

    public static void main(String[] args) throws InterruptedException {

//chromeTest();
fireFoxTest();
//safariTest();
    }


    public static void chromeTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
// go to url
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");

        Thread.sleep(1000);
        String expectedUrl = "http://qa3.vytrack.com/";

        WebElement userNameBtn = driver.findElement(By.id("prependedInput"));
        userNameBtn.sendKeys("user1");
        Thread.sleep(1000);

        WebElement passwordBtn = driver.findElement(By.id("prependedInput2"));
        passwordBtn.sendKeys("UserUser123");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();


        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(1000);

        VerificationUtils.verifyEquals(expectedUrl, actualUrl);
driver.quit();

    }

    public static void fireFoxTest() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
// go to url
        WebDriver driver = new FirefoxDriver();
        driver.get("http://qa3.vytrack.com/user/login");

        Thread.sleep(1000);
        String expectedUrl = "http://qa3.vytrack.com/";

        WebElement userNameBtn = driver.findElement(By.id("prependedInput"));
        userNameBtn.sendKeys("user1");
        Thread.sleep(1000);

        WebElement passwordBtn = driver.findElement(By.id("prependedInput2"));
        passwordBtn.sendKeys("UserUser123");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(1000);

        VerificationUtils.verifyEquals(expectedUrl, actualUrl);
driver.quit();

    }

    public static void safariTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
// go to url

        driver.get("http://qa3.vytrack.com/user/login");

        Thread.sleep(1000);
        String expectedUrl = "http://qa3.vytrack.com/";

        WebElement userNameBtn = driver.findElement(By.id("prependedInput"));
        userNameBtn.sendKeys("user1");
        Thread.sleep(1000);

        WebElement passwordBtn = driver.findElement(By.id("prependedInput2"));
        passwordBtn.sendKeys("UserUser123");
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.submit();

        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(5000);

        VerificationUtils.verifyEquals(expectedUrl, actualUrl);


        driver.quit();

    }
}