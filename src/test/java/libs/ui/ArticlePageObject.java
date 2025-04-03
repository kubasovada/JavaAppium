package libs.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import libs.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
    TITLE,
    TITLE2,
    FOOTER_ELEMENT,

    SAVE_IN_MODAL,
    MY_LIST_NAME_INPUT,
    OK_BUTTON_IN_MODAL,
    NAVIGATE_BACK,
    CLEAR_QUERY,
    CLICK_TO_CLOSE_KEYBORD_MP,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
    OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST,
    iOS_CREATE_NEW_LIST_BUTTON,
    LOGIN_BUTTON,
    SEARCH_EMPTY_MESSAGE;



    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Waiting for title on the article page")
    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public WebElement waitForTitleElement(String substring) {
        return this.waitForElementPresent(TITLE2, "Cannot find article title on page", 15);
    }

    @Step("Get article title")
    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        screenshot(this.takeScreenshot("articleTitle"));
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getText();
        } else if (Platform.getInstance().isIOS()) {
            return titleElement.getText();
        } else {
            return titleElement.getText();
        }

    }
    @Step("Swiping to footer on article page")
    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT,
                    "Cannot find the end of the article", 40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find the end of article", 100);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT, "Cannot find the end of the article", 40);
        }
    }
    @Step("Adding the article to my list")
    public void addArticleToMyList(String folderName) {

        this.waitForElementAndClick(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "save", 5);
        this.waitForElementAndClick(SAVE_IN_MODAL, "save2", 5 );

        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT,
                folderName,
                "nameList",
                5);
        this.waitForElementAndClick(OK_BUTTON_IN_MODAL,
                "ok list",
                5);
    }
    @Step("Closing the article")
    public void closeArticle() {

        this.waitForElementAndClick(NAVIGATE_BACK,
                "back",
                5);
        this.waitForElementAndClick(CLEAR_QUERY,
                "crest",
                5);
        this.waitForElementAndClick(NAVIGATE_BACK,
                "back",
                5);

        this.waitForElementAndClick(CLICK_TO_CLOSE_KEYBORD_MP,
                "pict",
                5);
    }


    public void closeArticleiOS() {

        this.waitForElementAndClick(NAVIGATE_BACK,
                "back",
                5);
        this.waitForElementAndClick(CLEAR_QUERY,
                "Cannot find Cancel button",
                5);
    }

    public String getTextFromElement() {
        WebElement element  = waitForElementPresent(SEARCH_EMPTY_MESSAGE,
                "Cannot find search empty message", 15);
        return element.getText();
    }

    public boolean assertElementPresent() {
        By by = this.getLocatorByString(TITLE);
        WebElement element = driver.findElement(by);
        return element.isEnabled();
    }

    // метод для ios и веба
    @Step("Adding article to my saved articles (iOS/Web)")
    public void addArticlesToMySaved(String folderNAme) throws InterruptedException {
        if (Platform.getInstance().isMW()) {
            removeArticleFromSavedIfItAdded();
            waitForElementToBeClickable(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "Not clickable Save article button", 9);
            waitForElementAndClick(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "Cannot find Save article button", 9);

//            waitForElementPresent(LOGIN_BUTTON, "No login button", 3);
//            boolean isNotPresent =  waitForElementNotPresent(LOGIN_BUTTON, "No login button", 5);
//            while (isNotPresent) {
//                waitForElementAndClick(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "Cannot find Save article button", 9);
//            }

        } else {
            this.waitForElementAndClick(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "Cannot find Save article button", 5);
            waitForElementAndClick(SAVE_IN_MODAL, "Cannot find locator in modal", 5);
            waitForElementAndClick(iOS_CREATE_NEW_LIST_BUTTON, "", 5);
            waitForElementAndSendKeys(MY_LIST_NAME_INPUT, folderNAme, "", 5);
            waitForElementAndClick(OK_BUTTON_IN_MODAL, "", 5);
        }
    }
    @Step("Removing the article from saved if it has been added")
    public void removeArticleFromSavedIfItAdded() {
        if (isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON, "Cannot click button to remove an article from saved", 1);
            waitForElementPresent(OPTIONS_SAVE_ARTICLE_BUTTON_TO_MY_LIST, "Cannot find button to add an article to saved list after removing it from this list before", 5);
        }
    }

}
