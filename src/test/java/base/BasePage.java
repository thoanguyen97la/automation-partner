package base;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public List<WebElement> findAllElements (By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendKeys(By locator, String text) {

        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.clear();
        ele.sendKeys(text);
    }
    public void swipeElement(By locator,String direction){
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",ele,
                "direction", direction,
                "percent", 1.0
        ));
    }
    public void scrollDownFullScreen(){
        Dimension size = driver.manage().window().getSize();

        int left = size.width / 10;
        int top = size.height / 5;
        int width = size.width * 8 / 10;
        int height = size.height * 6 / 10;
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", height,
                "direction", "down",
                "percent", 0.8
        ));
    }
}
