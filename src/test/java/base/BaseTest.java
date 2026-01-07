package base;

        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.android.options.UiAutomator2Options;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.time.Duration;

        public class BaseTest {
            public AndroidDriver driver;


            @BeforeMethod
            public void TestConfigure() throws MalformedURLException, InterruptedException {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("android");
                options.setAutomationName("UiAutomator2");
                options.setDeviceName("PVINTKEIIBLR7LFQ");
                options.setAppPackage("com.sendo.sendostation");
                options.setAppActivity("com.sendo.sendostation.event");
                options.setAppWaitActivity("*");
                options.setAppWaitDuration(Duration.ofSeconds(600));
                options.setNoReset(true);
                options.setFullReset(false);
                // ===== STABILITY (OPPO / ColorOS) =====
                options.setAutoGrantPermissions(true);
                options.setDisableWindowAnimation(true);
                options.setIgnoreHiddenApiPolicyError(true);
                // ===== SESSION STABILITY =====
                options.setNewCommandTimeout(Duration.ofSeconds(300));
                options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(120));
                options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(120));
                System.out.println("Driver is starting!");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                driver.activateApp("com.sendo.sendostation");
                System.out.println("App launched and bottom menu ready!");
            }


            @AfterMethod
            public void Teardown() {
                if (driver != null) {
                    driver.terminateApp("com.sendo.sendostation");
                    driver.quit();
                }
            }
        }