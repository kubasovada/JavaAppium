package src.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import libs.CoreTestCase;
import libs.ui.SearchPageObject;
import libs.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SearchTests extends CoreTestCase {

    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Search article by title")
    @Description("We open 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testSearch")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testSearch()  {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        //searchPageObject.waitForSearchResult("Java (programming language)");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Cancel search article by title")
    @Description("We cancel search of article 'Java (programming language) article with description 'Object-oriented programming language'")
    @Step("Starting test testCancelSearch")
    @Severity(value=SeverityLevel.BLOCKER)
    public void testCancelSearch() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForCancelButtonToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelButtonToDisappear();
    }



    @Test
    @Features(value={@Feature(value="Search")})
    @DisplayName("Search result > 0")
    @Description("We search an article and have result")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value=SeverityLevel.BLOCKER)
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
    @Features(value={@Feature(value="Search")})
    @DisplayName("Search result is Empty")
    @Description("We search an article and have no result")
    @Step("Starting test testAmountOfEmptySearch")
    public void testAmountOfEmptySearch() {

        String searchLine = "asdfkkajhsdgfhg";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLabel();
        searchPageObject.assertThereIsNoResultOfSearch();
    }

}
