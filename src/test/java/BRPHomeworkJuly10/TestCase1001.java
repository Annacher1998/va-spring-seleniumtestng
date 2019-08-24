package BRPHomeworkJuly10;

import com.cybertek.utilities.SleepMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestCase1001 {

    WebDriver driver;
    @BeforeClass
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://54.148.96.210/web/login");

    }

    @Test
    public void test1001() throws InterruptedException {
Thread.sleep(2000);
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

           // WebElement expenses = driver.findElement(By.xpath("//*[@data-menu='388']"));
WebElement expenses = driver.findElement(By.xpath("//span[@class='oe_menu_text' and contains(text(),'\n" +
        "                Expenses\n" +
        "            ')]"));
expenses.click();

            SleepMethod.sleep(4);


            WebElement expProduct = driver.findElement(By.xpath("//*[@data-menu-xmlid='hr_expense.menu_hr_product']"));
            expProduct.click();
            SleepMethod.sleep(4);

            driver.findElement(By.xpath("//img[@class='img-circle oe_topbar_avatar']")).click();
            SleepMethod.sleep(2);


            try {
                WebElement price = driver.findElement(By.xpath("//strong[@modifiers='{}'and contains(text(), 'Price: ')]"));

                System.out.println(price.isDisplayed());
                SleepMethod.sleep(2);
            } catch (Exception e) {
                System.out.println("Not displayed");
            }
            driver.findElement(By.cssSelector("a[data-menu='logout']")).click();
            SleepMethod.sleep(2);


        }
    }

       @AfterClass
        public void afterMethod(){
        SleepMethod.sleep(2);
            driver.quit();
        }


}
