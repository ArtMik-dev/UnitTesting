package Task60Part2.Task60ObjectTests;

import Task60Part2.Task60PageObject.MainPageObject;
import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginAndLogoutObjectTests extends BaseStepObject{

    MainPageObject mainPageObject = new MainPageObject(driver);


    @Tag("Login")
    @Description("Login with correct credentials")
    @Test
    public void loginWithCorrectCredentials() {
        mainPageObject.goToUrl();
        String userName = mainPageObject.login("accountfortestss", "accountfortestss1!");
        mainPageObject.getUserNameLinkText();
        assertEquals("accountfortestss", userName);
    }

    @Tag("Logout")
    @Description("Verify logout functionality")
    @Test
    public void logout() {
        mainPageObject.goToUrl();
        mainPageObject.login("accountfortestss", "accountfortestss1!");
        mainPageObject.logout();
        String loginLinkText = mainPageObject.getSignIn();
        assertEquals("Log in", loginLinkText);
    }
}
