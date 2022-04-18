import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
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
}