package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {
    //======LOCATORS=======//
    By utilsBlock = AppiumBy.accessibilityId("Tiện ích");

    public UserPage(WebDriver driver) {
        super(driver);
    }
    public boolean isUserPageDisplayed(){
        return findElement(utilsBlock).isDisplayed();
    }
    public void scrollToUtilsBlock(){
        scrollDownFullScreen();
    }


}
