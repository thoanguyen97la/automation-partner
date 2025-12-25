package base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendKeys(By locator, String text) {

        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.clear();
        ele.sendKeys(text);
    }

}
