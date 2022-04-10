package PageObgect;

import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
    protected WebDriver driver;
    protected String url;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract String getUrl();

    public void goToUrl(){
        driver.get(getUrl());
    }
}
