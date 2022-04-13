package selenium.tests;

import org.openqa.selenium.WebDriver;

public class WaitUserPage extends BasePage{
    private final String URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";

    public WaitUserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String GetURL() {
        return URL;
    }
}
