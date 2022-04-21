package Tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.SearchPage;
import Drivers.TestWatcher;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestWatcher.class)
public class CartTest extends BaseStep{
    String firstProduct = "Faded Short Sleeve T-shirts",
            secondProduct = "Printed Summer Dress",
            thirdProduct = "Printed Dress";

    @Test
    @Step("Add 3 products to cart")
    @Description("Add 3 products to cart")
    void addProductsToCart() {
        LoginPage loginPage = new LoginPage();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmailToLogin(getUserName())
                .enterPassword(getPassword())
                .clickSignInButton();
        SearchPage searchPage = new SearchPage();
        ProductPage productPage = new ProductPage();
        searchPage.searchProduct(firstProduct);
        productPage.openProductPage(firstProduct).addProductToCart();
        searchPage.clearSearchInput().searchProduct(secondProduct);
        productPage.openProductPage(secondProduct).addProductToCart();
        searchPage.clearSearchInput().searchProduct(thirdProduct);
        productPage.openProductPage(thirdProduct).addProductToCart();
        CartPage cartPage = new CartPage();
        cartPage.viewCart().checkTotalValue("$98.48");
    }
}
