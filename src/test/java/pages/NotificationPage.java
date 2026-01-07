package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class NotificationPage extends BasePage {
    //=====LOCATORS======//
    By pageTitle = AppiumBy.accessibilityId("Thông báo");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public NotificationPage(AndroidDriver driver) {
        super(driver);
    }
    private boolean isNotificationPageDisplayed(){
        try {
            return waitForElementVisible(pageTitle).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
    public void verifyNotificationPageDisplayed(){
        Assert.assertTrue(isNotificationPageDisplayed(),"Notification page is not displayed");
    }
    public HomePage clickBack(){
        clickElement(backBtn);
        return new HomePage(driver);
    }


}
