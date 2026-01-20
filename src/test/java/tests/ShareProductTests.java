package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.components.sheets.ProductShareBottomSheet;
import pages.components.sheets.QRCodeShareBottomSheet;
import tests.verifiers.AppStateVerifiers;
import tests.verifiers.SystemShareSheet;

public class ShareProductTests extends BaseTest {
    @Test
    public void Partner_27_test_share_options_displayed_on_bottom_sheet(){
        app.homePage().clickShareButtonOnProductCard();
        app.productShareBottomSheet().verifyProductShareBottomSheetDisplayed();
        app.productShareBottomSheet().verifyAllShareButtonsDisplayed();
    }
    @Test
    public void Partner_28_test_share_product_via_Zalo(){
        app.homePage().clickShareButtonOnProductCard();
        app.productShareBottomSheet().clickZaloShareButton();
        app.appStateVerifiers().verifyZaloAppOpened();
    }
    @Test
    public void Partner_29_test_share_product_via_QR_code(){
        app.homePage().clickShareButtonOnProductCard();
        app.productShareBottomSheet().clickQRShareButton();
        app.qrCodeShareBottomSheet().verifyQRCodeShareBottomSheetDisplayed();
    }
    @Test
    public void Partner_30_test_share_product_via_Copy_link() {
        app.homePage().clickShareButtonOnProductCard();
        app.productShareBottomSheet().clickCopyLinkButton();
        app.productShareBottomSheet().verifyToastMessageDisplayed("Đã sao chép nội dung tin");
    }
    @Test
    public void Partner_31_test_share_product_via_Others_share(){
        app.homePage().clickShareButtonOnProductCard();
        app.productShareBottomSheet().clickOtherShareButton();
        app.systemShareSheet().verifySystemShareSheetDisplayed();
        app.systemShareSheet().closeSystemShareSheet();
    }
}
