package Tests;

import Pages.AlertPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertTests extends BaseTest{

    public static final String BY_XPATH = "//p[@id='confirm-demo']//preceding-sibling::button";
    public static final String SEND_KEYS = "Test";



    @Test
    public void acceptAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.goToUrl();
        By button = By.xpath(BY_XPATH);
        driver.findElement(button).click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void declineAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.goToUrl();
        By button = By.xpath(BY_XPATH);
        driver.findElement(button).click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }


    @Test
    public void sendDataToAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.goToUrl();
        By buttonClickForPromptText = By.xpath("//p[@id='prompt-demo']//preceding-sibling::button");
        driver.findElement(buttonClickForPromptText).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(SEND_KEYS);
        alert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assertions.assertEquals("You have entered 'Test' !", actualText);
    }
}
