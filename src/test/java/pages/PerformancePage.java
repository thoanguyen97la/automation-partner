package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PerformancePage extends BasePage {
    //======LOCATORS=========//
    By performanceHeader = AppiumBy.accessibilityId("Hiệu quả hoạt động");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");

    public PerformancePage(AndroidDriver driver) {
        super(driver);
    }
    public void verifyPerformancePageDisplayed(){
        Assert.assertTrue(isElementDisplayed(performanceHeader),"Performance page is not displayed");
    }
    public void clickBackToHome(){
        clickElement(backBtn);
    }
}
