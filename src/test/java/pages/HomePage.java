package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By searchBtn = By.xpath("//android.widget.ImageView[contains(@content-desc,'Tìm kiếm')]");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public SearchPage clickSearchBtn() {
        clickElement(searchBtn);
        return new SearchPage(driver);
    }

}
