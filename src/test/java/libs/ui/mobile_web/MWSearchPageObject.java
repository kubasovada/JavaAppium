package libs.ui.mobile_web;

import libs.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT ="css:button#searchIcon";
        //SEARCH_INIT_ELEMENT ="css:div.search-box";
        SEARCH_INPUT ="css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON ="css:form button.clear";
        SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://div[contains(@class,'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT ="css:ul.mw-mf-page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT ="css:p.without-results";
        SEARCH_RESULTS_LIST ="xpath://XCUIElementTypeCollectionView]";


    }

    public MWSearchPageObject (RemoteWebDriver driver) {
        super(driver);
    }
}
