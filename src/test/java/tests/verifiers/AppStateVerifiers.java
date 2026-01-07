package tests.verifiers;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AppStateVerifiers {
    AndroidDriver driver;
    public AppStateVerifiers(AndroidDriver driver){
        this.driver = driver;
    }
    public void verifyZaloAppOpened(){
        waitForAppLaunched("com.zing.zalo");
        String currentPackage = driver.getCurrentPackage();
        Assert.assertEquals(currentPackage,"com.zing.zalo","App package should be 'com.zing.zalo'");
    }
    public void waitForAppLaunched(String expectedPackage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d ->driver.getCurrentPackage().equals(expectedPackage));
    }
}
