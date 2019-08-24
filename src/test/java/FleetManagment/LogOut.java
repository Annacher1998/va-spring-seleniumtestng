package FleetManagment;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOut {


    public static void main(String[] args) throws InterruptedException {

        chromeLogOut();
    }

       public static void chromeLogOut() throws InterruptedException {



        WebDriverManager.chromedriver().setup();
           WebDriver driver=new ChromeDriver();

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

            WebElement JonDoe=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));
             JonDoe.click();
             Thread.sleep(2000);

             WebElement logOut=driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[4]/a"));
             logOut.click();
             Thread.sleep(1000);

driver.quit();
       }
}
