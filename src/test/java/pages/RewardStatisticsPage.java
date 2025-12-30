package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class RewardStatisticsPage extends BasePage {
    //======LOCATORS======//
    By pageTitle = AppiumBy.accessibilityId("Thống kê");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public RewardStatisticsPage(AndroidDriver driver) {
        super(driver);
    }
    public boolean isRewardStatisticsPageDisplayed(){
        try {
            return findElement(pageTitle).isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
    public void clickBack(){
        clickElement(backBtn);
    }
}
