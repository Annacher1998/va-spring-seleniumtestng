package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearchTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://ebay.com");
        Thread.sleep(2000);
        WebElement wooden=driver.findElement(By.id("gh-ac"));
        wooden.sendKeys("wooden spoon");
        wooden.submit();
        Thread.sleep(1000);
        WebElement number=driver.findElement(By.className("srp-controls__count-heading"));

        System.out.println("Save the total number of results: "+number.getText());

        String newNumber=number.getText();
        newNumber=newNumber.substring(0,newNumber.indexOf(" results"));
        newNumber=newNumber.replace(",","");
        int number1=Integer.parseInt(newNumber);




//ALL LINK
        WebElement linkAll = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
        linkAll.click();




WebElement numberAfter=driver.findElement(By.className("srp-controls__count-heading"));
        System.out.println("New number of searching: "+numberAfter.getText());
String numberA=numberAfter.getText();
numberA=numberA.substring(0,numberA.indexOf(" results"));
numberA=numberA.replace(",","");
int newNumberAfter=Integer.parseInt(numberA);

        if(number1>newNumberAfter){
            System.out.println(number1+" is smaller than "+newNumberAfter);
        }else{
            System.out.println(newNumberAfter+" is bigger than "+number1);
        }
        driver.navigate().back();
//WebElement wo=driver.findElement(By.id("gh-ac"));
//        String wo1=wo.getText();
//        System.out.println(wo1);
        System.out.println("Title: "+driver.getTitle());
         Thread.sleep(1000);
        driver.navigate().back();



        WebElement empty=driver.findElement(By.id("gh-ac-box2"));
boolean empty1=empty.isEnabled();
        System.out.println("Search blank is blank: "+empty1);
        Thread.sleep(2000);

driver.quit();






    }
}
