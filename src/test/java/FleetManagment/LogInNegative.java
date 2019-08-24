package FleetManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInNegative {


    public static void main(String[] args)throws InterruptedException {
chromeNeg();
    }

    public static void chromeNeg() throws InterruptedException{

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(2000);

        WebElement userNameBtn=driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
userNameBtn.sendKeys("9999999");
Thread.sleep(2000);
WebElement passwordBtn=driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"));
passwordBtn.sendKeys("1212121");
        Thread.sleep(2000);
WebElement logInBtn=driver.findElement(By.id("wooden_spoon"));
logInBtn.click();
        Thread.sleep(2000);

String expectedLine="Your username is invalid!";
WebElement actualLine=driver.findElement(By.id("flash-messages"));

String actual=actualLine.getText();
        actual=actual.substring(0,actual.indexOf("!")+1);
       // System.out.println(actual);

        if(actual.equals(expectedLine)){
            System.out.println("Pass");

        }else{
            System.out.println("Fail");
            System.out.println("Expected line: "+expectedLine);
            System.out.println("Actual line: "+actual);
        }

driver.quit();



    }
}
