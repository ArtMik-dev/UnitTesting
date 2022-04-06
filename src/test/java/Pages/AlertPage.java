package Pages;
import org.openqa.selenium.WebDriver;


public class AlertPage extends BasePage {

        private final String url = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

        public AlertPage(WebDriver driver) {
            super(driver);
        }

        @Override
        protected String getUrl() {
            return url;
        }
    }

