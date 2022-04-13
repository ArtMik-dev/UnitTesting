package selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void locators() {
        driver.get("https://mail.yandex.com");

        driver.findElement(By.id("mobile"));

        driver.findElement(By.className("button2__text"));

        driver.findElement(By.xpath("//*[@class='Tile-Title' and contains(text(), 'Secure')]"));

        driver.findElement(By.linkText("Help and support"));

        driver.findElement(By.partialLinkText("support"));

        driver.findElement(By.tagName("div"));

        driver.findElement(By.name("google"));

        driver.findElement(By.cssSelector("#index-page-container .Header"));
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}

