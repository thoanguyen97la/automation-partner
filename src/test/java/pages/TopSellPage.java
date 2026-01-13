package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TopSellPage extends BasePage {
    //======LOCATORS=========//
    By topSaleTitle = AppiumBy.accessibilityId("Sản phẩm bán chạy tại điểm");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");

    public TopSellPage(AndroidDriver driver) {
        super(driver);
    }
    public void verifyTopSalePageDisplayed(){
        Assert.assertTrue(isElementDisplayed(topSaleTitle));
    }
    public HomePage clickBack(){
        clickElement(backBtn);
        return new HomePage(driver);
    }
}
