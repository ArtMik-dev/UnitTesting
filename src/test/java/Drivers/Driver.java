package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver(Config config) throws MalformedURLException {
        if (driver == null) {
            switch (config) {
                case LOCALLY:
                    return driver = new ChromeDriver();
                case SELENIUM_GRID:
                    SeleniumGridFactory seleniumGridFactory = new SeleniumGridFactory();
                    seleniumGridFactory.initializeDriver();
                case SAUCE_LABS:
                    SauceLabsFactory sauceLabsFactory = new SauceLabsFactory();
                    return driver = sauceLabsFactory.initializeDriver();
            }
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }
}

