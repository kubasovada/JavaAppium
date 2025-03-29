package libs.ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import libs.ui.SearchPageObject;
import libs.ui.android.AndroidSearchPageObject;
import libs.ui.ios.iOSSearchPageObject;
import libs.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver) {
if (Platform.getInstance().isAndroid()) {
    return new AndroidSearchPageObject(driver);
} else if (Platform.getInstance().isIOS()) {
    return new iOSSearchPageObject(driver);
} else {
    return new MWSearchPageObject(driver);
}
    }
}
