package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    @Tag("VirtualItem")
    @Test
    void sizeDiskTest() {

        VirtualItem virtualItem = new VirtualItem();
        double expectedSizeOn= 20000;
        virtualItem.setSizeOnDisk(expectedSizeOn);
        double actualSizeOn = virtualItem.getSizeOnDisk();
        assertEquals(actualSizeOn, expectedSizeOn, 0);
    }

    @Test
    public void checkVirtualItemString() {
        String expectedName = "name";
        double expectedSize = 200;

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName(expectedName);
        virtualItem.setSizeOnDisk(expectedSize);

        String expectedString = String.format("Class: class shop.VirtualItem; Name: %s; Price: %s; Size on disk: %s", expectedName,
                0.0, expectedSize);

        assertEquals(expectedString, virtualItem.toString());
    }
}