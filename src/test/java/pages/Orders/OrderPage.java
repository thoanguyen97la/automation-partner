package pages.Orders;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Orders.pickup.PickUpSection;
import pages.Orders.trip.TripSection;

public class OrderPage extends BasePage {
//====LOCATORS=======//
    By pickupSection = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Đơn mới\")");
    By tripSection = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Chuyến xe\")");
    public OrderPage(AndroidDriver driver) {
        super(driver);
    }
    private boolean isOrderPageDisplayed(){
        return waitForElementVisible(pickupSection).isDisplayed();
    }
    public void verifyOrderPageDisplayed(){
        Assert.assertTrue(isOrderPageDisplayed(),"Order page is not displayed");
    }
    public PickUpSection pickUpSection(){
        return new PickUpSection(driver);
    }
    public boolean isPickUpSectionSelected(){
        return isElementSelected(pickupSection);
    }
    public TripSection tripSection(){
        return new TripSection(driver);
    }
    private boolean isTripSectionSelected(){
        return isElementSelected(tripSection);
    }
    public void verifyTripSectionPageDisplayed(){
        Assert.assertTrue(isTripSectionSelected(),"Trip section is not selected");
    }

}
