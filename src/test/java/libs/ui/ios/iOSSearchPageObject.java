package libs.ui.ios;

import io.appium.java_client.AppiumDriver;
import libs.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        ONBORDING_SKIP_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Skip']";
        SEARCH_INIT_ELEMENT ="xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT ="xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON ="xpath://XCUIElementTypeStaticText[@name='Cancel']";
        //SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://XCUIElementTypeStaticText[@name=\"Java (programming language)\"]";
        SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";

        SEARCH_RESULT_ELEMENT ="xpath://XCUIElementTypeCollectionView]";
        SEARCH_EMPTY_RESULT_ELEMENT ="xpath:///XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULTS_LIST ="xpath://XCUIElementTypeCollectionView]";
    }

    public iOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
