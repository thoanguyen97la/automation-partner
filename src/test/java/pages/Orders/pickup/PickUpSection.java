package pages.Orders.pickup;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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
    public boolean isPickUpInTransitTabSelected(){
        return isElementSelected(inTransitTab);
    }

}
