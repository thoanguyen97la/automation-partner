package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    //======LOCATOR==========//
    By searchBox = AppiumBy.xpath("//android.widget.EditText");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public boolean isSearchPageDisplayed() {
        return findElement(searchBox).isDisplayed();
    }
    public String SearchBoxFocusedStatus(){
        return findElement(searchBox).getAttribute("focused");
    }

}
