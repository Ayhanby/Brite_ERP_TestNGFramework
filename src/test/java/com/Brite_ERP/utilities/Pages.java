package com.Brite_ERP.utilities;

import com.Brite_ERP.pages.DashboardPage;
import com.Brite_ERP.pages.HomePage;
import com.Brite_ERP.pages.LoginPage;

public class Pages {

    public LoginPage loginPage;
    public HomePage homePage;
    public DashboardPage dashboardPage;


    public HomePage homePage(){
        homePage=new HomePage();
        return homePage;
    }

    public LoginPage login(){

        if(loginPage==null){
            loginPage=new LoginPage();
        }

        return loginPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }


}
