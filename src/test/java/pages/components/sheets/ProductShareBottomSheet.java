package pages.components.sheets;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import tests.verifiers.SystemShareSheet;

public class ProductShareBottomSheet extends BasePage {
    //======LOCATORS=========//
    By productShareBottomSheet = AppiumBy.accessibilityId("Mã QR sản phẩm");
    By zaloShareBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Chia sẻ qua Zalo\")");
    By qrShareBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Chia sẻ mã QR sản phẩm\")");
    By copyBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Sao chép\")");
    By otherBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Khác\")");

    public ProductShareBottomSheet(AndroidDriver driver) {
        super(driver);
    }

    private boolean isProductShareBottomSheetDisplayed(){
        return waitForElementVisible(productShareBottomSheet).isDisplayed();
    }
    public void verifyProductShareBottomSheetDisplayed(){
        Assert.assertTrue(isProductShareBottomSheetDisplayed(),"Product Share Bottom Sheet is not displayed");
    }
    public void verifyAllShareButtonsDisplayed(){
        Assert.assertTrue(isZaloShareButtonDisplayed(),"Zalo Share button is not displayed");
        Assert.assertTrue(isQRShareButtonDisplayed(),"QR Share button is not displayed");
        scrollShareButtonsList();
        Assert.assertTrue(isCopyButtonDisplayed(),"Copy button is not displayed");
        Assert.assertTrue(isOtherButtonDisplayed(),"Other button is not displayed");
    }
    private boolean isZaloShareButtonDisplayed(){
        return waitForElementVisible(zaloShareBtn).isDisplayed();
    }
    private boolean isQRShareButtonDisplayed(){
        return waitForElementVisible(qrShareBtn).isDisplayed();
    }
    private boolean isCopyButtonDisplayed(){
        return waitForElementVisible(copyBtn).isDisplayed();
    }
    private boolean isOtherButtonDisplayed(){
        return waitForElementVisible(otherBtn).isDisplayed();
    }
    private void scrollShareButtonsList(){
        swipeElement(qrShareBtn,"left",1.0);
    }
    public void closeBottomSheet(){
        closeByTapOutside();
        Assert.assertTrue(waitForElementInvisible(productShareBottomSheet));
    }
    public void clickZaloShareButton(){
        clickElement(zaloShareBtn);
    }
    public QRCodeShareBottomSheet clickQRShareButton(){
        clickElement(qrShareBtn);
        return new QRCodeShareBottomSheet(driver);
    }
    public void clickCopyLinkButton(){
        scrollShareButtonsList();
        clickElement(copyBtn);
    }
    public void verifyToastMessageDisplayed(String expectedMessage){
        Assert.assertTrue(isToastMessageDisplayed(expectedMessage),"Toast message is not displayed or incorrect");
    }
    public SystemShareSheet clickOtherShareButton(){
        scrollShareButtonsList();
        clickElement(otherBtn);
        return new SystemShareSheet(driver);
    }
}
