package com.cybertek.tests.RadioButtonClass;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;

public class TestRadioButtons {

    public static void main(String[] args) {
/*
Go to http://practice.cybertekschool.com/radio_buttons
verify that none of the options under Select your favorite sport: are selected by default
select any radio button
verify that only that button is selected and others are not
select any other radio button
verify that only that other button is selected and others are not

NOTE: select different buttons every time
 */

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");


        List<WebElement> elements=driver.findElements(By.name("sport"));
        System.out.println(elements.size());

//verify non selected
        for (WebElement element : elements) {
            VerificationUtils.verifySelected(element,false);
        }

        //selection hockey

        System.out.println("Selecting hockey");
        Random random=new Random();
        int number=random.nextInt(4);
        System.out.println(number);
elements.get(number).click();
//verify that only one selected

for(int i=0;i<elements.size();i++){
   if(i==number){
       VerificationUtils.verifySelected(elements.get(i),true);

   }else{
       VerificationUtils.verifySelected(elements.get(i),false);
   }
}

//select any other radio button
        int num2;
do{
    num2=random.nextInt(4);
}while (num2==number);
        System.out.println(number);
        System.out.println(num2);
        elements.get(num2).click();

        //verify that only that other button is selected and others are not

//        if(elements.get(num2).isSelected()){
//            System.out.println("TRUE");
//        }else{
//            System.out.println("FALSE");
//        }

        for(int i=0;i<elements.size();i++){
            if(i==num2){
                VerificationUtils.verifySelected(elements.get(i),true);

            }else{
                VerificationUtils.verifySelected(elements.get(i),false);
            }
        }


    }
}
