package tests.verifiers;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SystemShareSheet extends BasePage {
    //======LOCATORS=========//
    By systemShareSheet = AppiumBy.xpath("//android.widget.FrameLayout[@package='android']");

    public SystemShareSheet(AndroidDriver driver) {
        super(driver);
    }
    public void verifySystemShareSheetDisplayed() {
        Assert.assertTrue(isElementDisplayed(systemShareSheet),"System share sheet is not displayed");
    }
    public void closeSystemShareSheet() {
        driver.navigate().back();
    }
}
