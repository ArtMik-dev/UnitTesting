package shop;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    private Faker faker = new Faker();

    @Test
    public void checkRealItemString() {
        String expectedName = String.valueOf(faker.name());
        double expectedWeight = 2;

        RealItem realItem = new RealItem();
        realItem.setName(expectedName);
        realItem.setWeight(expectedWeight);

        String expectedString = String.format("Class: class shop.RealItem; Name: %s; Price: %s; Weight: %s", expectedName,
                0.0, expectedWeight);

        assertEquals(expectedString, realItem.toString());
    }
}