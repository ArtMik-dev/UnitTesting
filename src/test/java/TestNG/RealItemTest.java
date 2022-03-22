package TestNG;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.RealItem;




public class RealItemTest {

    private Faker faker = new Faker();

    @Test(testName = "Verify String", groups = { "group1" })
    public void checkRealItemString() {
        String expectedName = String.valueOf(faker.name());
        double expectedWeight = 2;

        RealItem realItem = new RealItem();
        realItem.setName(expectedName);
        realItem.setWeight(expectedWeight);

        String expectedString = String.format("Class: class shop.RealItem; Name: %s; Price: %s; Weight: %s", expectedName,
                0.0, expectedWeight);

        Assert.assertEquals(expectedString, realItem.toString());
    }
}