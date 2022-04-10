package FactoryTests;

import Config.Config;
import Config.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseStep {

    static WebDriver driver;

    @BeforeAll
    public static void initDriver() {
        driver = DriverSingleton.getInstance().getDriver(Config.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void takeScreenShoot() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";
        File screenShot = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File("D:\\Screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @AfterAll
        public static void destroy() {
            driver.close();
            driver.quit();
        }
    }
