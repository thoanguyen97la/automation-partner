package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By phoneInputText = By.xpath("//android.widget.EditText");
    By PasswordInputText =  By.xpath("//android.widget.EditText");
    By confirmBtn =  AppiumBy.accessibilityId("Xác nhận");
    By ContinueBtn =  AppiumBy.accessibilityId("Tiếp tục");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    public void enterPhone(String phone) {
        sendKeys( phoneInputText, phone);
    }
    public void enterPassword(String password) {
        sendKeys(PasswordInputText, password);
    }
    public void clickContinue() {
        clickElement(ContinueBtn);
    }
    public void clickConfirm() {
        clickElement(confirmBtn);
    }

}
