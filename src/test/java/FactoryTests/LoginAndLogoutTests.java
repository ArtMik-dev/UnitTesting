package FactoryTests;

import PageFactory.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTests extends BaseStep{

    private MainPage mainPage = new MainPage(driver);
    public static final String ACCOUNT_NAME = "accountfortestss";
    public static final String LOGIN = "Log in";


    @Test
    public void loginWithCorrectCredentials() {
        mainPage.goToUrl();
        mainPage.login("accountfortestss", "accountfortestss1!");
        String userName = mainPage.getUserNameLinkText();
        assertEquals(ACCOUNT_NAME, userName);
    }

    @Test
    public void logout() {
        mainPage.goToUrl();
        mainPage.login("accountfortestss", "accountfortestss1!");
        mainPage.logout();
        String loginLinkText = mainPage.getSignIn();
        assertEquals(LOGIN, loginLinkText);
    }

}