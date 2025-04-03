package src.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import libs.CoreTestCase;
import libs.Platform;
import libs.ui.ArticlePageObject;
import libs.ui.MainPageObject;
import libs.ui.SearchPageObject;
import libs.ui.factories.ArticlePageObjectFactory;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class ArticleTests extends CoreTestCase {

    @Test
    @DisplayName("Compare article title with expected one")
    @Description("We open 'Objected-oriented programming language' article and make sure expected title")
    @Step("Starting test testCompareArticleTitle")
    public void testCompareArticleTitle() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        //searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String artTitle = articlePageObject.getArticleTitle();


        //ArticlePageObject.takeScreenshot("article_page");

        assertEquals("We see unexpected title",
                "Java (programming language)",
                artTitle
        );
    }


    @Test
    @DisplayName("Swipe article to the footer")
    @Description("We open an article and swipe it to the footer")
    @Step("Starting test testSwipeArticle")
    public void testSwipeArticle() {
        if (Platform.getInstance().isMW()) {
            return;
        }
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        //searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        articlePageObject.swipeToFooter();
    }

}
