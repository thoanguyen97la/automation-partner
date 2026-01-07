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
        BottomMenu bottomMenu = new BottomMenu(driver);
        bottomMenu.verifyBottomMenuDisplayed();
    }
    @Test
    public void Partner_02_test_Home_page_is_displayed_when_open_app(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_03_test_Order_Page_is_displayed_when_click_order_tab(){

        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        System.out.println("=== INIT OBJECTS ===");
        System.out.println("Driver: " + driver);
        System.out.println("BottomMenu: " + bottomMenu);
        OrderPage orderPage = bottomMenu.clickOrderTab();
        //Verify Order tab on bottom menu is selected
        bottomMenu.verifyOrderTabSelected();
        //Verify Order Page is displayed
        orderPage.verifyOrderPageDisplayed();
    }
    @Test
    public void Partner_04_test_search_page_displayed_when_click_search_tab() {
        //1. Click Search tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        //Verify Search page is displayed
        searchPage.verifySearchPageDisplayed();
    }
    @Test
    public void Partner_05_test_User_Management_page_is_displayed_when_click_user_tab() {
        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        UserManagementPage userPage = bottomMenu.clickUserTab();
        bottomMenu.verifyUserTabSelected();
        userPage.verifyUserPageDisplayed();
    }
}
