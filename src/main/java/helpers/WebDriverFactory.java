package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utilities.MyLogger;


public class WebDriverFactory {
    private static WebDriver driver = null;
    private static PropertiesReader browserProps;


    public static WebDriver getDriver() {
        if (driver == null) {
            browserProps = new PropertiesReader("browser-config");
            String browser = browserProps.getProperty("browser");

            if (browser.equals("Chrome")) driver = getChromeDriver();
            else if (browser.equals("Firefox")) driver = getFirefoxDriver();
            else MyLogger.severe(WebDriverFactory.class.getSimpleName(),
                        "No Valid browser name in browser-config file");
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver;
        if (Boolean.parseBoolean(browserProps.getProperty("headless"))) {
            MyLogger.info(WebDriverFactory.class.getSimpleName(), "Initializing headless Chrome driver");

            var options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("windows-size=3000,2000");

            chromeDriver = new ChromeDriver(options);
        } else {
            MyLogger.info(WebDriverFactory.class.getSimpleName(), "Initializing normal Chrome driver");

            chromeDriver = new ChromeDriver();
        }

        return new EventFiringWebDriver(chromeDriver).register(new SeleniumEventListener());
    }

    private static WebDriver getFirefoxDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver firefoxDriver;
        if (Boolean.parseBoolean(browserProps.getProperty("headless"))) {
            MyLogger.info(WebDriverFactory.class.getSimpleName(), "Initializing headless Firefox driver");

            var options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("windows-size=3000,2000");

            firefoxDriver = new FirefoxDriver(options);
        } else {
            MyLogger.info(WebDriverFactory.class.getSimpleName(), "Initializing normal Firefox driver");

            firefoxDriver = new FirefoxDriver();
        }

        return new EventFiringWebDriver(firefoxDriver).register(new SeleniumEventListener());
    }


}
