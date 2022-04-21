package Pages;

import Drivers.Config;
import Drivers.Driver;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    final WebDriver driver;

    @SneakyThrows
    public BasePage() {
        driver = Driver.getDriver(Config.LOCALLY);
        PageFactory.initElements(driver, this);
    }

}
