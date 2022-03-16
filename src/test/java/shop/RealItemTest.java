package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {


    @Tag("RealItem")
    @Test
    void weightTest() {
        RealItem realItem = new RealItem();
        double expectedWeight = 2;
        realItem.setWeight(expectedWeight);
        double actualWeight = realItem.getWeight();
        assertEquals(actualWeight, expectedWeight, 0);
    }

    @Test
    public void checkRealItemString() {
        String expectedName = "name";
        double expectedWeight = 2;

        RealItem realItem = new RealItem();
        realItem.setName(expectedName);
        realItem.setWeight(2);

        String expectedString = String.format("Class: class shop.RealItem; Name: %s; Price: %s; Weight: %s", expectedName,
                0.0, expectedWeight);

        assertEquals(expectedString, realItem.toString());
    }
}