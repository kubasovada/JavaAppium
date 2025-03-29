package libs.ui.ios;

import io.appium.java_client.AppiumDriver;
import libs.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        MODAL = "xpath://XCUIElementTypeButton[@name='Close']";
        TAB_LIST = "xpath://XCUIElementTypeStaticText[@name=\"Reading lists\"]";
        FOLDER_NAME_TMPL = "xpath://XCUIElementTypeStaticText[@name='{FOLDER_NAME}']";
        ARTICLE_TITLE_TMPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        DELETE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name=\"swipe action delete\"]";
    }

    public iOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
