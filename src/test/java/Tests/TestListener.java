package Tests;

import Config.DriverSingleton;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TestListener implements TestWatcher {

    private String browserName;
    private String browserVersion;

    @Attachment(value = "{name}", type = "image/png")
    private byte[] captureScreenshot(String name) {
        return ((TakesScreenshot) DriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void getBrowserCapabilities() {
        Capabilities capabilities = ((RemoteWebDriver) DriverSingleton.getInstance().getDriver()).getCapabilities();
        browserName = capabilities.getBrowserName().toLowerCase();
        browserVersion = capabilities.getBrowserVersion().toString();
    }

    public void setAllureEnvironment(String browserName, String browserVersion) {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", browserName)
                        .put("Browser.Version", browserVersion)
                        .build());
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        getBrowserCapabilities();
        captureScreenshot(extensionContext.getDisplayName());
        setAllureEnvironment(browserName, browserVersion);
        System.out.println(browserName + " " + browserVersion);
        DriverSingleton.getInstance().closeDriver();
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        DriverSingleton.getInstance().closeDriver();
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        DriverSingleton.getInstance().closeDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        DriverSingleton.getInstance().closeDriver();
    }
}
