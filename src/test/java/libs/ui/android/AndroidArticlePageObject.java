package libs.ui.android;

import libs.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

     static {
         TITLE = "xpath://android.widget.TextView[@text=\"Java (programming language)\"]";
                 TITLE2 = "xpath://android.widget.TextView[@text=\"Appium\"]";
                 FOOTER_ELEMENT = "xpath://android.widget.TextView[@text=\"View article in browser\"]";
                 OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST = "xpath://android.widget.TextView[@content-desc=\"Save\"]";
                 SAVE_IN_MODAL = "xpath://android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]";
                 MY_LIST_NAME_INPUT = "xpath://android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]";
                 OK_BUTTON_IN_MODAL = "xpath://android.widget.Button[@resource-id=\"android:id/button1\"]";
                 NAVIGATE_BACK = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
                 CLEAR_QUERY = "xpath://android.widget.ImageView[@content-desc=\"Clear query\"]";
                 CLICK_TO_CLOSE_KEYBORD_MP = "xpath://android.widget.ImageView[@resource-id=\"org.wikipedia:id/view_announcement_header_image\"]";
                 SEARCH_EMPTY_MESSAGE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/search_empty_message']";

     }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
         super(driver);
    }
}
