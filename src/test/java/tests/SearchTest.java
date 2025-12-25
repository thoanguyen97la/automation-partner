package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    @Test
    public void test_search_page_displayed_when_click_search_tab() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.clickSearchBtn();
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        Assert.assertTrue(driver.isKeyboardShown());
        Assert.assertEquals(searchPage.SearchBoxFocusedStatus(),"true");
    }

}
