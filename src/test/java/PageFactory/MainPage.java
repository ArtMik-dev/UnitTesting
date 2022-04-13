package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseStepPage {

    private final String url = "https://mail.yandex.com/";

    @FindBy(css = "a.button2_theme_mail-white")
    private WebElement generalButton;

    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(id = "passp:sign-in")
    private WebElement signIn;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;
    @FindBy(css = "button#passp\\:sign-in")
    private WebElement submitButton;

    @FindBy(css = "a.legouser__menu-item_action_exit")
    private WebElement logoutButton;
    @FindBy(css = "a.user-account_left-name>div>img")
    private WebElement userNameLinkLogedIn;

    @FindBy(css = "a.user-account_left-name>span:nth-child(1)")
    private WebElement userNameText;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameLinkText() {
        return userNameText.getText();
    }

    public String getSignIn() {
        return signIn.getText();
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public void login(String userName, String password) {
        generalButton.click();
        loginField.clear();
        loginField.sendKeys(userName);
        signIn.click();

        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void logout() {
        userNameLinkLogedIn.click();
        logoutButton.click();
    }
}
