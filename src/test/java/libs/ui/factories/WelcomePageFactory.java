package libs.ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import libs.ui.WelcomePageObject;
import libs.ui.android.AndroidWelcomePageObject;
import libs.ui.ios.iOSWelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageFactory {

    public static WelcomePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidWelcomePageObject(driver);
        } else {
            return new iOSWelcomePageObject(driver);
        }
     }
}
