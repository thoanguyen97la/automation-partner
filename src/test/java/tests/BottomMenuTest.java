package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Orders.OrderPage;
import pages.UserManagementPage;
import pages.components.BottomMenu;

public class BottomMenuTest extends BaseTest {
    @Test
    public void Partner_01_test_display_bottom_menu_when_open_app(){
        BottomMenu bottomMenu = new BottomMenu(driver);
        Assert.assertTrue(bottomMenu.isHomeTabDisplayed());
        Assert.assertTrue(bottomMenu.isOrderTabDisplayed());
        Assert.assertTrue(bottomMenu.isSearchTabDisplayed());
        Assert.assertTrue(bottomMenu.isUserTabDisplayed());
    }
    @Test
    public void Partner_03_test_Order_Page_is_displayed_when_click_order_tab(){
        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        OrderPage orderPage = bottomMenu.clickOrderTab();
        //Verify Order tab on bottom menu is selected
        Assert.assertEquals(bottomMenu.getOrderTabSelectedStatus(),"true");
        //Verify Order Page is displayed
        Assert.assertTrue(orderPage.isOrderPageDisplayed());
    }
    @Test
    public void Partner_05_test_User_Management_page_is_displayed_when_click_user_tab() {
        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        UserManagementPage userPage = bottomMenu.clickUserTab();
        //Verify User tab on bottom menu is selected
        Assert.assertEquals(bottomMenu.getUserTabSelectedStatus(),"true");
        //Verify User Management Page is displayed
        userPage.scrollToUtilsBlock();
        Assert.assertTrue(userPage.isUserPageDisplayed());
    }
    @Test
    public void Partner_02_test_Home_page_is_displayed_when_open_app(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
}
