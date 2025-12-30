package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class NotificationPage extends BasePage {
    //=====LOCATORS======//
    By pageTitle = AppiumBy.accessibilityId("Thông báo");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public NotificationPage(AndroidDriver driver) {
        super(driver);
    }
    public boolean isNotificationPageDisplayed(){
        try {
            return findElement(pageTitle).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
    public HomePage clickBack(){
        clickElement(backBtn);
        return new HomePage(driver);
    }


}
