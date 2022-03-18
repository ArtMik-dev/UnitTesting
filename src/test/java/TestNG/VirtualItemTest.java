package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.VirtualItem;


public class VirtualItemTest {
    @Test(testName = "Verify String", groups = { "group1" })
    public void checkVirtualItemString() {
        String expectedName = "name";
        double expectedSize = 200;

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName(expectedName);
        virtualItem.setSizeOnDisk(expectedSize);

        String expectedString = String.format("Class: class shop.VirtualItem; Name: %s; Price: %s; Size on disk: %s", expectedName,
                0.0, expectedSize);

        Assert.assertEquals(expectedString, virtualItem.toString());
    }
}