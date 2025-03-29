package src.tests;

import libs.CoreTestCase;
import libs.Platform;
import libs.ui.*;
import libs.ui.factories.ArticlePageObjectFactory;
import libs.ui.factories.MyListsPageObjectFactory;
import libs.ui.factories.NavigationUIFactory;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static final String FOLDER_NAME = "List";
    private static final String LOGIN = "Qa1123";
    private static final String PASSWORD = "Qwerty!23";

    @Test
    public void testSaveFirstArticleToMyList() {

        String articleTitleArt = "Java (programming language)";
        //String articleTitleFirst = "Object-oriented programming language";
        String articleTitleFirst = "bject-oriented programming language";
        //String folderName = "List";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring(articleTitleFirst);


        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToMyList(FOLDER_NAME);
            articlePageObject.closeArticle();

        } else if (Platform.getInstance().isIOS())  {
            articlePageObject.addArticlesToMySaved(FOLDER_NAME);
            articlePageObject.closeArticleiOS();
        }

        if (Platform.getInstance().isMW()) {
            articlePageObject.addArticlesToMySaved(FOLDER_NAME);
            AuthorizationPageObject authorizationPageObject = new AuthorizationPageObject(driver);
            authorizationPageObject.clickAuthButton();
            authorizationPageObject.enterLoginData(LOGIN, PASSWORD);
            authorizationPageObject.submitForm();

            articlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login",
                    articleTitle,
                    articlePageObject.getArticleTitle());
        }

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.openNavigation();
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openFolderByName(FOLDER_NAME);
        } else if (Platform.getInstance().isIOS()) {
            myListsPageObject.openFolderByNameiOS(FOLDER_NAME);
         }

        myListsPageObject.swipeByArticleToDelete(articleTitleArt);
    }
}
