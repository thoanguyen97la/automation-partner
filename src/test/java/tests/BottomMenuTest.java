package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Orders.OrderPage;
import pages.SearchPage;
import pages.UserManagementPage;
import pages.components.BottomMenu;


public class BottomMenuTest extends BaseTest {
    @Test
    public void Partner_01_test_display_bottom_menu_when_open_app(){
        app.bottomMenu().verifyBottomMenuDisplayed();
    }
    @Test
    public void Partner_02_test_Home_page_is_displayed_when_open_app(){
        app.homePage().verifyHomePageDisplayed();
    }
    @Test
    public void Partner_03_test_Order_Page_is_displayed_when_click_order_tab(){

        //1. Click Order tab on bottom menu
        System.out.println("=== INIT OBJECTS ===");
        System.out.println("Driver: " + driver);
        System.out.println("BottomMenu: " + app.bottomMenu());
        app.bottomMenu().clickOrderTab();
        //Verify Order tab on bottom menu is selected
        app.bottomMenu().verifyOrderTabSelected();
        //Verify Order Page is displayed
        app.orderPage().verifyOrderPageDisplayed();
    }
    @Test
    public void Partner_04_test_search_page_displayed_when_click_search_tab() {
        app.bottomMenu().clickSearchTab();
        app.searchPage().verifySearchPageDisplayed();
    }
    @Test
    public void Partner_05_test_User_Management_page_is_displayed_when_click_user_tab() {
        app.bottomMenu().clickUserTab();
        app.bottomMenu().verifyUserTabSelected();
        app.userManagementPage().verifyUserPageDisplayed();
    }
}
