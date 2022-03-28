package selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void loginTest() {
        driver.get("https://mail.yandex.com");
        WebElement generalLoginButton = driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]"));
        generalLoginButton.click();
        WebElement username = driver.findElement(By.id("passp-field-login"));
        username.sendKeys("accountfortestss");
        WebElement loginButton = driver.findElement(By.id("passp:sign-in"));
        loginButton.click();
        WebElement password = driver.findElement(By.id("passp-field-passwd"));
        password.sendKeys("accountfortestss1!");
        WebElement loginButton2 = driver.findElement(By.id("passp:sign-in"));
        loginButton2.click();
        assertTrue(driver.findElement(By.xpath("//a/span[@class='user-account__name'][contains(text(),'accountfortestss')]"))
                .isDisplayed(), "Element isn't displayed");

    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

}


