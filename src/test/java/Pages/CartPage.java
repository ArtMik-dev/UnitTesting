package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//*[contains(text(),'Cart')]")
    private WebElement viewCartButton;

    @FindBy(id = "total_price")
    private WebElement totalPriceValue;

    public CartPage viewCart() {
        viewCartButton.click();
        return this;
    }

    public CartPage checkTotalValue(String expectedTotal) {
        Assertions.assertEquals(expectedTotal, totalPriceValue.getText());
        return this;
    }
}
