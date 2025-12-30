package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShareStationPosterPage extends BasePage {
    //======LOCATORS=========//
    By zaloShareBtn = AppiumBy.accessibilityId("Chia sẻ qua Zalo");
    By copyBtn = AppiumBy.accessibilityId("Sao chép");
    public ShareStationPosterPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickShareZalo(){
        clickElement(zaloShareBtn);
    }
}
