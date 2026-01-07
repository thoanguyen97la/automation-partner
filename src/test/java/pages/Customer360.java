package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Customer360 extends BasePage {
    //=====LOCATORS=======//
    By pageTitle = AppiumBy.accessibilityId("Khách 360");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public Customer360(AndroidDriver driver) {
        super(driver);
    }
    private boolean isCustomer360Displayed(){
        return isElementDisplayed(pageTitle);
    }
    public void verifyCustomer360PageDisplayed(){
        Assert.assertTrue(isCustomer360Displayed());
    }
    public void clickBack(){
        clickElement(backBtn);
    }
}
