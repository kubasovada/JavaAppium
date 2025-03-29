package src.tests;

import libs.CoreTestCase;
import libs.ui.ArticlePageObject;
import libs.ui.SearchPageObject;
import libs.ui.factories.ArticlePageObjectFactory;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        //searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String artTitle = articlePageObject.getArticleTitle();

        assertEquals("We see unexpected title",
                "Java (programming language)",
                artTitle
        );
    }


    @Test
    public void testSwipeArticle() {

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
