package Tests;

import Pages.CreateAccountPage;
import Pages.LoginPage;
import Drivers.TestWatcher;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestWatcher.class)
public class LoginTest extends BaseStep{
    @Test
    @Step("log in test")
    @Description("log in test")
    void checkLogIn() {
        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin("accountfortestss@yandex.com").enterPassword("TestPassword!").clickSignInButton();
        CreateAccountPage accountCreationPage = new CreateAccountPage();
        accountCreationPage.checkMyAccountPageOpened().checkUserAccountName("Art Mik");
    }
}
