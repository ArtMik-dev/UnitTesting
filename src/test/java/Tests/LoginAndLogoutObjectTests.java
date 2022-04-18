package Tests;

import Pages.MainPageObject;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)

public class LoginAndLogoutObjectTests extends BaseStepObject{

    MainPageObject mainPageObject = new MainPageObject();
    public static final String ACCOUNT_NAME = "accountfortestss";
    public static final String ACCOUNT_NAME_INCORRECT = "accountfortestsssss";
    public static final String PASSWORD = "accountfortestss1!";
    public static final String LOGIN = "Log in";


    @Tag("Login")
    @Feature(value = "Login")
    @Description("Login with correct credentials")
    @TmsLink(value = "ST-01")
    @Test
    public void loginWithCorrectCredentials() {
        mainPageObject.goToUrl();
        String userName = mainPageObject.login(ACCOUNT_NAME, PASSWORD);
        mainPageObject.getUserNameLinkText();
        assertEquals(ACCOUNT_NAME, userName);
    }

    @Tag("Logout")
    @Feature(value = "Logout")
    @Description("Verify logout functionality")
    @TmsLink(value = "ST-02")
    @Test
    public void logout() {
        mainPageObject.goToUrl();
        mainPageObject.login(ACCOUNT_NAME, PASSWORD);
        mainPageObject.logout();
        String loginLinkText = mainPageObject.getSignIn();
        assertEquals(LOGIN, loginLinkText);
    }

    @Tag("Login")
    @Feature(value = "Login")
    @Description("Login with incorrect credentials")
    @TmsLink(value = "ST-03")
    @Test
    public void loginWithInCorrectCredentials() {
        mainPageObject.goToUrl();
        String userName = mainPageObject.login(ACCOUNT_NAME_INCORRECT, PASSWORD);
        mainPageObject.getUserNameLinkText();
        assertEquals(ACCOUNT_NAME, userName);
        takeScreenShoot();
    }
}