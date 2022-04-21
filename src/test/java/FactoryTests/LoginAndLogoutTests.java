package FactoryTests;

import PageFactory.HomePage;
import PageFactory.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTests extends BaseStep{

    private MainPage mainPage = new MainPage();

    public static final String ACCOUNT_NAME = "accountfortestss";
    public static final String LOGIN = "Log in";
    public static final String PASSWORD = "accountfortestss1!";


    @Test
    public void loginWithCorrectCredentials() {
        mainPage.goToUrl();
        mainPage.login(ACCOUNT_NAME, PASSWORD);
        String userName = mainPage.getUserNameLinkText();
        Assertions.assertEquals(ACCOUNT_NAME, userName," ");
    }

    @Test
    public void logout() {
        mainPage.goToUrl();
        HomePage homePage = mainPage.login(ACCOUNT_NAME, PASSWORD);
        homePage.logout();
        String loginLinkText = homePage.getSignIn();
        assertEquals(LOGIN, loginLinkText);
    }
}