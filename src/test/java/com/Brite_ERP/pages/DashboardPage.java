package com.Brite_ERP.pages;

import com.Brite_ERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Dashboards")
    public WebElement Dashboards;

    @FindBy(css = "span[class='oe_menu_text']")
    public List<WebElement> pageSubTitles;


}
