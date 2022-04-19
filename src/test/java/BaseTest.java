import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseTest {

    private static final String KEY = "55502041-a1e7-4abd-94c2-e24536263871";
    private static final String URL = "https://art-mik:" + KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";


    private WebDriver driver;

    @RegisterExtension
    public SauceTestWatcher watcher = new SauceTestWatcher();

    @BeforeEach
    void setUp() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);

        driver = new RemoteWebDriver(new URL(URL), browserOptions);
    }

    @AfterEach
    void setDown() {
        driver.quit();
    }
    @Test
    public void multiselectTest() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Select dropdown = new Select(driver.findElement(By.id("multi-select")));
        dropdown.selectByValue("California");
        dropdown.selectByValue("New York");
        dropdown.selectByValue("Pennsylvania");
        List<WebElement> selectedValues = dropdown.getAllSelectedOptions();
        List<String> selectedValuesText = selectedValues.stream().map(WebElement::getText).collect(Collectors.toList());
        List<WebElement> expectedSelectedValues = new ArrayList<>();
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='California']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='New York']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='Pennsylvania']")));
        List<String> expectedSelectedValuesString = expectedSelectedValues.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        Assertions.assertEquals(selectedValuesText, expectedSelectedValuesString);
    }

    public class SauceTestWatcher implements TestWatcher {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        @Override
        public void testSuccessful(ExtensionContext context) {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
            driver.quit();
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause) {
            ((JavascriptExecutor) driver).executeScript("sauce:job-result=failed");
            driver.quit();
        }
    }
}
