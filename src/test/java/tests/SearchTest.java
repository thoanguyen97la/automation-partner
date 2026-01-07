package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.components.BottomMenu;
import pages.components.ShareBottomSheet;
import testdata.ExpectedDataSearch;


public class SearchTest extends BaseTest {
    @Test
    public void Partner_22_test_search_page_default_displayed() {
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        searchPage.verifySearchPageDisplayed();
        searchPage.verifySoftKeyboardDisplayed();
        searchPage.verifySearchBoxIsFocusedByDefault();
        searchPage.verifyFPTSloganDisplayed();
    }
    @Test
    public void Partner_23_test_search_product_return_results(){
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        searchPage.verifySearchPageDisplayed();
        searchPage.enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        searchPage.hideSoftKeyboard();
        searchPage.verifySearchResultsContainKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());

    }
    @Test
    public void Partner_24_test_search_product_return_no_result(){
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        searchPage.verifySearchPageDisplayed();
        searchPage.enterSearchKeyword(ExpectedDataSearch.NO_RESULT_SEARCH_KEY_WORD());
        searchPage.hideSoftKeyboard();
        searchPage.verifyErrorMessageDisplayed();
    }
    @Test
    public void Partner_25_test_show_share_bottom_sheet_when_click_share_button_on_product_card(){
        BottomMenu bottomMenu = new BottomMenu(driver);
        SearchPage searchPage = bottomMenu.clickSearchTab();
        searchPage.verifySearchPageDisplayed();
        searchPage.enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        searchPage.hideSoftKeyboard();
        ShareBottomSheet shareBottomSheet= searchPage.clickShareCustomer();
        shareBottomSheet.verifyProductShareBottomSheetDisplayed();
        shareBottomSheet.verifyAllShareButtonsDisplayed();
    }
}
