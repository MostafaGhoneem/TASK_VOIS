package tests;

import base.BaseTest;
import helpers.TestngListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

/**
 * this test is to Search a Query then Validate if the number of results on page 2 is equal to all the Next Pages the user want
 * (
 * You can change the Number of pages you want to assert the number of results from MAIN>Resources>test-data
 * )
 *
 */
@Listeners(TestngListener.class)
public class SearchTest extends BaseTest {

    /**
     * data Provider for the Search Query you want to enter
     * you can access it from Test>resources>Search-data.xlsx and change it
     */

        @Test (dataProvider = "Search-data",dataProviderClass = data_provider.DataProviders.class)
        public void GoogleSearch(String SearchQuery) {


            var homePage = new HomePage(getDriver());
            homePage.Search(SearchQuery);


            var searchPage = new SearchPage(getDriver());

            Assert.assertTrue(searchPage.ResultsIsEquals());

        }


    }
