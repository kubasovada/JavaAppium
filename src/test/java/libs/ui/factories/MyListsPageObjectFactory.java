package libs.ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import libs.ui.MyListsPageObject;
import libs.ui.android.AndroidMyListsPageObject;
import libs.ui.ios.iOSMyListsPageObject;
import libs.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
     }
}

