package Pages;

import Config.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
    protected WebDriver driver;
    protected String url = "https://mail.yandex.com/";

    public BasePageObject() {

        driver = DriverSingleton.getInstance().getDriver();
    }

    protected abstract String getUrl();

    public void goToUrl(){
        driver.get(getUrl());
    }
}