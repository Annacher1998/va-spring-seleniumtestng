package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageBRP {

    public LoginPageBRP(){
        PageFactory.initElements(Driver.get(),this);
    }

 @FindBy(id="login")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    public WebElement login;


    public void loginBRP(String username,String passwordStr){

       email.sendKeys(username);
       password.sendKeys(passwordStr);
       login.click();

//        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    }
}
