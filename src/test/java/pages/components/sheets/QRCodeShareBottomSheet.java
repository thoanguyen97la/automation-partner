package pages.components.sheets;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class QRCodeShareBottomSheet extends BasePage {
    //=====LOCATORS=======//
    By QRImg = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");
    By saveToDeviceBtn = AppiumBy.accessibilityId("Tải hình");
    By shareBtn = AppiumBy.accessibilityId("Chia sẻ mã QR");
    By closeBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    public QRCodeShareBottomSheet(AndroidDriver driver) {
        super(driver);
    }
    public void verifyQRCodeShareBottomSheetDisplayed(){
        Assert.assertTrue(isElementDisplayed(QRImg),"QR Code Share Bottom Sheet is not displayed");
    }
    public void verifyAllButtonsDisplayed(){
        Assert.assertTrue(isElementDisplayed(saveToDeviceBtn),"Save to Device button is not displayed");
        Assert.assertTrue(isElementDisplayed(shareBtn),"Share button is not displayed");
        Assert.assertTrue(isElementDisplayed(closeBtn),"Close button is not displayed");
    }


}
