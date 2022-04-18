package DownLoadTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DownloadTests extends BaseTest{

    private static final String PATH_TO_FOLDER = System.getProperty("user.dir") + "\\src\\test\\java\\Selenium\\Files";

    private static final String START_URL = "https://www.learningcontainer.com/sample-pdf-files-for-testing/";
    private static final String PDF_FIRST = "//a[contains(@data-downloadurl, 'sample-pdf-file-for-testing')]";

    private WebDriver driver;
    private File folder;
    private boolean isFound;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        createNewFolder("src/test/java/Selenium/Files/");
    }

    @AfterEach
    void setDown() {
        driver.close();
        File path = new File(PATH_TO_FOLDER);
        File[] files = path.listFiles();
        for (File file : files) {
            file.delete();
        }
    }

    @DisplayName("Download file with Chrome")
    @Test
    void fileDownloadChrome() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", PATH_TO_FOLDER);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get(START_URL);

        driver.findElement(By.cssSelector("div#ezmobfooter>center>div>span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(@data-cc-event, 'click:dismiss')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath(PDF_FIRST)).click();

        File file = new File(PATH_TO_FOLDER);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofMillis(100));
        wait.until( x -> file.exists());
        checkFileInFolder(PATH_TO_FOLDER);

        Assertions.assertTrue(isFound, "Downloaded file is not found");
    }

    @DisplayName("Download file with Firefox")
    @Test
    void fileDownloadFirefox() throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("pdfjs.disabled", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        options.addPreference("browser.download.manager.showWhenStarting", false);
        options.addPreference("browser.download.dir", PATH_TO_FOLDER);
        options.addPreference("browser.download.folderList", 2);

        driver = new FirefoxDriver(options);
        driver.get(START_URL);

        driver.findElement(By.cssSelector("div#ezmobfooter>center>div>span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(@data-cc-event, 'click:dismiss')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath(PDF_FIRST)).click();

        File file = new File(PATH_TO_FOLDER);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofMillis(100));
        wait.until( x -> file.exists());
        checkFileInFolder(PATH_TO_FOLDER);

        Assertions.assertTrue(isFound, "Downloaded file is not found");
    }

    public void checkFileInFolder(String path) {
        folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null)
        isFound = true;
    }
}