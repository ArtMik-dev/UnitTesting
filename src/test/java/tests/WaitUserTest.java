package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.tests.WaitUserPage;

import java.time.Duration;


public class WaitUserTest extends BaseTest{
    
    @Test
    public void waitUser() {
        WaitUserPage waitUserPage = new WaitUserPage(driver);
        waitUserPage.GoToURL();
        By button = By.xpath("//button[@id='save']");
        By photo = By.xpath("//div[@id='loading']/img");
        driver.findElement(button).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(photo));
        Boolean userPhotoIsDisplayed = driver.findElement(photo).isDisplayed();
        Assertions.assertTrue(userPhotoIsDisplayed);
    }

}
