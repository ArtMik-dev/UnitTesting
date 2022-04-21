package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverSingleton {

    private WebDriver driver;
    private static DriverSingleton DriverSingleton;

    private DriverSingleton() {

    }

    public static DriverSingleton getInstance() {
        if (DriverSingleton == null) {
            DriverSingleton = new DriverSingleton();
        }
        return DriverSingleton;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
        }
        return driver;
    }

    public void closeDriver() {
        if (DriverSingleton != null) {
            driver.close();
            DriverSingleton = null;
        }
    }
}