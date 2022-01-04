package pages;

import helpers.GUIActions;
import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By nextElement = By.xpath("//span[contains(text(),'Next')]");
    private final By searchResults =  By.cssSelector(".g");
    private List<Integer> ListOfResults = new ArrayList<>();



    public SearchPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }


    public void ScrollAndClickNext()  {
        guiActions.clickOn(nextElement);
    }

    public List<Integer> NumOfEachRound(){

        var NumberOfRounds = Integer.parseInt(new PropertiesReader("test-data")
                .getProperty("NumOfRounds"));

        var ListSize = guiActions.getNumberofElements(searchResults);


        for(int i=0; i <NumberOfRounds; i++)
        {
            ScrollAndClickNext();
            ListOfResults.add(ListSize);
        }
        return ListOfResults;
    }

    public boolean ResultsIsEquals(){
       NumOfEachRound();
        for (Integer r : ListOfResults) {
            if (Objects.equals(ListOfResults.get(0), r))
                return true;
        }
        return false;
    }

}




