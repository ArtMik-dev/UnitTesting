package Drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridFactory extends WebDriverFactory {

    private WebDriver driver;

    @Override
        public WebDriver initializeDriver()throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        return driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }
}
