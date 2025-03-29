package libs.ui.mobile_web;

import libs.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        SAVED_LINKS = "css:a[data-event-name='menu.watchlist']";
        OPEN_NAVIGATION = "css:input#main-menu-input";

    }

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
