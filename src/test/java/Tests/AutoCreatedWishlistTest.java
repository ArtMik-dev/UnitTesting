package Tests;

import Drivers.TestWatcher;
import Pages.LoginPage;
import Pages.MyWishlistsPage;
import Pages.ProductPage;
import Pages.SearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

@ExtendWith(TestWatcher.class)
public class AutoCreatedWishlistTest extends BaseStep{

    @Test
    @Step("Add product to auto-created Wishlist")
    @Description("Add product to auto-created Wishlist")
    @Order(1)
    void autoCreatedWishlist() {
        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin(getUserName())
                .enterPassword(getPassword())
                .clickSignInButton();
        driver.findElement(By.className("lnk_wishlist")).click();
        MyWishlistsPage myWishlistsPage = new MyWishlistsPage();
        SearchPage searchPage = new SearchPage();
        ProductPage productPage = new ProductPage();
        searchPage.searchProduct("Faded Short Sleeve T-shirts");
        productPage.openProductPage("Faded Short Sleeve T-shirts")
                .addProductToWishlist();
        myWishlistsPage.openMyWishlistsPage()
                .checkAutoWishlistWasCreated()
                .clickViewWishlistLink();
        Assertions.assertTrue(driver.findElement(By.className("product_infos")).isDisplayed());
    }

    @Test
    @Step("Delete auto-created Wishlist")
    @Description("Delete auto-created Wishlist")
    @Order(2)
    void deleteAutoCreatedWishlist() {
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
