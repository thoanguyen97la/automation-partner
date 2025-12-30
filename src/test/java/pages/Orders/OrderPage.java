package pages.Orders;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.Orders.pickup.PickUpSection;

public class OrderPage extends BasePage {
//====LOCATORS=======//
    By pickupSection = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Đơn mới\")");
    public OrderPage(AndroidDriver driver) {
        super(driver);
    }
    public boolean isOrderPageDisplayed(){
        return findElement(pickupSection).isDisplayed();
    }
    public PickUpSection pickUpSection(){
        return new PickUpSection(driver);
    }
    public boolean isPickUpSectionSelected(){
        return isElementSelected(pickupSection);
    }

}
