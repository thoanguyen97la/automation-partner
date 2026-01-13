package pages.components.homewidgets;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProductDetailPage;
import pages.TopSellPage;
import pages.components.sheets.TopSellInfoBottomSheet;

import java.util.List;

public class TopSellWidget extends BasePage {
    //======LOCATORS=======//
    By headerTitle = AppiumBy.accessibilityId("Sản phẩm bán chạy tại điểm");
    By seeMoreBtn = AppiumBy.accessibilityId("Xem thêm");
    By productCard = AppiumBy.xpath("//android.view.View[contains(@content-desc,\"Bán gần đây\")]");
    By shareBtn = AppiumBy.xpath("//android.view.View[contains(@content-desc,\"Bán gần đây\")]/android.widget.ImageView[3]");

    public TopSellWidget(AndroidDriver driver) {
        super(driver);
    }

    public void verifyTopSaleWidgetDisplayed() {
        Assert.assertTrue(isElementDisplayed(headerTitle), "TopSale widget is not displayed on Home page");
    }

    public TopSellInfoBottomSheet clickOnWidgetHeader() {
        clickElement(headerTitle);
        return new TopSellInfoBottomSheet(driver);
    }

    public TopSellPage clickSeeMoreButton() {
        clickElement(seeMoreBtn);
        return new TopSellPage(driver);
    }

    private List<WebElement> getProductList() {
        return findAllElements(productCard);
    }

    public void verifyTopSaleProductIsShown() {
        Assert.assertFalse(getProductList().isEmpty(), "No product shows in top sale widget!");
    }

    public ProductDetailPage clickOnFirstProductCard() {
        List<WebElement> products = getProductList();
        if (!products.isEmpty()) {
            products.get(0).click();
            //You can add more verification steps here after clicking the product card
        }
        return new ProductDetailPage(driver);
    }

    private TopSellProductModel ParseProductInfo(WebElement productEl){
        String description = productEl.getAttribute("content-desc");
        if (description == null || description.isEmpty()) return null;
        String[] infoParts = description.split("\n");
        String soldInfo = infoParts[0];
        String productName = infoParts[1];
        String priceInfo = infoParts[2];
        return new TopSellProductModel(productName,soldInfo,priceInfo,productEl);
    }
    public String getFirstProductName(){
        List<WebElement> products = getProductList();
        TopSellProductModel product = ParseProductInfo(products.get(0));
        Assert.assertNotNull(product, "Failed to parse product info");
        return product.name;
    }

    public void verifyProductInfoDisplayedCorrect(){
        List<WebElement> products = getProductList();
        TopSellProductModel product = ParseProductInfo(products.get(0));
        assert product != null;
        System.out.println("Product Name: " + product.name);
        System.out.println("Sold Info: " + product.soldInfo);
        System.out.println("Price Info: " + product.price);
        Assert.assertFalse(product.name.isEmpty(), "Product name is missing");
        Assert.assertTrue(product.soldInfo.contains("Bán gần đây"), "Sold info is missing or incorrect");
        Assert.assertFalse(product.price.isEmpty(), "Price info is missing");
        Assert.assertTrue(product.price.contains("đ"), "Price info is not displayed in VND");
    }
    public void clickShareButtonProductCard(){
        scrollUntilElementVisible(shareBtn);
        clickElement(shareBtn);
    }
}
