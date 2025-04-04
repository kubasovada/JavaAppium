package libs.ui.factories;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import libs.ui.ArticlePageObject;
import libs.ui.android.AndroidArticlePageObject;
import libs.ui.ios.iOSArticlePageObject;
import libs.ui.mobile_web.MWArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return  new iOSArticlePageObject(driver);
        } else {
            return  new MWArticlePageObject(driver);
        }
    }
}
