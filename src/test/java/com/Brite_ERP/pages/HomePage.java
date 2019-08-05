package com.Brite_ERP.pages;

import com.Brite_ERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.XMLFormatter;

public class HomePage {

    public HomePage(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(linkText = "CRM")
    public WebElement CRM;

    @FindBy(css = "button[type='button']")
    public List<WebElement> Grids;

    @FindBy(css = "td[class='o_pivot_header_cell_closed']")
    public WebElement totalNew;

    @FindBy(xpath = "//a[.='Opportunity']")
    public WebElement Opportunity;

    @FindBy(css = "table[class='table-hover table-condensed table-bordered']")
    public List<WebElement> PivotTable;


    @FindBy(xpath = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[3]/td[2]")
    public WebElement expectedRevenue1Pivot;

    @FindBy(xpath = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[4]/td[2]")
    public WebElement expectedRevenue2Pivot;

    @FindBy(xpath = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[5]/td[2]")
    public WebElement expectedRevenue3Pivot;

    @FindBy(xpath = "//table[@class='table-hover table-condensed table-bordered']/tbody/tr[1]/td[2]")
    public WebElement totalRevenue;



    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr[2]/td[9]")
    public WebElement getExpectedRevenue2List;

    @FindBy(xpath = "//li[.='Pipeline']")
    public WebElement Pipeline;





}
