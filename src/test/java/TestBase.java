import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class TestBase {
    public AppiumDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        // Set the Appium server URL
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:deviceName", "R8YXB0D907H-dVOf6M");
        caps.setCapability("appium:platformVersion", "14");
        caps.setCapability("appium:app", "C:\\Users\\Production\\Downloads\\Tamawal (3).apk");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "sa.tamawal.capp");
        caps.setCapability("appium:appActivity", "sa.tamawal.capp.MainActivity");

        // Set Appium server URL
        URL appiumServerURL;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723");
        } catch (Exception e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }

        // Start Appium session
        driver = new AndroidDriver(appiumServerURL, caps);
    }


    // @AfterTest
    // public void tearDown()
    // Quit the driver after the test
    // if (driver != null) {
    //    driver.quit();
    //    System.out.println("App closed successfully!");
    //  }
    // }
}




