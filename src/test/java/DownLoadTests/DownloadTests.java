package DownLoadTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DownloadTests extends BaseTest{

    private static final String PATH_TO_FOLDER = System.getProperty("user.dir") + "\\src\\test\\java\\Selenium\\Files";

    private static final String START_URL = "https://file-examples.com/index.php/sample-documents-download/sample-doc-download/";

    private WebDriver driver;
    private File folder;
    private File file;
    private File[] listOfFiles;
    private boolean isFound;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        createNewFolder("src/test/java/Selenium/Files/");
    }

    @AfterEach
    void setDown() {
        driver.close();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            file.delete();
        }
    }

    @DisplayName("Download file with Chrome")
    @Test
    void fileDownloadChrome() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", PATH_TO_FOLDER);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.get(START_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='.docx']"))).click();
        //driver.findElement(By.xpath("//*[text()='Download sample DOC file']")).click();
        Thread.sleep(15000);
        checkFileInFolder(PATH_TO_FOLDER);

        Assertions.assertTrue(isFound, "Downloaded file is not found");
    }

    public void checkFileInFolder(String path) {
        folder = new File(path);
        listOfFiles = folder.listFiles();
        isFound = false;
        file = null;

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.contains("samplefile")) {
                    file = new File(fileName);
                    isFound = true;
                }
            }
        }
    }
}