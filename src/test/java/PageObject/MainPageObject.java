package PageObject;

import org.openqa.selenium.By;

public class MainPageObject extends BasePageObject{

    private static final By GENERAL_BUTTON = By.cssSelector("a.button2_theme_mail-white");

    private static final By LOGIN_FIELD = By.id("passp-field-login");

    public String getSignIn() {
        return driver.findElement(SIGN_IN).getText();
    }

    private static final By SIGN_IN = By.id("passp:sign-in");

    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");
    private final static By SUBMIT_BUTTON = By.cssSelector("button#passp\\:sign-in");

    private final static By USER_NAME_TEXT = By.xpath("//span[@class='user-account__name']/following-sibling::div");

    public String getUserNameLinkText(){
        return driver.findElement(USER_NAME_TEXT).getText();
    }

    @Override
    protected String getUrl() {
        return url;
    }

    public HomePageObject login(String userName, String password){
        driver.findElement(GENERAL_BUTTON).click();
        driver.findElement(LOGIN_FIELD).clear();
        driver.findElement(LOGIN_FIELD).sendKeys(userName);
        driver.findElement(SIGN_IN).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();

        return new HomePageObject();
    }


}
