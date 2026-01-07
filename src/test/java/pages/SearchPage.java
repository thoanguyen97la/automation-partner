package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.components.ShareBottomSheet;
import testdata.ExpectedDataSearch;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    //======LOCATORS=========//
    By shareBtn = AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Mời khách\"])[1]");
    By searchBox = AppiumBy.xpath("//android.widget.EditText");
    By slogan = AppiumBy.accessibilityId(ExpectedDataSearch.EXPECTED_SLOGAN());
    By productName = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+ ExpectedDataSearch.SEARCH_KEY_WORD()+"\")");
    By errorMessage = AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\""+ExpectedDataSearch.EXPECTED_ERROR_MESSAGE()+"\")");


    public SearchPage(AndroidDriver driver) {
        super(driver);
    }
    private boolean isSearchPageDisplayed() {
        return waitForElementVisible(searchBox).isDisplayed();
    }
    public void verifySearchPageDisplayed(){
        Assert.assertTrue(isSearchPageDisplayed(),"Search page is not displayed");
    }
    public void verifySoftKeyboardDisplayed(){
        Assert.assertTrue(driver.isKeyboardShown(),"Soft keyboard is not displayed");
    }
    public void verifyFPTSloganDisplayed(){
        Assert.assertEquals(getSlogan(),ExpectedDataSearch.EXPECTED_SLOGAN(),"Slogan is not displayed correctly");
    }
    public void verifySearchBoxIsFocusedByDefault(){
        Assert.assertEquals(SearchBoxFocusedStatus(),"true","Search box is not focused");
    }
    public String SearchBoxFocusedStatus(){
        return waitForElementVisible(searchBox).getAttribute("focused");
    }
    private String getSlogan(){
        return waitForElementVisible(slogan).getAttribute("content-desc");
    }
    public void enterSearchKeyword(String keyWord){
        sendKeys(searchBox,keyWord);
    }
    private List<String> getSearchResult(){
        List<WebElement> results = findAllElements(productName);
        List<String> texts = new ArrayList<>();
        for(WebElement result: results){
            texts.add(result.getAttribute("content-desc\n"));
        }
        return texts;
    }

    public void verifySearchResultsContainKeyword(String keyWord){
        List<String> productNames = getSearchResult();
        Assert.assertFalse(productNames.isEmpty(),"Search results are empty");
        for(String productName: productNames){
            Assert.assertTrue(productName.toLowerCase().contains(keyWord.toLowerCase()),
                    "Search result '"+productName+"' does not contain keyword '"+keyWord+"'");
        }
    }
    public void verifyErrorMessageDisplayed(){
        Assert.assertEquals(getErrorMessage(), ExpectedDataSearch.EXPECTED_ERROR_MESSAGE(),"Error message should be "+ExpectedDataSearch.EXPECTED_ERROR_MESSAGE());
    }
    private String getErrorMessage() {
        return waitForElementVisible(errorMessage).getAttribute("content-desc\n");
    }
    public ShareBottomSheet clickShareCustomer(){
        clickElement(shareBtn);
        return new ShareBottomSheet(driver);
    }
    public void hideSoftKeyboard(){
        driver.hideKeyboard();
    }

}
