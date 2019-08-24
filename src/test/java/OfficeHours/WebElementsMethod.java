package OfficeHours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebElementsMethod {


    public static void main(String[] args) throws InterruptedException {

        WebDriver  driver=new ChromeDriver();


        WebElement element =driver.findElement(By.id("u_0_p"));



//getAttribute(str): to get the value of the given attribute,returns String

        String str=element.getAttribute("attribute goes here");

        //getText(): returns the linkText of the WebElement

        String str2=element.getText();

        //getTagName(): returns the tagname of the html as a String
        String str3=element.getTagName();


        //clear()--> clear the inputs
        element.clear();
        //submit(): keys.Enter, submits
        element.submit();
        //isSelected--> returns boolean expression , used for veryfing radio buttons,and checkboxes

        element.isSelected();

        //isDispalayed : returns boolean expression, verify if the element is displayed

        boolean b=element.isDisplayed();

        //isEnabled(): checks the link and button for enability


    }
}
