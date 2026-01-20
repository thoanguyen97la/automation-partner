package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import tests.verifiers.AppStateVerifiers;
public class HomePageTest extends BaseTest {


    @Test
    public void Partner_06_test_show_User_Management_page_when_click_station_avatar(){
        app.homePage().clickPartnerAvatar();
        app.userInfoPage().verifyUserInfoPageDisplayed();
        app.userInfoPage().clickBack();
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_07_test_click_share_station_button(){
        app.homePage().clickShareStation();
        app.shareStationPosterPage().clickShareZalo();
        app.appStateVerifiers().verifyZaloAppOpened();
    }
    @Test
    public void Partner_08_test_show_Notification_page_when_click_notification_button(){
        app.homePage().clickNotification();
        app.notificationPage().verifyNotificationPageDisplayed();
        app.notificationPage().clickBack();
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_09_test_show_RewardStatistics_page_when_click_Today_reward_block() {
        app.homePage().clickTodayReward();
        app.rewardStatisticsPage().verifyRewardStatisticsPageDisplayed();
        app.notificationPage().clickBack();
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_10_test_show_PickUpInTransitTab_when_click_TodayDeliverOrder(){
        app.homePage().clickTodayDeliveryOrder()
                .pickUpSection()
                .verifyPickUpInTransitTabDisplayed();
    }
    @Test
    public void Partner_11_test_show_Customer360_when_click_today_customer(){
        app.homePage().clickTodayCustomer();
        app.customer360Page().verifyCustomer360PageDisplayed();
        app.customer360Page().clickBack();
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_12_test_show_TripsSection_when_click_TodayTrips(){
        app.homePage().clickTodayTrips()
                .verifyTripSectionPageDisplayed();
    }
    @Test
    public void Partner_13_test_show_station_performance_page_when_click_station_performance_block(){
        app.homePage().clickStationPerformance();
        app.performancePage().verifyPerformancePageDisplayed();
        app.performancePage().clickBackToHome();
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_22_test_navigate_to_search_page_when_click_search_icon_on_home_page(){
        app.homePage().clickSearchIcon();
        app.searchPage().verifySearchPageDisplayed();
        app.searchPage().clickBack();
    }
}
