package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject extends BasePageObject {

    private final String url = "https://mail.yandex.com/";

    private static final By GENERAL_BUTTON = By.cssSelector("a.button2_theme_mail-white");

    private static final By LOGIN_FIELD = By.id("passp-field-login");

    public String getSignIn() {
        return driver.findElement(SIGN_IN).getText();
    }

    private static final By SIGN_IN = By.id("passp:sign-in");

    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final static By SUBMIT_BUTTON = By.cssSelector("button#passp\\:sign-in");
    private final static By LOGOUT_BUTTON = By.cssSelector("a.legouser__menu-item_action_exit");
    private final static By USER_NAME_IN_LOG_IN = By.cssSelector("a.user-account_left-name>div>img");

    private final static By USER_NAME_TEXT = By.cssSelector("a.user-account_left-name>span:nth-child(1)");


    public MainPageObject(WebDriver driver) {
        super(driver);
    }
    public String getUserNameLinkText(){
        return driver.findElement(USER_NAME_TEXT).getText();
    }

    @Override
    protected String getUrl() {
        return url;
    }
    public String login(String userName, String password){
        driver.findElement(GENERAL_BUTTON).click();
        driver.findElement(LOGIN_FIELD).clear();
        driver.findElement(LOGIN_FIELD).sendKeys(userName);
        driver.findElement(SIGN_IN).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();

        return userName;
    }

    public void logout() {
        driver.findElement(USER_NAME_IN_LOG_IN).click();
        driver.findElement(LOGOUT_BUTTON).click();
    }
}