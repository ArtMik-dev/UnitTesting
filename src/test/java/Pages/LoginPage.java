package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private final String url = "https://mail.yandex.com/";

    @FindBy(css = "a.button2_theme_mail-white")
    WebElement generalLoginButton;

    @FindBy(id = "passp:sign-in")
    WebElement logInButton;

    @FindBy(xpath = "//div[@class = 'passp-login-form']//input[@name= 'login']")
    WebElement usernameField;

    @FindBy(id = "passp-field-passwd")
    WebElement passwordField;

    @FindBy(className = "PSHeader-User")
    WebElement accountName;
    @FindBy(css = "aa.user-account_left-name>span:nth-child(1)")
    WebElement clickUserNameLink;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public void login(String username, String password) {

        generalLoginButton.click();

        usernameField.clear();
        usernameField.sendKeys(username);
        logInButton.click();

        passwordField.clear();
        passwordField.sendKeys(password);

        logInButton.click();

        HomePage homePage = new HomePage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(driver -> homePage.isLoggedIn());
    }

}

