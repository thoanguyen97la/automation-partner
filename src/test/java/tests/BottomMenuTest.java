package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;
import pages.UserPage;
import pages.components.BottomMenu;

public class BottomMenuTest extends BaseTest {
    @Test
    public void test_Order_Page_is_displayed_when_click_order_tab(){
        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        OrderPage orderPage = bottomMenu.clickOrderTab();
        //Verify Order tab on bottom menu is selected
        Assert.assertEquals(bottomMenu.getOrderTabSelectedStatus(),"true");
        //Verify Order Page is displayed
        Assert.assertTrue(orderPage.isOrderPageDisplayed());
    }
    @Test
    public void test_User_Management_page_is_displayed_when_click_user_tab() throws InterruptedException {
        //1. Click Order tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        UserPage userPage = bottomMenu.clickUserTab();
        //Verify User tab on bottom menu is selected
        Assert.assertEquals(bottomMenu.getUserTabSelectedStatus(),"true");
        Thread.sleep(3000);
        //Verify User Management Page is displayed
        userPage.scrollToUtilsBlock();
        Assert.assertTrue(userPage.isUserPageDisplayed());
    }


}
