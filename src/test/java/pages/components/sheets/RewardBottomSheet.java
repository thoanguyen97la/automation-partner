package pages.components.sheets;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RewardBottomSheet extends BasePage {
    //======LOCATORS=========//
    By rewardSheetTitle = AppiumBy.accessibilityId("Tiền thưởng");
    By closeBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public RewardBottomSheet(AndroidDriver driver) {
        super(driver);
    }
    public void verifyRewardBottomSheetDisplayed(){
        Assert.assertTrue(isElementDisplayed(rewardSheetTitle));
    }
    public void closeBottomSheet(){
        clickElement(closeBtn);
    }
}
