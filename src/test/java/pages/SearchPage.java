package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.ExpectedDataSearch;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    //======LOCATORS=========//
    By searchBox = AppiumBy.xpath("//android.widget.EditText");
    By slogan = AppiumBy.accessibilityId(ExpectedDataSearch.EXPECTED_SLOGAN());
    By productName = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+ ExpectedDataSearch.SEARCH_KEY_WORD()+"\")");
    By errorMessage = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+ExpectedDataSearch.EXPECTED_ERROR_MESSAGE()+"\")");
    By shareBtn = AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Mời khách\"])[1]");
    By productShareBottomSheet = AppiumBy.accessibilityId("Mã QR sản phẩm");
    By zaloShareBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Chia sẻ qua Zalo\")");
    By qrShareBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Chia sẻ mã QR sản phẩm\")");
    By copyBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Sao chép\")");
    By otherBtn = AppiumBy.androidUIAutomator("new UiSelector().description(\"Khác\")");

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public boolean isSearchPageDisplayed() {
        return findElement(searchBox).isDisplayed();
    }
    public String SearchBoxFocusedStatus(){
        return findElement(searchBox).getAttribute("focused");
    }
    public String getSlogan(){
        return findElement(slogan).getAttribute("content-desc");
    }
    public void enterSearchKeyword(String keyWord){
        sendKeys(searchBox,keyWord);
    }
    public List<String> getSearchResult(){
        List<WebElement> results = findAllElements(productName);
        List<String> texts = new ArrayList<>();
        for(WebElement result: results){
            texts.add(result.getAttribute("content-desc\n"));
        }
        return texts;
    }
    public String getErrorMessage() {
        return findElement(errorMessage).getAttribute("content-desc\n");
    }
    public void clickShareCustomer(){
        clickElement(shareBtn);
    }
    public boolean isProductShareBottomSheetDisplayed(){
        return findElement(productShareBottomSheet).isDisplayed();
    }
    public boolean isZaloShareButtonDisplayed(){
        return findElement(zaloShareBtn).isDisplayed();
    }
    public boolean isQRShareButtonDisplayed(){
        return findElement(qrShareBtn).isDisplayed();
    }
    public boolean isCopyButtonDisplayed(){
        return findElement(copyBtn).isDisplayed();
    }
    public boolean isOtherButtonDisplayed(){
        return findElement(otherBtn).isDisplayed();
    }
    public void scrollShareButtonsList(){
        swipeElement(qrShareBtn,"left");
    }
}
