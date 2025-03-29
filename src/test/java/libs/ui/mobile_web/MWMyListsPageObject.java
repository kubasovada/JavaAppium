package libs.ui.mobile_web;

import libs.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MWMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_TITLE_TMPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        //ARTICLE_TITLE_TMPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), 'Java (programming language)')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]/../../a[contains(@class, 'watched')]";
        LI_WITH_STAR = "css:li.with-watchstar";
    }
    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
