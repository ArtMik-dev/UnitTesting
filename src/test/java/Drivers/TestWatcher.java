package Drivers;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.net.MalformedURLException;
import java.util.Date;

public class TestWatcher implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Boolean testResult = context.getExecutionException().isPresent();
        if (testResult) {
            makeScreenshotOnFailure("failedTest" + new Date().getTime() + Driver.getDriver(Config.LOCALLY).getTitle());
        }
    }

    @Attachment(value = "{testName} - screenshot", type = "image/png")
    private byte[] makeScreenshotOnFailure(String testName) throws MalformedURLException {
        return ((TakesScreenshot) Driver.getDriver(Config.LOCALLY)).getScreenshotAs(OutputType.BYTES);
    }
}
