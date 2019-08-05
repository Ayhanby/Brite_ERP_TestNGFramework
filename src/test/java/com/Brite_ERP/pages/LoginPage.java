package com.Brite_ERP.pages;

import com.Brite_ERP.utilities.BrowserUtils;
import com.Brite_ERP.utilities.ConfigurationReader;
import com.Brite_ERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {public LoginPage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//b[.='Sign in']")
    public WebElement SignIn;

    @FindBy(css = "input[name='login']")
    public WebElement Email;

    @FindBy(css = "input[name='password']")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(css = "p[class='alert alert-danger']")
    public WebElement errorMessage;




    public void loginCRM(String Email, String password){

        LoginPage loginPage=new LoginPage();


        loginPage.Email.sendKeys(Email);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();



    }
}
