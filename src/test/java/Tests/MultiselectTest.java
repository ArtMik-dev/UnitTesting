package Tests;

import Pages.MultiselectPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiselectTest extends BaseTest{

    @Test
    public void multiselectTest() {
        MultiselectPage multiselectPage = new MultiselectPage(driver);
        multiselectPage.goToUrl();
        Select dropdown = new Select(driver.findElement(By.id("multi-select")));
        dropdown.selectByValue("California");
        dropdown.selectByValue("New York");
        dropdown.selectByValue("Pennsylvania");
        List<WebElement> selectedValues = dropdown.getAllSelectedOptions();
        List<String> selectedValuesText = selectedValues.stream().map(WebElement::getText).collect(Collectors.toList());
        List<WebElement> expectedSelectedValues = new ArrayList<>();
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='California']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='New York']")));
        expectedSelectedValues.add(driver.findElement(By.xpath("//option[@value='Pennsylvania']")));
        List<String> expectedSelectedValuesString = expectedSelectedValues.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        Assertions.assertEquals(selectedValuesText, expectedSelectedValuesString);
    }
}