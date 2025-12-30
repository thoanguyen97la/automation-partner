package pages.components;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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
    public boolean isHomeTabDisplayed(){
        return findElement(homeTab).isDisplayed();
    }
    public boolean isOrderTabDisplayed(){
        return findElement(orderTab).isDisplayed();
    }
    public boolean isSearchTabDisplayed(){
        return findElement(searchTab).isDisplayed();
    }
    public boolean isUserTabDisplayed(){
        return findElement(userTab).isDisplayed();
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
    public String getOrderTabSelectedStatus(){
        return findElement(orderTab).getAttribute("selected");
    }
    public String getUserTabSelectedStatus(){
        return findElement(userTab).getAttribute("selected");
    }
}
