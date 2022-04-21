package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsFactory extends WebDriverFactory {

    private WebDriver driver;

    @Override
    public WebDriver initializeDriver() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);

        return driver = new RemoteWebDriver(new URL ("https://art-mik:55502041-a1e7-4abd-94c2-e24536263871@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
    }

}
