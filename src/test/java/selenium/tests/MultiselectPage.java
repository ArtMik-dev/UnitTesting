package selenium.tests;

import org.openqa.selenium.WebDriver;

public class MultiselectPage extends BasePage {

    private final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    public MultiselectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String GetURL() {
        return URL;
    }
}


