package com.Brite_ERP.tests.ComponentTests.Purchase_Functionality;//package com.Brite_ERP.tests.Purchase_Functionality;
//
//import com.Brite_ERP.utilities.ConfigurationReader;
//import com.Brite_ERP.utilities.Driver;
//import com.Brite_ERP.utilities.TestBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class CreateNewPurchaseOrders extends TestBase {
//
//    String month="November 2019";
//    String date="11";
//
//    @Test
//    public void CreatingNewPurchaseOrdersTest()throws InterruptedException{
//
//        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("urlBrite"));
//        Driver.getDriver().manage().window().fullscreen();
//        WebElement email=Driver.getDriver().findElement(By.id("login"));
//        email.sendKeys(ConfigurationReader.getProperty("usernameBrite"));
//        WebElement  password=Driver.getDriver().findElement(By.id("password"));
//        password.sendKeys(ConfigurationReader.getProperty("passwordBrite")+ Keys.ENTER);
//
//        Thread.sleep(3000);
//
//        String expectedHomePageMessage="Congratulations, your inbox is empty";
//        String actualHomePageMessage=Driver.getDriver().findElement(By.xpath("//div[.='Congratulations, your inbox is empty']")).getText();
//
//        Assert.assertEquals(actualHomePageMessage,expectedHomePageMessage);
//
//
//
//        WebElement purchase=Driver.getDriver().findElement(By.linkText("Purchases"));
//        purchase.click();
//
//        WebElement purchaseOrder=Driver.getDriver().findElement(By.linkText("Purchase Orders"));
//
//        Actions actions=new Actions(Driver.getDriver());
//        actions.moveToElement(purchaseOrder).click().perform();
//        Thread.sleep(3000);
//
//
//        String actualHeader=Driver.getDriver().findElement(By.xpath("//li[.='Purchase Orders']")).getText();
//        String expectedHeader="Purchase Orders";
//
//        Assert.assertEquals(actualHeader,expectedHeader);
//
//        WebElement create=Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_list_button_add']"));
//        create.click();
//        Thread.sleep(2000);
//
//        WebElement di=Driver.getDriver().findElement(By.xpath("//a[.='Deliveries & Invoices']"));
//        di.click();
//
//        Thread.sleep(2000);
//
//
//
//
//        WebElement vendor=Driver.getDriver().findElement(By.xpath("//label[.='Vendor']"));
//        vendor.click();
//
//        WebElement searchMore=Driver.getDriver().findElement(By.xpath("//a[.='Search More...']"));
//        searchMore.click();
//        Thread.sleep(2000);
//
//
//       WebElement ali=Driver.getDriver().findElement(By.xpath("//td[.='Ali']"));
//        ali.click();
//
//
//        WebElement sDate=Driver.getDriver().findElement(By.xpath("//label[.='Scheduled Date']"));
//        sDate.click();
//
//
//
//        WebElement currentDateStr=Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]"));
//
//
//        while(true){
//
//            if(currentDateStr.getText().equals(month)){
//                break;
//
//            } else{
//
//                Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]/span")).click();
//                Thread.sleep(100);
//            }
//
//
//        }
//
//
//
//
//        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[2]/table/tbody/tr/td[1]/a/span")).click();
//
//        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[3]/div/div[1]/table/tbody/tr[2]/td[3]/span")).click();
//
//        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[3]/div/div[3]/table/tbody/tr[2]/td[2]")).click();
//
//        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/ul/li[2]/table/tbody/tr/td[2]/a/span")).click();
//
//
//        WebElement save=Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_save']"));
//
//
//        save.click();
//
//        Thread.sleep(3000);
//
//        WebElement editButton=Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary btn-sm o_form_button_edit']"));
//
//        Assert.assertTrue(editButton.isDisplayed());
//
//    }
//
//
//}
