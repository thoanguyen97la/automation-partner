package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.UserLoginData;

public class LoginTest extends BaseTest {
    @Test
    public void Partner_00_test_login_station_account(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPhone(UserLoginData.STATION_PHONE);
        loginPage.clickContinue();
        loginPage.enterPassword(UserLoginData.STATION_PASSWORD);
        loginPage.clickConfirm();
    }
}


