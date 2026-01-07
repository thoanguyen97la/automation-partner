package pages.components;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import pages.Orders.OrderPage;
import pages.SearchPage;
import pages.UserManagementPage;

public class BottomMenu extends BasePage {
    //====LOCATORS=======//
    By userTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Cá nhân')]");
    By homeTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Trang chủ')]");
    By searchTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Tìm kiếm')]");
    By orderTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Đơn hàng')]");

    public BottomMenu(AndroidDriver driver) {
        super(driver);
    }
    private boolean isHomeTabDisplayed(){
        return waitForElementVisible(homeTab).isDisplayed();
    }
    private boolean isOrderTabDisplayed(){
        return waitForElementVisible(orderTab).isDisplayed();
    }
    private boolean isSearchTabDisplayed(){
        return waitForElementVisible(searchTab).isDisplayed();
    }
    private boolean isUserTabDisplayed(){
        return waitForElementVisible(userTab).isDisplayed();
    }
    public void verifyBottomMenuDisplayed(){
        Assert.assertTrue(isHomeTabDisplayed());
        Assert.assertTrue(isOrderTabDisplayed());
        Assert.assertTrue(isUserTabDisplayed());
        Assert.assertTrue(isSearchTabDisplayed());
    }
    public UserManagementPage clickUserTab() {
        clickElement(userTab);
        return new UserManagementPage(driver);
    }
    public SearchPage clickSearchTab() {
        clickElement(searchTab);
        return new SearchPage(driver);
    }
    public HomePage clickHomeTab() {
        clickElement(homeTab);
        return new HomePage(driver);
    }
    public OrderPage clickOrderTab() {
        clickElement(orderTab);
        return new OrderPage(driver);
    }
    private String getOrderTabSelectedStatus(){
        return waitForElementVisible(orderTab).getAttribute("selected");
    }
    public void verifyOrderTabSelected(){
        Assert.assertEquals(getOrderTabSelectedStatus(),"true");
    }
    public String getUserTabSelectedStatus(){
        return waitForElementVisible(userTab).getAttribute("selected");
    }
    public void verifyUserTabSelected(){
        Assert.assertEquals(getUserTabSelectedStatus(),"true");
    }
}
