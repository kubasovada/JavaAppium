package libs.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class iOSTestCase extends TestCase {
//    protected AppiumDriver driver;
//    private String AppiumUrl = "http://127.0.0.1:4723";
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "iOS");
//        capabilities.setCapability("appium:deviceName", "iPhone 15");
//        capabilities.setCapability("appium:platformVersion", "17.5");
//        capabilities.setCapability("appium:automationName", "XCUITest");
//        capabilities.setCapability("appium:app", "/Users/darya/Desktop/JavaAppiumAutomation/apks/Wikipedia772.app");
//
//        driver = new IOSDriver(new URL(AppiumUrl), capabilities);
//        this.rotateScreenPortrait();
//
//    }
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//        driver.quit();
//    }
//
//    protected void rotateScreenLandscape() {
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//    }
//
//    protected void rotateScreenPortrait () {
//        driver.rotate(ScreenOrientation.PORTRAIT);
//    }
//
//    protected void backgroundApp(int seconds) {
//        driver.runAppInBackground(seconds);
//    }
}
