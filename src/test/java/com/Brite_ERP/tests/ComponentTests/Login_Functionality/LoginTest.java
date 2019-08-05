package com.Brite_ERP.tests.ComponentTests.Login_Functionality;

import com.Brite_ERP.utilities.BrowserUtils;
import com.Brite_ERP.utilities.ConfigurationReader;
import com.Brite_ERP.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {

    @Test
    public void loginTest1() {
        extentLogger = report.createTest("Login as events CRM manager");

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

        List<WebElement> mydashboards=pages.dashboardPage().pageSubTitles;
        WebElement mydashboard=mydashboards.get(87);

        Assert.assertEquals(mydashboard.getText(), "My Dashboard");
        extentLogger.pass("Verified page name: " + mydashboard.getText());
    }

    @Test(description = "Login with invalid credentials and verify warning message")

    public void negativeLoginTest1() {

        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrongusername username and wrongpassword password");

        pages.login().SignIn.click();
        driver.manage().window().fullscreen();

        pages.loginPage.loginCRM("wrongusername", "wrongpassword");
        Assert.assertEquals(pages.login().errorMessage.getText(), "Wrong login/password");
        extentLogger.pass("Verified that Message present: " + pages.login().errorMessage.getText());
    }



    @Test
    @Parameters({ "username", "password" }) // get data from data testng.xml
    public void loginWithParameters(@Optional String username, @Optional String password) {
        extentLogger = report.createTest("Login as events CRM manager");
        //@Optional tak will make testng parameter optional
        //but, if there is no value - you will null
        //thus, let's make sure parameters are not null
        //if so, let's pull credentials from properties
        if(username == null){
            username = ConfigurationReader.getProperty("CRMusername");
            password = ConfigurationReader.getProperty("CRMpassword");
        }
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session

        pages.login().SignIn.click();
        driver.manage().window().fullscreen();
        pages.loginPage.loginCRM(username, password);
        pages.dashboardPage().Dashboards.click();
        BrowserUtils.wait(2);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        List<WebElement> mydashboards=pages.dashboardPage().pageSubTitles;
        WebElement mydashboard=mydashboards.get(87);

        Assert.assertEquals(mydashboard.getText(), "My Dashboard");
        extentLogger.pass("Verified page name: " + mydashboard.getText());
    }

    @Test(dataProvider = "credentials_info") // get data from data provider
    public void loginWithDataProvider(String username, String password) {
        extentLogger = report.createTest("Login as "+username);
        extentLogger.info(username+"  ::  "+password);
        //we are instantiating page class inside a tests class,
        //because for second test, if we run all tests in a row, driver will have null session
        pages.login().SignIn.click();
        driver.manage().window().fullscreen();
        pages.loginPage.loginCRM(username, password);
        pages.dashboardPage().Dashboards.click();
        BrowserUtils.wait(2);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        List<WebElement> mydashboards=pages.dashboardPage().pageSubTitles;
        WebElement mydashboard=mydashboards.get(87);

        Assert.assertEquals(mydashboard.getText(), "My Dashboard");
        extentLogger.pass("Verified page name: " + mydashboard.getText());
    }
    //Data provider allows to do DDT
    //same test - different data set
    //you can get information from excel file and return it as 2d array
    //the pass it into data provider, and make tests use it
    @DataProvider(name = "credentials_info")
    public static Object[][] credentials() {
        return new Object[][] { { "eventscrmmanager68@info.com", "eventscrmmanager" },
                { "eventscrmmanager68@info.com", "eventscrmmanager" }};

    }


    @Test(description = "Login with invalid credentials and verify warning message")
    public void negativeLoginTest2() {
        extentLogger = report.createTest("Negative login test");
        extentLogger.info("Login with wrong username  and wrong password");
        pages.login().SignIn.click();
        driver.manage().window().fullscreen();
        pages.loginPage.loginCRM("wrongusername", "wrongpassword");
        softAssert.assertEquals(pages.login().errorMessage.getText(), "Invalid user name or password.");
        extentLogger.pass("Verified that Message present: " + pages.login().errorMessage.getText());
    }

}
