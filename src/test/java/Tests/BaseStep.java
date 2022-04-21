package Tests;


import Drivers.Config;
import Drivers.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseStep {

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private String userName = "accountfortestss@yandex.com";
    private String password = "TestPassword!";

    protected static WebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {
        driver = Driver.getDriver(Config.LOCALLY);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    void cleanup() {
        driver.close();
        Driver.setDriver(null);
    }
}