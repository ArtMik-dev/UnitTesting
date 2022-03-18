package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;




public class RealItemTest {
    @Test(testName = "Verify String", groups = { "group1" })
    public void checkRealItemString() {
        String expectedName = "name";
        double expectedWeight = 2;

        RealItem realItem = new RealItem();
        realItem.setName(expectedName);
        realItem.setWeight(2);

        String expectedString = String.format("Class: class shop.RealItem; Name: %s; Price: %s; Weight: %s", expectedName,
                0.0, expectedWeight);

        Assert.assertEquals(expectedString, realItem.toString());
    }
}