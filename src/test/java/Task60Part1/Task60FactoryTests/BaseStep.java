package Task60Part1.Task60FactoryTests;

import Config.Config;
import Config.DriverSingleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseStep {

    static WebDriver driver;

    @BeforeAll
    public static void initDriver(){
        driver = DriverSingleton.getInstance().getDriver(Config.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void destroy(){
        driver.close();
        driver.quit();
    }
}
