package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseStepPage {
    protected WebDriver driver;
    protected String url;

    public BaseStepPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract String getUrl();

    public void goToUrl(){
        driver.get(getUrl());
    }
}
