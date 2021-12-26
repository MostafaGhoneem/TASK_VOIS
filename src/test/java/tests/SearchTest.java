package tests;

import base.BaseTest;
import helpers.TestngListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;


@Listeners(TestngListener.class)
public class SearchTest extends BaseTest {

        @Test (dataProvider = "Search-data",dataProviderClass = data_provider.DataProviders.class)
        public void GoogleSearch(String SearchQuery) {


            var homePage = new HomePage(getDriver());
            homePage.Search(SearchQuery);


            var searchPage = new SearchPage(getDriver());

            boolean EqualResults = searchPage.ResultsIsEquals();

            Assert.assertTrue(EqualResults);

        }


    }
