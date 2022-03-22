package shop;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    private Faker faker = new Faker();

    @Test
    public void checkVirtualItemString() {
        String expectedName = String.valueOf(faker.name());
        double expectedSize = 200;

        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName(expectedName);
        virtualItem.setSizeOnDisk(expectedSize);

        String expectedString = String.format("Class: class shop.VirtualItem; Name: %s; Price: %s; Size on disk: %s", expectedName,
                0.0, expectedSize);

        assertEquals(expectedString, virtualItem.toString());
    }
}