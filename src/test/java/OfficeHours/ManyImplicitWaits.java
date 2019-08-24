package OfficeHours;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ManyImplicitWaits  {


    @Test
    public void manyImplicitWait() {
        WebDriver driver= Driver.get();

        //waits for findElement method cannot find the element

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //waits for the page load completely
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

        //waits for javaScript processes in the page to finish
        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);


    }
}
