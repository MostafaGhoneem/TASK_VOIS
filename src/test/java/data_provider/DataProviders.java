package data_provider;

import helpers.ExcelReader;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Search-data")
    public static Object[][] geSearchData() {
        return new ExcelReader("search-data", "search query").getData();
    }
}
