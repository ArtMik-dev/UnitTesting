package PageFactory;

import Config.Config;
import Config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseStepPage {
    final WebDriver driver;
    protected String url;

    public BaseStepPage() {
        driver = DriverSingleton.getInstance().getDriver(Config.CHROME);
        PageFactory.initElements(driver, this);
    }

    protected abstract String getUrl();

    public void goToUrl(){
        driver.get(getUrl());
    }
}
