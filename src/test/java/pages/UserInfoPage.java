package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class UserInfoPage extends BasePage {
    //=======LOCATORS========//
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    By pageTitle = AppiumBy.accessibilityId("Thông tin cá nhân");
    public UserInfoPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickBack(){
        clickElement(backBtn);
    }
    private boolean isUserInfoPageDisplayed(){
        try {
            return waitForElementVisible(pageTitle).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
    public void verifyUserInfoPageDisplayed(){
        Assert.assertTrue(isUserInfoPageDisplayed(),"User Info page is not displayed");
    }
}
