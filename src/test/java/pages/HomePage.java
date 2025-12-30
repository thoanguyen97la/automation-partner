package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.Orders.OrderPage;
import pages.Orders.pickup.PickupInTransitTab;

public class HomePage extends BasePage {
    //======LOCATORS======//
    By todayReward = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Thưởng hôm nay')]");
    By todayDeliveryOrder = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Đơn giao hôm nay')]");
    By todayCustomer = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Số khách hôm nay')]");
    By todayTrips = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Chuyến xe hôm nay')]");
    By stationPerformance = AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Hiệu quả hoạt động điểm nhận hàng')]");
    By partnerAvatar = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)");
    By shareStationBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    By notificationBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(11)");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed(){
        return findElement(todayReward).isDisplayed();
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
    public void  clickTodayTrips(){
        clickElement(todayTrips);
    }
    public void  clickStationPerformance(){
        clickElement(stationPerformance);
    }
    public void swipeLeftTodayReward(double percent){
        swipeElement(todayReward,"left",percent);
    }
}
