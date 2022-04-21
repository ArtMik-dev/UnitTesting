package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseStepPage{

    @FindBy(css = "a.user-account_left-name>div>img")
    private WebElement userNameLinkLogedIn;

    @FindBy(css = "a.legouser__menu-item_action_exit")
    private WebElement logoutButton;

    @FindBy(id = "passp:sign-in")
    private WebElement signIn;

    public String getSignIn() {
        return signIn.getText();
    }


    public MainPage logout() {
        userNameLinkLogedIn.click();
        logoutButton.click();
        return new MainPage();
    }

    @Override
    protected String getUrl() {
        return url;
    }
}
