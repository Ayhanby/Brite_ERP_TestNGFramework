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


        pages.login().SignIn.click();
        pages.login().loginCRM(ConfigurationReader.getProperty("CRMusername"),ConfigurationReader.getProperty("CRMpassword"));
        BrowserUtils.wait(3);
        pages.homePage().CRM.click();
        BrowserUtils.wait(2);
        List<WebElement> grid=pages.homePage().Grids;
        WebElement Pivot=grid.get(17);
        Pivot.click();
        BrowserUtils.wait(3);
        pages.homePage().totalNew.click();
        pages.homePage().Opportunity.click();
        BrowserUtils.wait(1);
        String expectedRevenueInPivot=pages.homePage().expectedRevenue2Pivot.getText();
        WebElement List=grid.get(11);
        List.click();
        BrowserUtils.wait(3);
        String expectedRevenueInList=pages.homePage().getExpectedRevenue2List.getText();
        Assert.assertEquals(expectedRevenueInPivot,expectedRevenueInList);






    }


    @Test
    public void expectedRevenueSumTest(){


        pages.login().SignIn.click();
        pages.login().loginCRM(ConfigurationReader.getProperty("CRMusername"),ConfigurationReader.getProperty("CRMpassword"));
        BrowserUtils.wait(3);
        pages.homePage().CRM.click();
        BrowserUtils.wait(2);
        List<WebElement> grid=pages.homePage().Grids;
        WebElement Pivot=grid.get(17);
        Pivot.click();
        BrowserUtils.wait(3);
        pages.homePage().totalNew.click();
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


        Assert.assertEquals(totalExpectedRevenue,sum);




    }
}
