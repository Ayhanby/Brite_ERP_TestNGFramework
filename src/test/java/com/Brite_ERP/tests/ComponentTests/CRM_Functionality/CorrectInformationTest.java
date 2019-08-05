package com.Brite_ERP.tests.ComponentTests.CRM_Functionality;

import com.Brite_ERP.utilities.BrowserUtils;
import com.Brite_ERP.utilities.ConfigurationReader;
import com.Brite_ERP.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CorrectInformationTest extends TestBase {


    @Test
    public void ExpectedValueTest(){

        extentLogger =report.createTest("Expected Revenue Value Test ");

        extentLogger.info("Navigating to Signin page");
        pages.login().SignIn.click();

        extentLogger.info("Logging in with valid user credentials");
        pages.login().loginCRM(ConfigurationReader.getProperty("CRMusername"),ConfigurationReader.getProperty("CRMpassword"));
        BrowserUtils.wait(3);

        extentLogger.info("Navigating to CRM module");
        pages.homePage().CRM.click();
        BrowserUtils.wait(2);

        extentLogger.info("Clicking Pivot board");
        List<WebElement> grid=pages.homePage().Grids;
        WebElement Pivot=grid.get(17);
        Pivot.click();
        BrowserUtils.wait(3);

        extentLogger.info("Clicking Total option");
        pages.homePage().totalNew.click();

        extentLogger.info("Selecting Opportunity option");
        pages.homePage().Opportunity.click();
        BrowserUtils.wait(1);

        extentLogger.info("Clicking List board");
        String expectedRevenueInPivot=pages.homePage().expectedRevenue2Pivot.getText();
        WebElement List=grid.get(11);
        List.click();
        BrowserUtils.wait(3);

        extentLogger.info("Verifying expected revenue value");
        String expectedRevenueInList=pages.homePage().getExpectedRevenue2List.getText();
        Assert.assertEquals(expectedRevenueInPivot,expectedRevenueInList);

        extentLogger.pass("Expected revenue value test is passed");






    }


    @Test
    public void expectedRevenueSumTest(){

        extentLogger=report.createTest("Expected Revenue Value Sum Test");

        extentLogger.info("Nevigating to Signin page");
        pages.login().SignIn.click();

        extentLogger.info("Loggin in with valid user credentials");
        pages.login().loginCRM(ConfigurationReader.getProperty("CRMusername"),ConfigurationReader.getProperty("CRMpassword"));
        BrowserUtils.wait(3);

        extentLogger.info("Navigating to CRM module");
        pages.homePage().CRM.click();
        BrowserUtils.wait(2);

        extentLogger.info("Clicking Pivot board");
        List<WebElement> grid=pages.homePage().Grids;
        WebElement Pivot=grid.get(17);
        Pivot.click();
        BrowserUtils.wait(3);

        extentLogger.info("Clicking Total option");
        pages.homePage().totalNew.click();

        extentLogger.info("Selecting Opportunity option");
        pages.homePage().Opportunity.click();
        BrowserUtils.wait(1);

        String totalER=pages.homePage().totalRevenue.getText();
        String newTotalER=totalER.substring(0,2)+totalER.substring(3);

        String expectedROne=pages.homePage().expectedRevenue1Pivot.getText();
        String expectedRTwo=pages.homePage().expectedRevenue2Pivot.getText();
        String expectedRThree=pages.homePage().expectedRevenue3Pivot.getText();
        String newExpectedThree=expectedRThree.substring(0,2)+expectedRThree.substring(3);

        Double  totalExpectedRevenue=Double.parseDouble(newTotalER);
        Double  erOne=Double.parseDouble(expectedROne);
        Double  erTwo=Double.parseDouble(expectedRTwo);
        Double  erThree=Double.parseDouble(newExpectedThree);

        Double sum=erOne+erTwo+erThree;

        extentLogger.info("Verifying expected revenue value sum");
        Assert.assertEquals(totalExpectedRevenue,sum);

        extentLogger.pass("Expected revenue value sum test is passed");




    }
}
