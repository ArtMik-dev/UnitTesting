package shop;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {
    VirtualItem virtualItem = new VirtualItem();

    @Tag("VirtualItem")
    @Test
    void sizeDiskTest() {
        double expectedSizeOn= 20000;

        virtualItem.setSizeOnDisk(expectedSizeOn);

        double actualSizeOn = virtualItem.getSizeOnDisk();

        assertEquals(actualSizeOn, expectedSizeOn, 0);
    }

}