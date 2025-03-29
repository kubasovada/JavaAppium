package libs.ui;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String SAVED_LINKS,
    OPEN_NAVIGATION;



    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void     clickMyLists() {
        if (Platform.getInstance().isMW()) {
            tryClickElementWithFewAttempts(SAVED_LINKS,
                    "Cannot find navigation button to My list",
                    5);
        } else {

            this.waitForElementAndClick(SAVED_LINKS,
                    "Cannot find navigation button to my lists",
                    5);
        }
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open Navigation button", 5);
        } else  {
            System.out.println("Method openNavigation() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }


    }

}
