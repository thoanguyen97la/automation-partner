package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.Orders.pickup.PickupInTransitTab;

public class HomePageTest extends BaseTest {
    @Test
    public void Partner_06_test_show_User_Management_page_when_click_station_avatar(){
        HomePage homePage = new HomePage(driver);
        UserInfoPage userInfoPage = homePage.clickPartnerAvatar();
        Assert.assertTrue(userInfoPage.isUserInfoPageDisplayed(),"UserInfo should be displayed");
        userInfoPage.clickBack();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
    }
    @Test
    public void Partner_07_test_click_share_station_button(){
        ShareStationPosterPage posterPage = new HomePage(driver).clickShareStation();
        posterPage.clickShareZalo();
        posterPage.waitForAppPackage("com.zing.zalo");
        String currentPackage = driver.getCurrentPackage();
        Assert.assertEquals(currentPackage,"com.zing.zalo","App package should be 'com.zing.zalo'");
    }
    @Test
    public void Partner_08_test_show_Notification_page_when_click_notification_button(){
        NotificationPage notiPage = new HomePage(driver).clickNotification();
        Assert.assertTrue(notiPage.isNotificationPageDisplayed(), "Notification page should be displayed");
        HomePage homePage = notiPage.clickBack();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
    }
    @Test
    public void Partner_09_test_show_RewardStatistics_page_when_click_Today_reward_block() {
        RewardStatisticsPage rewardPage = new HomePage(driver).clickTodayReward();
        Assert.assertTrue(rewardPage.isRewardStatisticsPageDisplayed(), "RewardStatistics page should be displayed");
        rewardPage.clickBack();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed");
    }
    @Test
    public void Partner_10_test_show_PickUpInTransitTab_when_click_TodayDeliverOrder(){
        boolean isDisplayed = new HomePage(driver).clickTodayDeliveryOrder()
                                                    .pickUpSection()
                                                    .isPickUpInTransitTabSelected();
        Assert.assertTrue(isDisplayed);
    }
    @Test
    public void Partner_11_test_show_Customer360_when_click_today_customer() throws InterruptedException {
        Customer360 customer360 = new HomePage(driver).clickTodayCustomer();
        Assert.assertTrue(customer360.isCustomer360Displayed());
        customer360.clickBack();
        Assert.assertTrue(new HomePage(driver).isHomePageDisplayed());
    }
}
