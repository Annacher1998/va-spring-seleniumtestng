package OfficeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class AutomationFacebook {


    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver=new ChromeDriver();
//
//        driver.get("https://www.facebook.com");
//        WebElement element =driver.findElement(By.id("u_0_p"));
//        element.sendKeys("Muhtar");
//        Thread.sleep(1000);
//        driver.findElement(By.id("u_0_r")).sendKeys("Medveden");
//        Thread.sleep(1000);
//
//        driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("12129182891");
//        Thread.sleep(1000);
//
//        driver.findElement(By.id("u_0_11")).sendKeys("mamamia111");
//        Thread.sleep(1000);
      //  test1();
        test2();
    }

    //verify all radion buttons can be selected

    public static void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        String str=driver.getTitle().toLowerCase();
        System.out.println("title: "+str);
        if(str.contains("facebook")){
            System.out.println("page title is verified");
        }else{
            System.out.println("page title is not verified");
            System.exit(0);

        }
        System.out.println("Test case is complete");
        driver.quit();

    }

    public static void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

      List<WebElement> allRadio=driver.findElements(By.xpath("//input[@type='radio']"));

      WebElement female=allRadio.get(0);
      WebElement male=allRadio.get(1);
      WebElement custom=allRadio.get(2);

      female.click();

      if(female.isSelected()){
          System.out.println(" first radio button is selected");
      }else{
          System.out.println("first radio button is not selected");
      }

    /*
    *[contains(text(),'Female')];
    *contains(text(),'Custom')];
     */


    WebElement femaleLink=driver.findElement(By.xpath("//*[contains(text(),'Female')]"));
    WebElement maleLink=driver.findElement(By.xpath("//*[contains(text(),'Male')]"));
    WebElement customLink=driver.findElement(By.xpath("//*[contains(text(),'Custom')]"));


    female.click();
    Thread.sleep(1000);
    male.click();
    Thread.sleep(1000);
    custom.click();

    //tagName: button, visible text: Sign Up

        ////button[contains(text(),'Sign Up')];

        WebElement submit=driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        submit.click();

        System.out.println(submit.isEnabled());

        WebElement name=driver.findElements(By.xpath("//*[contains(text(),'First name')]")).get(0);
        System.out.println(name.isEnabled());

    }
}
