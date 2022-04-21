package Tests;

import Pages.CreateAccountPage;
import Pages.LoginPage;
import Drivers.TestWatcher;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestWatcher.class)
public class CreateAccountTest extends BaseStep{

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            password = "TestPassword!",
            mobileNumber = faker.numerify("##########"),
            address = faker.address().fullAddress(),
            city = faker.address().city(),
            postalCode = mobileNumber = faker.numerify("#####"),
            state = "Florida";

    @Test
    @Step("Create new account")
    @Description("Create new account")
    void createNewAccount() {
        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToCreateAccount(email)
                .clickCreateAccountButton();
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPassword(password)
                .enterAddress(address)
                .enterCity(city)
                .selectState(state)
                .enterPostalCode(postalCode)
                .enterMobilePhone(mobileNumber)
                .clickRegisterButton();
        createAccountPage.checkMyAccountPageOpened()
                .checkUserAccountName(firstName + " " + lastName);
    }
}
