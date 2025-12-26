package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.components.BottomMenu;
import testdata.ExpectedDataSearch;

import java.util.List;

public class SearchTest extends BaseTest {
    @Test
    public void test_search_page_displayed_when_click_search_tab() {
        //1. Click Search tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        //Verify Search page is displayed
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        //Verify soft keyboard is displayed
        Assert.assertTrue(driver.isKeyboardShown());
        //Verify Search textbox is focused
        Assert.assertEquals(searchPage.SearchBoxFocusedStatus(),"true");
        //Verify FPT Sendo Farm slogan
        Assert.assertEquals(searchPage.getSlogan(),ExpectedDataSearch.EXPECTED_SLOGAN());
    }
    @Test
    public void test_search_product_with_keyword_should_return_results(){
        //1. Click Search tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        //2. Verify Search page is displayed
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        //3. Enter keyword "cam" and hide keyboard
        searchPage.enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        driver.hideKeyboard();
        //Verify return list of products
        List<String> productNames = searchPage.getSearchResult();
        Assert.assertFalse(productNames.isEmpty());
        //Verify return products list with product names contain keyword
        for (String name: productNames){
            Assert.assertTrue(name.toLowerCase().contains(ExpectedDataSearch.SEARCH_KEY_WORD()));
        }
    }
    @Test
    public void test_search_product_with_keyword_should_return_no_result(){
        //1. Click Search tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        //2. Verify Search page is displayed
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        //3. Enter keyword "cam" and hide keyboard
        searchPage.enterSearchKeyword(ExpectedDataSearch.NO_RESULT_SEARCH_KEY_WORD());
        driver.hideKeyboard();
        Assert.assertEquals(searchPage.getErrorMessage(), ExpectedDataSearch.EXPECTED_ERROR_MESSAGE(),"Error message should be "+ExpectedDataSearch.EXPECTED_ERROR_MESSAGE());
    }
    @Test
    public void test_show_share_bottom_sheet_when_click_share_button_on_product_card(){
        //1. Click Search tab on bottom menu
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        //2. Verify Search page is displayed
        Assert.assertTrue(searchPage.isSearchPageDisplayed());
        //3. Enter keyword "cam" and hide keyboard
        searchPage.enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        driver.hideKeyboard();
        //4. Click button "Moi Khach"
        searchPage.clickShareCustomer();
        //Verify product share bottom sheet is displayed
        Assert.assertTrue(searchPage.isProductShareBottomSheetDisplayed());
        Assert.assertTrue(searchPage.isZaloShareButtonDisplayed());
        Assert.assertTrue(searchPage.isQRShareButtonDisplayed());
        searchPage.scrollShareButtonsList();
        Assert.assertTrue(searchPage.isCopyButtonDisplayed());
        Assert.assertTrue(searchPage.isOtherButtonDisplayed());
    }

}
