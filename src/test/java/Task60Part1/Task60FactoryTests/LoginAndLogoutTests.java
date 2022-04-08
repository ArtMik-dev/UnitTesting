package Task60Part1.Task60FactoryTests;

import Task60Part1.Task60PageFactory.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTests extends BaseStep{

    private MainPage mainPage = new MainPage(driver);

    @Test
    public void loginWithCorrectCredentials() {
        mainPage.goToUrl();
        mainPage.login("accountfortestss", "accountfortestss1!");
        String userName = mainPage.getUserNameLinkText();
        assertEquals("accountfortestss", userName);
    }

    @Test
    public void logout() {
        mainPage.goToUrl();
        mainPage.login("accountfortestss", "accountfortestss1!");
        mainPage.logout();
        String loginLinkText = mainPage.getSignIn();
        assertEquals("Log in", loginLinkText);
    }

}
