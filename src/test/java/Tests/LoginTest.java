package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {

    @DisplayName("Login with correct credentials")
    @ParameterizedTest
    @CsvSource({"accountfortestss,accountfortestss1!", "accountfortestss2,accountfortestss1!"})
    void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.GoToURL();
        loginPage.login(username, password);

        HomePage homePage = new HomePage(driver);

        Assertions.assertTrue(homePage.isLoggedIn());
    }
}
