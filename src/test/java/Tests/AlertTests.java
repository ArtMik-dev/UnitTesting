package Tests;

import Pages.AlertPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertTests extends BaseTest{

    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    @BeforeEach
    public void setUp() {
        super.setup(URL);
    }

    @Test
    public void acceptAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.GoToURL();
        By button = By.xpath("//p[@id='confirm-demo']//preceding-sibling::button");
        driver.findElement(button).click();
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed OK!", actualText);
    }

    @Test
    public void declineAlert() {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.GoToURL();
        By button = By.xpath("//p[@id='confirm-demo']//preceding-sibling::button");
        driver.findElement(button).click();
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
        Assertions.assertEquals("You pressed Cancel!", actualText);
    }



    @Test
    public void sendDataToAlert() throws InterruptedException {
        AlertPage alertPage = new AlertPage(driver);
        alertPage.GoToURL();
        By buttonClickForPromptText = By.xpath("//p[@id='prompt-demo']//preceding-sibling::button");
        driver.findElement(buttonClickForPromptText).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        String actualText = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Thread.sleep(2000);
        Assertions.assertEquals("You have entered 'Test' !", actualText);
    }
}