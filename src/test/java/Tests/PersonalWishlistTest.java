package Tests;

import Drivers.TestWatcher;
import Pages.LoginPage;
import Pages.MyWishlistsPage;
import Pages.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(TestWatcher.class)
public class PersonalWishlistTest extends BaseStep{
    String personalWishlistName = "New wishlist",
            productName = "Printed Dress";

    @Test
    @Step("Create Wishlist and add product")
    @Description("Create Wishlist and add product")
    @Order(1)
    void createPersonalWishlist() {

        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin(getUserName())
                .enterPassword(getPassword())
                .clickSignInButton();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
        myWishlistsPage.openMyWishlistsPage();
        myWishlistsPage.createNewWishlist(personalWishlistName);
        driver.findElement(By.xpath("//a[contains(text(),'Printed Dress')]")).click();
        ProductPage productPage = new ProductPage();
        productPage.addProductToWishlist();
        myWishlistsPage.openMyWishlistsPage()
                .checkPersonalWishlistWasCreated(personalWishlistName)
                .clickViewWishlistLink()
                .checkProductWasAddedToWishlist(productName);
    }

    @Test
    @Step("Delete created Wishlist")
    @Description("Delete created Wishlist")
    @Order(2)
    void createdWishlist() {
        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin(getUserName())
                .enterPassword(getPassword())
                .clickSignInButton();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
        myWishlistsPage.openMyWishlistsPage()
                .clickDeleteWishlistButton();
        driver.switchTo().alert().accept();
    }
}
