package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Orders.OrderPage;
import pages.components.sheets.ProductShareBottomSheet;


public class HomePage extends BasePage {
    //======LOCATORS======//
    By todayReward = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Thưởng hôm nay')]");
    By todayDeliveryOrder = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Đơn giao hôm nay')]");
    By todayCustomer = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Số khách hôm nay')]");
    By todayTrips = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Chuyến xe hôm nay')]");
    By stationPerformance = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Hiệu quả hoạt động điểm nhận hàng')]");
    By partnerAvatar = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");
    By shareStationBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    By notificationBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(9)");
    By topSaleWidgetHeader = AppiumBy.accessibilityId("Sản phẩm bán chạy tại điểm");
    By searchIcon = AppiumBy.xpath("//android.view.View[@content-desc=\"CHIA SẺ KIẾM TIỀN NGAY NHÉ\"]/following-sibling::android.widget.ImageView[1]");
    By productShareBtn = AppiumBy.xpath("//android.view.View[contains(@content-desc,\"Bán gần đây\")]/android.widget.ImageView[3]");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    private boolean isHomePageDisplayed(){
        return isElementDisplayed(topSaleWidgetHeader);
    }
    public void verifyHomePageDisplayed(){
        Assert.assertTrue(isHomePageDisplayed(),"Home page is not displayed");
    }
    public UserInfoPage clickPartnerAvatar(){
        clickElement(partnerAvatar);
        return new UserInfoPage(driver);
    }
    public ShareStationPosterPage clickShareStation(){
        clickElement(shareStationBtn);
        return new ShareStationPosterPage(driver);
    }
    public NotificationPage clickNotification(){
        clickElement(notificationBtn);
        return new NotificationPage(driver);
    }
    public RewardStatisticsPage clickTodayReward(){
        clickElement(todayReward);
        return new RewardStatisticsPage(driver);
    }
    public OrderPage clickTodayDeliveryOrder(){
        clickElement(todayDeliveryOrder);
        return new OrderPage(driver);

    }
    public Customer360  clickTodayCustomer(){
        clickElement(todayCustomer);
        return new Customer360(driver);

    }
    public OrderPage  clickTodayTrips(){
        swipeElement(todayReward,"left",0.8);
        clickElement(todayTrips);
        return new OrderPage(driver);
    }
    public PerformancePage  clickStationPerformance(){
        swipeElement(todayReward,"left",0.8);
        clickElement(stationPerformance);
        return new PerformancePage(driver);
    }
    public void clickSearchIcon(){
        scrollUntilElementVisible(searchIcon);
        clickElement(searchIcon);
    }

    public ProductShareBottomSheet clickShareButtonOnProductCard(){
        scrollUntilElementVisible(productShareBtn);
        clickElement(productShareBtn);
        return new ProductShareBottomSheet(driver);
    }

}
