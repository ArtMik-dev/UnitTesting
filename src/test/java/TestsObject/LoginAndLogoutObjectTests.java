package TestsObject;

import PageObject.MainPageObject;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutObjectTests extends BaseStepObject{

    MainPageObject mainPageObject = new MainPageObject(driver);
    public static final String ACCOUNT_NAME = "accountfortestss";
    public static final String PASSWORD = "accountfortestss1!";
    public static final String LOGIN = "Log in";


    @Tag("Login")
    @Description("Login with correct credentials")
    @Test
    public void loginWithCorrectCredentials() {
        mainPageObject.goToUrl();
        String userName = mainPageObject.login(ACCOUNT_NAME, PASSWORD);
        mainPageObject.getUserNameLinkText();
        assertEquals(ACCOUNT_NAME, userName);
    }

    @Tag("Logout")
    @Description("Verify logout functionality")
    @Test
    public void logout() {
        mainPageObject.goToUrl();
        mainPageObject.login(ACCOUNT_NAME, PASSWORD);
        mainPageObject.logout();
        String loginLinkText = mainPageObject.getSignIn();
        assertEquals(LOGIN, loginLinkText);
    }
}
