package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class VytrackTitleTest {

    public static void main(String[] args)  throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://qa3.vytrack.com/user/login");

        Thread.sleep(1000);


        WebElement username=driver.findElement(By.id("prependedInput"));
        username.sendKeys("user1");
        Thread.sleep(1000);

        WebElement password=driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        Thread.sleep(1000);

        driver.findElement(By.id("_submit")).click();

        WebElement name=driver.findElement(By.xpath("//a[contains(text(),'\n" +
                "                            John Doe\n" +
                "                                ')]"));


        System.out.println(name.getText());

        driver.findElement(By.className("dropdown-toggle")).click();
        WebElement con=driver.findElement(By.xpath("//a[contains(text(),'My Configuration')]"));
        con.click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());

driver.quit();




    }
}
