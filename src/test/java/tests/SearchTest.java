package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.components.BottomMenu;
import pages.components.sheets.ProductShareBottomSheet;
import testdata.ExpectedDataSearch;


public class SearchTest extends BaseTest {
    @Test
    public void Partner_26_test_search_page_default_displayed() {
        app.bottomMenu().clickSearchTab();
        app.searchPage().verifySearchPageDisplayed();
        app.searchPage().verifySoftKeyboardDisplayed();
        app.searchPage().verifySearchBoxIsFocusedByDefault();
        app.searchPage().verifyFPTSloganDisplayed();
    }
    @Test
    public void Partner_23_test_search_product_return_results(){
        app.bottomMenu().clickSearchTab();
        app.searchPage().verifySearchPageDisplayed();
        app.searchPage().enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        app.searchPage().hideSoftKeyboard();
        app.searchPage().verifySearchResultsContainKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
    }
    @Test
    public void Partner_24_test_search_product_return_no_result(){
        app.bottomMenu().clickSearchTab();
        app.searchPage().verifySearchPageDisplayed();
        app.searchPage().enterSearchKeyword(ExpectedDataSearch.NO_RESULT_SEARCH_KEY_WORD());
        app.searchPage().hideSoftKeyboard();
        app.searchPage().verifyErrorMessageDisplayed();
    }
    @Test
    public void Partner_25_test_show_share_bottom_sheet_when_click_share_button_on_product_card(){
        app.bottomMenu().clickSearchTab();
        app.searchPage().verifySearchPageDisplayed();
        app.searchPage().enterSearchKeyword(ExpectedDataSearch.SEARCH_KEY_WORD());
        app.searchPage().hideSoftKeyboard();
        app.searchPage().clickShareCustomer();
        app.productShareBottomSheet().verifyProductShareBottomSheetDisplayed();
    }
}
