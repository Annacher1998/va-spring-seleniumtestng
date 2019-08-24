package BRPHomeworkJuly10;

import com.cybertek.utilities.SleepMethod;
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase1002 {


    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://54.148.96.210/web/login");
    }

    @Test
    public void test1(){

        int x = 10;


        while (x <= 14) {
            SleepMethod.sleep(2);
            driver.findElement(By.id("login")).sendKeys("expensesmanager" + x + "@info.com");
            x++;
            SleepMethod.sleep(2);
            driver.findElement(By.id("password")).sendKeys("expensesmanager");
            SleepMethod.sleep(1);
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            SleepMethod.sleep(4);

            driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'\n" +
                    "                Expenses\n" +
                    "            ')]")).click();
            SleepMethod.sleep(2);


            driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(), '\n" +
                    "                Expense Products\n" +
                    "            ')]")).click();
            SleepMethod.sleep(2);



            driver.findElement(By.xpath("//button[@accesskey='c' and contains(text(),'\n" +
                    "            Create\n" +
                    "        ')]")).click();
            SleepMethod.sleep(2);


            driver.findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input o_required_modifier']")).sendKeys("Air");
            SleepMethod.sleep(4);

            //driver.findElement(By.name("list_price")).sendKeys("1.00");
            //SleepMethod.sleep(3);

driver.findElement(By.xpath("//button[@accesskey='s' and contains(text(),'\n" +
        "            Save\n" +
        "        ')]")).click();

            SleepMethod.sleep(3);

            String errorLine ="//h4[@class='modal-title'and contains(text(),'Odoo Server Error')]";
            System.out.println(driver.findElement(By.xpath(errorLine)).getText());
            VerificationUtils.isElementDisplayed(driver, By.xpath(errorLine));
            SleepMethod.sleep(2);

           driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")).click();
           SleepMethod.sleep(2);


            driver.findElement(By.xpath("//img[@class='img-circle oe_topbar_avatar']")).click();
            SleepMethod.sleep(2);

            driver.findElement(By.cssSelector("a[data-menu='logout']")).click();
            SleepMethod.sleep(2);


            driver.findElement(By.xpath("//span[contains(text(), 'Ok')]")).click();
            SleepMethod.sleep(2);

        }


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
