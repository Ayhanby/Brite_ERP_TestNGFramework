package com.Brite_ERP.tests.SmokeTest;

import com.Brite_ERP.utilities.ApplicationConstants;
import com.Brite_ERP.utilities.BrowserUtils;
import com.Brite_ERP.utilities.ConfigurationReader;
import com.Brite_ERP.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmokeTest extends TestBase {

    @Test(groups = {"smoke"})
    public void verifyDashboards() {
        extentLogger = report.createTest("Verify Dashboards");

        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        String username = ConfigurationReader.getProperty("CRMusername");
        String password = ConfigurationReader.getProperty("CRMpassword");

        pages.login().SignIn.click();
        driver.manage().window().fullscreen();
        pages.loginPage.loginCRM(username, password);

        pages.dashboardPage().Dashboards.click();
        BrowserUtils.wait(2);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully

        List<WebElement> mydashboards = pages.dashboardPage().pageSubTitles;
        WebElement mydashboard = mydashboards.get(87);

        Assert.assertEquals(mydashboard.getText(), "My Dashboard");
        extentLogger.pass("Verified page name: " + mydashboard.getText());


    }

    @Test(groups = {"smoke"})
    public void verifyFleet() {
        extentLogger = report.createTest("Verify CRM module");

        String username = ConfigurationReader.getProperty("CRMusername");
        String password = ConfigurationReader.getProperty("CRMpassword");

        pages.login().SignIn.click();
        driver.manage().window().fullscreen();
        pages.loginPage.loginCRM(username, password);

        pages.homePage().CRM.click();


        Assert.assertEquals(pages.homePage().Pipeline.getText(), "Pipeline");
        extentLogger.pass("Verified that CRM page opens");



    }

}