package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import tests.verifiers.AppStateVerifiers;
public class HomePageTest extends BaseTest {


    @Test
    public void Partner_06_test_show_User_Management_page_when_click_station_avatar(){
        HomePage homePage = new HomePage(driver);
        UserInfoPage userInfoPage = homePage.clickPartnerAvatar();
        userInfoPage.verifyUserInfoPageDisplayed();
        userInfoPage.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_07_test_click_share_station_button(){
        ShareStationPosterPage posterPage = new HomePage(driver).clickShareStation();
        posterPage.clickShareZalo();
        AppStateVerifiers verifier = new AppStateVerifiers(driver);
        verifier.verifyZaloAppOpened();
    }
    @Test
    public void Partner_08_test_show_Notification_page_when_click_notification_button(){
        NotificationPage notiPage = new HomePage(driver).clickNotification();
        notiPage.verifyNotificationPageDisplayed();
        HomePage homePage = notiPage.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_09_test_show_RewardStatistics_page_when_click_Today_reward_block() {
        HomePage homePage = new HomePage(driver);
        RewardStatisticsPage rewardPage = homePage.clickTodayReward();
        rewardPage.verifyRewardStatisticsPageDisplayed();
        rewardPage.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_10_test_show_PickUpInTransitTab_when_click_TodayDeliverOrder(){
        new HomePage(driver).clickTodayDeliveryOrder()
                .pickUpSection()
                .verifyPickUpInTransitTabDisplayed();
    }
    @Test
    public void Partner_11_test_show_Customer360_when_click_today_customer(){
        HomePage homePage = new HomePage(driver);
        Customer360 customer360 = homePage.clickTodayCustomer();
        customer360.verifyCustomer360PageDisplayed();
        customer360.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_12_test_show_TripsSection_when_click_TodayTrips(){
        HomePage homePage = new HomePage(driver);
        homePage.revealTodayTrip();
        homePage.clickTodayTrips()
                .verifyTripSectionPageDisplayed();
    }
    @Test
    public void Partner_13_test_show_station_performance_page_when_click_station_performance_block(){
        HomePage homePage = new HomePage(driver);
        homePage.revealStationPerformance();
        PerformancePage performancePage = homePage.clickStationPerformance();
        performancePage.verifyPerformancePageDisplayed();
        performancePage.clickBackToHome();
        homePage.verifyHomePageDisplayed();
    }
}
