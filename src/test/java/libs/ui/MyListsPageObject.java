package libs.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import libs.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{
    protected static  String
    MODAL,
    FOLDER_NAME_TMPL,
    ARTICLE_TITLE_TMPL,
    TAB_LIST,
    DELETE_ARTICLE_BUTTON,
    REMOVE_FROM_SAVED_BUTTON;

    //Java (programming language)
    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getFolderXpathWithName(String folderName) {
        return FOLDER_NAME_TMPL.replace("{FOLDER_NAME}", folderName);
    }

    private static String getSavedArticleXPathByTitle (String articleTitle) {
        return ARTICLE_TITLE_TMPL.replace("{TITLE}", articleTitle);
    }

    private static String getRemoveButtonByTitle(String articleTitle) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", articleTitle);
    }


    public void openFolderByName(String folderName) {
        String folderNameXPath = getFolderXpathWithName(folderName);
        this.waitForElementAndClick(MODAL, "not now", 5);
        this.waitForElementAndClick(folderNameXPath,
                "Cannot find folder name" + folderName, 5);
    }

    public void openFolderByNameiOS (String folderName) {
        String folderNameXPath = getFolderXpathWithName(folderName);
        this.waitForElementAndClick(MODAL, "not now", 5);
//        this.waitForElementAndClick(TAB_LIST, "Cannot find tab", 5);
//        this.waitForElementAndClick(folderNameXPath,
//                "Cannot find folder name" + folderName, 5);
    }

    public void waitForArticleToAppear(String articleTitle) {
        String articleXpath = getSavedArticleXPathByTitle(articleTitle);
        this.waitForElementPresent(articleXpath, "Saved article not present with title " + articleTitle, 15);

    }

    public void waitForArticleToDisappear(String articleTitle) {
        String articleXpath = getSavedArticleXPathByTitle(articleTitle);
        this.waitForElementNotPresent(articleXpath, "Saved article still present with title " + articleTitle, 5);

    }

    public void swipeByArticleToDelete(String articleTitle) {
        String articleXpath = getSavedArticleXPathByTitle(articleTitle);
        this.waitForArticleToAppear(articleTitle);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            // this.waitForArticleToAppear(articleTitle);
            this.swipeElementToLeft(articleXpath, "Cannot find saved article");
        } else {
            String removeLocator = getRemoveButtonByTitle(articleTitle);
            waitForElementAndClick(removeLocator,
                    "Cannot click button to remove article from saved", 10);
        }

//        if (Platform.getInstance().isIOS()) {
//            //this.clickElementToTheRightUpperCorner(articleXpath, "Cannot find saved article");
//            waitForElementAndClick(DELETE_ARTICLE_BUTTON, "Cannot find delete button", 5);
//        }

        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappear(articleTitle);
    }

}
