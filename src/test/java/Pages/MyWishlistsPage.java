package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishlistsPage extends BasePage{

    @FindBy(className = "table")
    private WebElement wishlistsTable;

    @FindBy(xpath = "//td//*[contains(text(),'My wishlist')]")
    private WebElement autoCreatedWishlist;

    @FindBy(css = ".wishlist_delete .icon")
    private WebElement deleteWishlistButton;

    @FindBy(id = "name")
    private WebElement newWishlistNameField;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishlistButton;

    @FindBy(xpath = "//td//*[contains(text(),'View')]")
    private WebElement viewWishlistLink;


    public MyWishlistsPage openMyWishlistsPage() {
        driver.get("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
        return this;
    }

    public MyWishlistsPage checkAutoWishlistWasCreated() {
        Assertions.assertTrue(wishlistsTable.isDisplayed());
        Assertions.assertTrue(autoCreatedWishlist.isDisplayed());
        return this;
    }

    public MyWishlistsPage clickDeleteWishlistButton() {
        deleteWishlistButton.click();
        return this;
    }

    public MyWishlistsPage createNewWishlist(String wishlistName) {
        newWishlistNameField.sendKeys(wishlistName);
        saveWishlistButton.click();
        return this;
    }

    public MyWishlistsPage checkPersonalWishlistWasCreated(String wishlistName) {
        String wishlistXpath = "//td//*[contains(text(),'" + wishlistName + "')]";
        Assertions.assertTrue(driver.findElement(By.xpath(wishlistXpath)).isDisplayed());
        return this;
    }

    public MyWishlistsPage clickViewWishlistLink() {
        viewWishlistLink.click();
        return this;
    }

    public MyWishlistsPage checkProductWasAddedToWishlist(String productName) {
        String productXpath = "//p[contains(text(),'" + productName + "')]";
        Assertions.assertTrue(driver.findElement(By.xpath(productXpath)).isDisplayed());
        return this;
    }
}
