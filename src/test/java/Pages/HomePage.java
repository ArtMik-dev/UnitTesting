package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@aria-label='Log out']")
    WebElement logoutLink;

    @FindBy(className = "PSHeader-User")
    WebElement accountName;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public void logout() {
        accountName.click();
        logoutLink.click();
    }

    public Boolean isLoggedIn() {

        try {
            return accountName.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
