package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

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
    public boolean isUserInfoPageDisplayed(){
        try {
            return findElement(pageTitle).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
