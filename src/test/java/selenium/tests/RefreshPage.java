package selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshPage extends BasePage{

    private final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    @FindBy(css = "#cricle-btn")
    WebElement downloadButton;

    @FindBy(css = ".percenttext")
    WebElement percentElement;

    public RefreshPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String GetURL() {
        return URL;
    }

    public void startDownload() {
        downloadButton.click();
    }

    public void waitUntilPercent(int percent) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(10));
        wait.until(driver -> percentElement.getText().equals(percent + "%"));
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public int getPercentValue() {
        String percentText = percentElement.getText();
        return Integer.valueOf(percentText.substring(0, percentText.length() - 1));
    }
}
