package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import libs.CoreTestCase;
import libs.Platform;
import libs.ui.ArticlePageObject;
import libs.ui.SearchPageObject;
import libs.ui.factories.ArticlePageObjectFactory;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    @Features(value={@Feature(value="Change of application conditions")})
    @DisplayName("Change screen orientation on search result screen")
    @Description("Rotate 'Java (programming language) article")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value=SeverityLevel.MINOR)
    public void testChangeScreenOrientationOnSearchResults() {
        if (Platform.getInstance().isMW()) {
            return;
        }

        String articleTitleFirst = "Java (programming language)";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring(articleTitleFirst);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String titleBeforeRotation = articlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String titleAfterRotation = articlePageObject.getArticleTitle();
        assertEquals("Article title changed after screen rotation",
                titleBeforeRotation, titleAfterRotation);
        this.rotateScreenPortrait();
        String titleAfterSecondRotation = articlePageObject.getArticleTitle();
        assertEquals(titleBeforeRotation, titleAfterSecondRotation);
    }

    @Test
    @Features(value={@Feature(value="Change of application conditions")})
    @DisplayName("Move application in background mode after searching of article")
    @Description("Background mode for app after searching of 'Java (programming language) article")
    @Step("Starting test testSearchTestArticleInBackground")
    @Severity(value=SeverityLevel.MINOR)
    public void testCheckSearchArticleInBackground() {
        if (Platform.getInstance().isMW()) {
            return;
        }

        String articleTitleFirst = "Java (programming language)";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult(articleTitleFirst);
        this.backgroundApp(2);
        searchPageObject.waitForSearchResult(articleTitleFirst);
    }
}
