package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By searchElement = By.xpath("//input[@class= 'gLFyf gsfi']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }


    public HomePage Search (String text){
    guiActions.clickOn(searchElement);
    guiActions.sendTextTo(searchElement,text);
    guiActions.clickEnter(searchElement);
    return new HomePage(driver);
    }







}
