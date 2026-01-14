package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.TopSellPage;
import pages.components.homewidgets.TopSellWidget;
import pages.components.sheets.RewardBottomSheet;
import pages.components.sheets.ProductShareBottomSheet;
import pages.components.sheets.TopSellInfoBottomSheet;

public class TopSellHomeWidgetTests extends BaseTest {
    @Test
    public void Partner_14_test_top_sale_home_widget_displayed_correctly(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        topSellWidget.verifyTopSaleWidgetDisplayed();
    }
    @Test
    public void Partner_16_test_navigate_to_top_sale_page_when_click_see_more_button_on_top_sale_widget(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        TopSellPage topSellPage = topSellWidget.clickSeeMoreButton();
        topSellPage.verifyTopSalePageDisplayed();
        HomePage homePage = topSellPage.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_15_test_show_info_bottom_sheet_when_click_on_top_sale_widget_header(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        TopSellInfoBottomSheet bottomSheet = topSellWidget.clickOnWidgetHeader();
        bottomSheet.verifyTopSaleInfoBottomSheetDisplayed();
        bottomSheet.closeBottomSheet();
    }
    @Test
    public void Partner_20_test_show_at_least_one_product_on_widget() {
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        topSellWidget.verifyTopSaleProductIsShown();
    }
    @Test
    public void Partner_21_test_product_card_on_widget_shows_correct_information(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        topSellWidget.verifyProductInfoDisplayedCorrect();
    }
    @Test
    public void Partner_19_test_click_product_card_on_widget(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        String productNameOnCard = topSellWidget.getFirstProductName();
        System.out.println("Expected product name: " + productNameOnCard);
        ProductDetailPage productDetailPage = topSellWidget.clickOnFirstProductCard();
        productDetailPage.verifyProductNameMatches(productNameOnCard);
        HomePage homePage = productDetailPage.clickBack();
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_18_test_click_reward_icon_on_product_card() throws InterruptedException {
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        RewardBottomSheet rewardBottomSheet = topSellWidget.clickRewardIconProductCard();
        rewardBottomSheet.verifyRewardBottomSheetDisplayed();
        rewardBottomSheet.closeBottomSheet();
        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePageDisplayed();
    }
    @Test
    public void Partner_17_test_click_share_icon_on_product_card(){
        TopSellWidget topSellWidget = new TopSellWidget(driver);
        ProductShareBottomSheet productShareBottomSheet = topSellWidget.clickShareButtonProductCard();
        productShareBottomSheet.verifyProductShareBottomSheetDisplayed();
        productShareBottomSheet.verifyAllShareButtonsDisplayed();
        productShareBottomSheet.closeBottomSheet();
    }
}
