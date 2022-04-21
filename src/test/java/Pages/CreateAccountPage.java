package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage{

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateField;

    @FindBy(id = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "id_country")
    private WebElement coutryDropdown;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@class='page-heading' and contains(text(), 'My account')]")
    private WebElement myAccountPageTitle;

    @FindBy(className = "account")
    private WebElement userAccountName;


    public CreateAccountPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public CreateAccountPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public CreateAccountPage enterAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public CreateAccountPage enterCity(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public CreateAccountPage selectState(String state) {
        Select stateDropdown = new Select(stateField);
        stateDropdown.selectByVisibleText(state);
        return this;
    }

    public CreateAccountPage enterPostalCode(String city) {
        postalCodeField.sendKeys(city);
        return this;
    }

    public CreateAccountPage enterMobilePhone(String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
        return this;
    }

    public CreateAccountPage enterAddressAlias(String addressAlias) {
        addressAliasField.sendKeys(addressAlias);
        return this;
    }

    public CreateAccountPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public CreateAccountPage checkMyAccountPageOpened() {
        Assertions.assertTrue(myAccountPageTitle.isDisplayed());
        return this;
    }

    public CreateAccountPage checkUserAccountName(String value) {
        Assertions.assertEquals(value, driver.findElement(By.className("account")).getText());
        return this;
    }
}
