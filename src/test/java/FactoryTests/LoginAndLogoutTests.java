package FactoryTests;

import PageFactory.HomePage;
import PageFactory.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutTests extends BaseStep{

    private MainPage mainPage = new MainPage(driver);
    private HomePage homePage = new HomePage(driver);
    public static final String ACCOUNT_NAME = "accountfortestss";
    public static final String LOGIN = "Log in";
    public static final String PASSWORD = "accountfortestss1!";


    @Test
    public void loginWithCorrectCredentials() {
        mainPage.goToUrl();
        mainPage.login(ACCOUNT_NAME, PASSWORD);
        String userName = mainPage.getUserNameLinkText();
        assertEquals(ACCOUNT_NAME, userName);
    }

    @Test
    public void logout() {
        mainPage.goToUrl();
        mainPage.login(ACCOUNT_NAME, PASSWORD);
        homePage.logout();
        String loginLinkText = homePage.getSignIn();
        assertEquals(LOGIN, loginLinkText);
    }
}