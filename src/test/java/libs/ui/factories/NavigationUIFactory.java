package libs.ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import libs.ui.NavigationUI;
import libs.ui.android.AndroidNavigationUI;
import libs.ui.ios.iOSNavigationUI;
import libs.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public static NavigationUI get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);

        }
    }
}
