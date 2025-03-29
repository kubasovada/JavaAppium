package libs.ui.ios;

import libs.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://XCUIElementTypeStaticText[contains(@name, 'Java (programming language)')]";
        TITLE2 = "xpath://XCUIElementTypeStaticText[@name='Appium']";
        //FOOTER_ELEMENT = "xpath://android.widget.TextView[@text=\"View article in browser\"]";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='View article in browser']";
        OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST = "xpath:///XCUIElementTypeButton[@name='Save for later']";
        SAVE_IN_MODAL = "xpath://XCUIElementTypeStaticText[@name=\"Add “Java (programming language)” to a reading list?\"]";
        iOS_CREATE_NEW_LIST_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Create a new list']";
        MY_LIST_NAME_INPUT = "xpath://XCUIElementTypeTextField[@value='reading list title']";
        OK_BUTTON_IN_MODAL = "xpath://XCUIElementTypeStaticText[@name='Create reading list']";
        NAVIGATE_BACK = "xpath://XCUIElementTypeButton[@name='Back']";
        CLEAR_QUERY = "xpath://XCUIElementTypeStaticText[@name=\"Cancel\"]";
        CLICK_TO_CLOSE_KEYBORD_MP = "xpath://android.widget.ImageView[@resource-id=\"org.wikipedia:id/view_announcement_header_image\"]";
        SEARCH_EMPTY_MESSAGE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/search_empty_message']";

    }

    public iOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
