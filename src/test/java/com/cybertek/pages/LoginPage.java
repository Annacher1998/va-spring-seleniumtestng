package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);

    }
    @FindBy(id ="prependedInput" )
    public WebElement username;


    @FindBy(id="prependedInput2")
    public WebElement password;


    @FindBy(id="_submit")
    public WebElement login;


public void login(String usernameStr,String passwordStr){
    username.sendKeys(usernameStr);
    password.sendKeys(passwordStr);
    login.click();
   WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    wait.until(ExpectedConditions.titleContains("Dashboard"));
}




}
