package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.tests.RefreshPage;

public class RefreshTest extends BaseTest{

    @DisplayName("Refresh test.")
    @Test
    void progressBarTest() {
        RefreshPage refreshPage = new RefreshPage(driver);
        refreshPage.GoToURL();
        refreshPage.startDownload();
        refreshPage.waitUntilPercent(50);

        Assertions.assertTrue(refreshPage.getPercentValue() >= 50);

        refreshPage.refresh();

        Assertions.assertTrue(refreshPage.getPercentValue() == 0);
    }
}
