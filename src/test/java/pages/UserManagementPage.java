package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class UserManagementPage extends BasePage {
    //======LOCATORS=======//
    By utilsBlock = AppiumBy.accessibilityId("Tiện ích");

    public UserManagementPage(AndroidDriver driver) {
        super(driver);
    }
    private boolean isUserPageDisplayed(){
        return waitForElementVisible(utilsBlock).isDisplayed();
    }
    public void verifyUserPageDisplayed(){
        scrollToUtilsBlock();
        Assert.assertTrue(isUserPageDisplayed(),"User Management page is not displayed");
    }
    private void scrollToUtilsBlock(){
        scrollDownFullScreen();
    }



}
