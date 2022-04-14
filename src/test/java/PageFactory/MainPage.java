package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseStepPage {

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


    @FindBy(css = "a.user-account_left-name>div>img")
    private WebElement userNameLinkLogedIn;

    @FindBy(xpath = "//span[@class='user-account__name']/following-sibling::div")
    private WebElement userNameText;

    public WebElement getUserNameLinkText() {
        return userNameText;
    }

    public HomePage login(String userName, String password) {
        generalButton.click();
        loginField.clear();
        loginField.sendKeys(userName);
        signIn.click();

        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage();
    }

    @Override
    protected String getUrl() {
        return url;
    }
}