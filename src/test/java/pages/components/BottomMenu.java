package pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.OrderPage;
import pages.SearchPage;
import pages.UserPage;

public class BottomMenu extends BasePage {
    //====LOCATORS=======//
    By userTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Cá nhân')]");
    By homeTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Trang chủ')]");
    By searchTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Tìm kiếm')]");
    By orderTab = By.xpath("//android.widget.ImageView[contains(@content-desc,'Đơn hàng')]");

    public BottomMenu(WebDriver driver) {
        super(driver);
    }
    public UserPage clickUserTab() {
        clickElement(userTab);
        return new UserPage(driver);
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
