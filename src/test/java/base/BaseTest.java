package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;

    @BeforeMethod
    public void TestConfigure() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("PVINTKEIIBLR7LFQ");
        options.setAppPackage("com.sendo.sendostation");
        options.setAppActivity("com.sendo.sendostation.default");
        options.setNoReset(true); // 🔥 quan trọng
        options.setFullReset(false);
        options.ignoreHiddenApiPolicyError();
        options.setNewCommandTimeout(Duration.ofSeconds(3600));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
    @AfterMethod
    public void Teardown(){
        if (driver != null) {
            driver.terminateApp("com.sendo.sendostation");
            driver.quit();
        }
    }
}
