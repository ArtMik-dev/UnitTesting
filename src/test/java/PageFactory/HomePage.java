package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseStepPage{

    WebDriver driver;

    private final String url = "https://mail.yandex.com/";

    @FindBy(css = "a.user-account_left-name>div>img")
    private WebElement userNameLinkLogedIn;

    @FindBy(css = "a.legouser__menu-item_action_exit")
    private WebElement logoutButton;

    @FindBy(id = "passp:sign-in")
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getSignIn() {
        return signIn.getText();
    }

    @Override
    protected String getUrl() {
        return url;
    }
    public HomePage logout() {
        userNameLinkLogedIn.click();
        logoutButton.click();
        return new HomePage(driver);
    }
}
