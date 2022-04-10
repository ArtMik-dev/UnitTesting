package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageObject extends BasePageObject{

    private final String url = "https://mail.yandex.com/";

    private By generalButton = By.cssSelector("a.button2_theme_mail-white");

    private By loginField = By.id("passp-field-login");

    public String getSignIn() {
        return driver.findElement(signIn).getText();
    }

    private By signIn = By.id("passp:sign-in");

    private By passwordField = By.id("passp-field-passwd");
    private By submitButton = By.cssSelector("button#passp\\:sign-in");
    private  By logoutButton = By.cssSelector("a.legouser__menu-item_action_exit");
    private By userNameLinkLogedIn = By.cssSelector("a.user-account_left-name>div>img");

    private By userNameText = By.cssSelector("a.user-account_left-name>span:nth-child(1)");


    public MainPageObject(WebDriver driver) {
        super(driver);
    }
    public String getUserNameLinkText(){
        return driver.findElement(userNameText).getText();
    }

    @Override
    protected String getUrl() {
        return url;
    }
    public String login(String userName, String password){
        driver.findElement(generalButton).click();
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(userName);
        driver.findElement(signIn).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();

        return userName;
    }

    public void logout() {
        driver.findElement(userNameLinkLogedIn).click();
        driver.findElement(logoutButton).click();
    }
}
