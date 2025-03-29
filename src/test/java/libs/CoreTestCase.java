package libs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import libs.ui.WelcomePageObject;
import libs.ui.factories.WelcomePageFactory;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
   // protected Platform platform;


    protected RemoteWebDriver driver;
    private String AppiumUrl = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        driver = Platform.getInstance().getDriver();
//        this.platform = new Platform();
//        driver = this.platform.getDriver();

//        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
//        driver = new AndroidDriver(new URL(AppiumUrl), capabilities);
        this.rotateScreenPortrait();
        //this.skipWelcomePageForIosApp();
        this.openWikiWebPageForMobileWeb();

    }

//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//        driver.quit();
//    }

    protected void rotateScreenLandscape() {
        if (driver instanceof AppiumDriver) {
        AppiumDriver driver = (AppiumDriver) this.driver;
        driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateScreenPortrait() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void backgroundApp(int seconds) {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } else {
            System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    protected void openWikiWebPageForMobileWeb()  {
        if (Platform.getInstance().isMW()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
         }

    }

    private void skipWelcomePageForIosApp() {
        if (Platform.getInstance().isIOS()) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject welcomePageObject = WelcomePageFactory.get(driver);
            welcomePageObject.clickSkip();
        }
    }

}

