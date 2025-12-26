package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {
//====LOCATORS=======//
    By pickupPointTab = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Đơn mới\")");
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOrderPageDisplayed(){
        return findElement(pickupPointTab).isDisplayed();
    }
}
