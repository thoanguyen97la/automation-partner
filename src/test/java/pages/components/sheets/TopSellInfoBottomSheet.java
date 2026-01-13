package pages.components.sheets;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TopSellInfoBottomSheet extends BasePage {
    //======LOCATORS=========//
    By title = AppiumBy.accessibilityId("Sản phẩm bán chạy tại điểm");
    By closeBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    By description = AppiumBy.xpath("//android.view.View[contains(@content-desc,\"Đây là các sản phẩm được bán nhiều tại điểm trong 28 ngày gần đây\")]");


    public TopSellInfoBottomSheet(AndroidDriver driver) {
        super(driver);
    }
    public void verifyTopSaleInfoBottomSheetDisplayed(){
        Assert.assertTrue(isElementDisplayed(title),"Top Sale Info Bottom Sheet is not displayed");
        Assert.assertTrue(isElementDisplayed(description),"Description in Top Sale Info Bottom Sheet is not displayed");
    }
    public void closeBottomSheet(){
        clickElement(closeBtn);
    }
}
