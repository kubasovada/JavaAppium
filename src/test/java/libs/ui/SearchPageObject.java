package libs.ui;

import io.appium.java_client.AppiumDriver;
import libs.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
    ONBORDING_SKIP_BUTTON,
    SEARCH_INIT_ELEMENT,
    SEARCH_INPUT,
    SEARCH_CANCEL_BUTTON,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    SEARCH_RESULT_ELEMENT,
    SEARCH_EMPTY_RESULT_ELEMENT,
    SEARCH_RESULTS_LIST;

//"Java (programming language)"

    // TEMPLATES METHODS
    public static String getResultSearchElement (String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    // TEMPLATES METHODS


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void skipOnboarding() {
        waitForElementAndClick(ONBORDING_SKIP_BUTTON,
                "Cannot find skip button in Onboarding",
                5);
    }

    public void initSearchInput()
    {
       // this.skipOnboarding();
        this.waitForElementPresent((SEARCH_INIT_ELEMENT), "Cannot find search input");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Cannot find and click search init element", 5);

        this.waitForElementPresent(SEARCH_INPUT,
                "Cannot find search input after clicking search init element");
    }
    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, searchLine, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String searchResultXPath = getResultSearchElement(substring);
        this.waitForElementPresent(searchResultXPath, "Cannot find search result with substring " + substring);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button");
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String searchResultXPath = getResultSearchElement(substring);
        this.waitForElementAndClick(searchResultXPath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request", 5);
        return  this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result by the request", 5);
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "we supposed not to find any results");
    }

    public void waitForListResult() {
        waitForElementPresent(SEARCH_RESULT_ELEMENT,
                "Cannot find search result list", 5);
    }




}
