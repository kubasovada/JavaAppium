package libs.ui.mobile_web;

import libs.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer.minerva-footer";
        OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST = "css:li#page-actions-watch>a";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://span[text()='Unwatch']/..";
        /// /////
        MY_LIST_NAME_INPUT = "xpath://XCUIElementTypeTextField[@value='reading list title']";
        OK_BUTTON_IN_MODAL = "xpath://XCUIElementTypeStaticText[@name='Create reading list']";
        NAVIGATE_BACK = "xpath://XCUIElementTypeButton[@name='Back']";
        CLEAR_QUERY = "xpath://XCUIElementTypeStaticText[@name=\"Cancel\"]";
        CLICK_TO_CLOSE_KEYBORD_MP = "xpath://android.widget.ImageView[@resource-id=\"org.wikipedia:id/view_announcement_header_image\"]";
        SEARCH_EMPTY_MESSAGE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/search_empty_message']";
        LOGIN_BUTTON = "xpath://div[contains(@class, 'drawer')]/a[@type='button']";


    }


    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
