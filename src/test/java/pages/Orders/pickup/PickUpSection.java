package pages.Orders.pickup;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PickUpSection extends BasePage {
    //=====LOCATORS=======//
    By inTransitTab = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Đang vận chuyển\")");

    public PickUpSection(AndroidDriver driver) {
        super(driver);
    }
    public PickupInTransitTab openInTransitTab(){
        clickElement(inTransitTab);
        return new PickupInTransitTab(driver);
    }
    private boolean isPickUpInTransitTabSelected(){
        return isElementSelected(inTransitTab);
    }
    public void verifyPickUpInTransitTabDisplayed(){
        Assert.assertTrue(isPickUpInTransitTabSelected(),"PickUp In Transit tab is not selected");
    }

}
