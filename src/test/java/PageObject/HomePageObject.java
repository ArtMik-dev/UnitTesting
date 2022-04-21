package PageObject;

import org.openqa.selenium.By;

public class HomePageObject extends BasePageObject{

    private final static By LOGOUT_BUTTON = By.cssSelector("a.legouser__menu-item_action_exit");
    private final static By USER_NAME_IN_LOGED_IN = By.cssSelector("a.user-account_left-name>div>img");


    @Override
    protected String getUrl() {
        return url;
    }
    public MainPageObject logout() {
        driver.findElement(USER_NAME_IN_LOGED_IN).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return new MainPageObject();
    }

}
