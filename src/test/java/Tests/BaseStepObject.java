package Tests;

import Config.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.aspectj.util.FileUtil.copyFile;

public class BaseStepObject {

    @AfterEach
    void takeScreenShoot() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File screenShot = ((TakesScreenshot) DriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            copyFile(screenShot, new File("./target/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}