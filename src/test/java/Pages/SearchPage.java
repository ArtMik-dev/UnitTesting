package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    public SearchPage searchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchInput.submit();
        return this;
    }

    public SearchPage clearSearchInput() {
        searchInput.clear();
        return this;
    }

}
