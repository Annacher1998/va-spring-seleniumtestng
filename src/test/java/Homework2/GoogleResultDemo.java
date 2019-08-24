package Homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Arrays;



public class GoogleResultDemo {

    public static void main(String[] args) throws InterruptedException {


        //javaTest();
        junitTest();
       // RestTest();

    }

    public static void javaTest()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        driver.get("https://google.com");
        Thread.sleep(2000);


        WebElement search=driver.findElement(By.xpath("//input[@maxlength='2048']"));
        search.sendKeys(searchStrs.get(0));
        search.submit();

        Thread.sleep(1000);

        String expectedUrl="https://www.java.com";
        WebElement java=driver.findElement(By.className("LC20lb"));
        java.click();
Thread.sleep(2000);
        String actual=driver.getCurrentUrl();

        utilityResult(expectedUrl,actual);
        driver.navigate().back();

        driver.quit();
    }

public static void utilityResult(String expectedUrl,String actual){
            if (expectedUrl.equals(actual)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("Actual: " + actual);
                System.out.println("Expected: " + expectedUrl);
            }
        }




    public static void junitTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        driver.get("https://google.com");
        Thread.sleep(2000);


        WebElement search=driver.findElement(By.xpath("//input[@maxlength='2048']"));
        search.sendKeys(searchStrs.get(1));
        search.submit();

        Thread.sleep(1000);

        String expectedUrl="https://junit.org/junit5/";
        WebElement junit=driver.findElement(By.className("LC20lb"));
        junit.click();
        Thread.sleep(2000);
        String actual=driver.getCurrentUrl();

        utilityResult(expectedUrl,actual);
        driver.navigate().back();

        driver.quit();
    }

    public static void RestTest() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
            driver.get("https://google.com");
            Thread.sleep(2000);


            WebElement search=driver.findElement(By.xpath("//input[@maxlength='2048']"));
            search.sendKeys(searchStrs.get(2));
            search.submit();

            Thread.sleep(1000);

            String expectedUrl="rest-assured.io/";
            WebElement rest=driver.findElement(By.xpath("//h3[contains(text(),'REST Assured')]"));
            rest.click();
            Thread.sleep(2000);
            String actual=driver.getCurrentUrl();

            utilityResult(expectedUrl,actual);
            driver.navigate().back();
Thread.sleep(2000);
            driver.quit();
    }
}
