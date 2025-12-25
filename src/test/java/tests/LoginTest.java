package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPhone("0775987828");
        loginPage.clickContinue();
        loginPage.enterPassword("123123123");
        loginPage.clickConfirm();
    }
}


