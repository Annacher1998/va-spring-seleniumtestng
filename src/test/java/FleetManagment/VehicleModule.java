package FleetManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class VehicleModule {


    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://qa3.vytrack.com/user/login");
        Thread.sleep(1000);
      WebElement emailInput=driver.findElement(By.id("prependedInput"));
      emailInput.sendKeys("user1");
      WebElement passwordInp=driver.findElement(By.id("prependedInput2"));
      passwordInp.sendKeys("UserUser123");

      Thread.sleep(4000);

      String title=driver.getTitle();
        System.out.println("Title: "+title);

        WebElement loginBtn=driver.findElement(By.id("_submit"));
        loginBtn.click();



        WebElement fleet=driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleet.click();
Thread.sleep(1000);
    WebElement vehicleOdm= driver.findElement(By.linkText("Vehicle Odometer"));
vehicleOdm.click();
Thread.sleep(1000);


WebElement create=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[2]/a"));
create.click();

        Thread.sleep(1000);


//driver.quit();
    }

}
