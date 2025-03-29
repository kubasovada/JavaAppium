package libs.ui.android;

import io.appium.java_client.AppiumDriver;
import libs.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomePageObject extends WelcomePageObject {

    static {
        STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Узнать подробнее о Википедии\"]";
        STEP_NEW_WAYS_TO_EXPLORE_TEXT = "xpath://XCUIElementTypeStaticText[@name=\"Новые способы изучения\"]";
        STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Добавить или изменить предпочтительные языки\"]";
        STEP_LEAN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Узнайте больше о нашей политике конфиденциальности и условиях использования.\"]";
        NEXT_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Далее\"]";
        GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Начать\"]";
        SKIP = "xpath://XCUIElementTypeStaticText[@name='Пропустить']";
        ONBORDING_FOR_SWIPE = "xpath://android.widget.TextView[@resource-id=\"org.wikipedia:id/primaryTextView\"]";
        ONBORDING_ACCEPT_BUTTON = "xpath://android.widget.Button[@resource-id=\"org.wikipedia:id/acceptButton\"]";
        MAIN_PAGE = "xpath://android.widget.ImageView[@resource-id=\"org.wikipedia:id/main_toolbar_wordmark\"]";
    }


    public AndroidWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
