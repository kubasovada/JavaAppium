package src.tests;

import libs.CoreTestCase;
import libs.ui.SearchPageObject;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch()  {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        //searchPageObject.waitForSearchResult("Java (programming language)");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCancelSearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForCancelButtonToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonToDisappear();
    }



    @Test
    public void testAmountOfNotEmptySearch() {

        String searchLine = "Linkin Park Disco";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        int amountOfSearchResults  = searchPageObject.getAmountOfFoundArticles();
        assertTrue("We found too few results",
                amountOfSearchResults > 0 );
    }


    @Test
    public void testAmountOfEmptySearch() {

        String searchLine = "asdfkkajhsdgfhg";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLabel();
        searchPageObject.assertThereIsNoResultOfSearch();
    }

}
