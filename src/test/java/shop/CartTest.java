package shop;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

//import static Utils.Constants.FILE_NAME_LIST;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static parser.JsonParserTest.carts;

class CartTest {

    private Faker faker = new Faker();

    @Tag("CartTest")
    @Test
    void cartNameAndPriceTest() {
        String expectedName = String.valueOf(faker.name());
        Cart testCart = new Cart(expectedName);

        Assertions.assertAll("Cart name and price after cart creation",
                () -> assertEquals(expectedName, testCart.getCartName()),
                () -> assertEquals(0, testCart.getTotalPrice())
        );
    }

    @Tag("CartTest")
    @Test
    void calculateTotalTest() {
        String expectedName = String.valueOf(faker.name());
        double itemPrice = 5;
        double TAX = 0.2;

        Cart testCart = new Cart(expectedName);
        RealItem realItem = new RealItem();
        realItem.setPrice(itemPrice);
        testCart.addRealItem(realItem);

        double expectedTotal = itemPrice + itemPrice*TAX;
        double actualTotal = testCart.getTotalPrice();

        assertEquals(expectedTotal, actualTotal, 0);
    }
    @Tag("CartTest")
    @Test
    public void deleteRealItem(){
        String expectedName = String.valueOf(faker.name());
        Cart cart = new Cart(expectedName);
        RealItem realItem = new RealItem();
        cart.addRealItem(realItem);
        cart.deleteRealItem(realItem);
        Assertions.assertEquals(0,cart.getTotalPrice());
    }
}