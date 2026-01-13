package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.components.homewidgets.TopSellProductModel;

import java.util.List;

public class ProductDetailPage extends BasePage {
    //=======LOCATORS========//
    By textView = AppiumBy.xpath("//android.view.View");
    By productImg = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)");
    By backBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");

    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }
    public void verifyProductDetailPageDisplayed(){
        Assert.assertTrue(isElementDisplayed(productImg),"Product detail page is not displayed");
    }
    public HomePage clickBack(){
        clickElement(backBtn);
        return new HomePage(driver);
    }
    public void verifyProductNameMatches(String expectedName){
        boolean matches = false;
        List<WebElement> allTextViews = findAllElements(textView);
        for (WebElement textView : allTextViews) {
            String text = textView.getAttribute("content-desc");
            if (text != null && text.equals(expectedName)) {
                matches =true;
                break;
            }
        }
        Assert.assertTrue(matches, "Product name does not match!");

    }
}
