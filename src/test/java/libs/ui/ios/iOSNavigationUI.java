package libs.ui.ios;

import io.appium.java_client.AppiumDriver;
import libs.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI {

    static {SAVED_LINKS = "xpath://XCUIElementTypeButton[@name=\"Saved\"]";
}
    public iOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
