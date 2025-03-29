package libs.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class WelcomePageObject extends MainPageObject {

    protected static String
            STEP_LEARN_MORE_LINK,
            STEP_NEW_WAYS_TO_EXPLORE_TEXT,
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
            STEP_LEAN_MORE_ABOUT_DATA_COLLECTED_LINK,
            NEXT_LINK,
            GET_STARTED_BUTTON,
            ONBORDING_FOR_SWIPE,
            ONBORDING_ACCEPT_BUTTON,
            MAIN_PAGE,
            SKIP;


    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wiki'");
}

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New Way To Explore'");}

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Add or edit preferred text'");
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(STEP_LEAN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Learn more about data collected'");
    }

    public  void clickNextButton() {
        this.waitForElementAndClick(NEXT_LINK, "Cannot find and click 'Next' link ", 5);
}

public void clickGetStartedButton() {
        waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click get started button", 5);
}

public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Cannot find and click Skip button", 5);
}

    public void swipeOnbording() {
        swipeElementToLeft(ONBORDING_FOR_SWIPE,
                "Main page of Onbording not found");
    }

    public void clickAcceptButtonOnOnbording() {
        waitForElementAndClick(ONBORDING_ACCEPT_BUTTON,
                "Button Accept not found",
                10);
    }

    public boolean assertMainPagePresent() {
        WebElement element = waitForElementPresent(MAIN_PAGE, "Main page not found", 5);
        return element.isEnabled();
    }

}
