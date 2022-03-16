package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

//import static Utils.Constants.FILE_NAME_LIST;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static parser.JsonParserTest.carts;

class CartTest {

    @Tag("CartTest")
    @Test
    void cartNameAndPriceTest() {
        String expectedName = "test-cart";
        Cart testCart = new Cart(expectedName);

        Assertions.assertAll("Cart name and price after cart creation",
                () -> assertEquals(expectedName, testCart.getCartName()),
                () -> assertEquals(0, testCart.getTotalPrice())
        );
    }

    @Tag("CartTest")
    @Test
    void calculateTotalTest() {
        String expectedName = "test-cart";
        double itemPrice = 5;
        double TAX = 0.2;

        Cart testCart = new Cart(expectedName);
        RealItem realItem = new RealItem();
        realItem.setPrice(itemPrice);
        testCart.addRealItem(realItem);

        double expectedTotal = itemPrice + itemPrice*TAX;
        double actualTotal = testCart.getTotalPrice();

        assertEquals( expectedTotal, actualTotal, 0);
    }
    @Tag("CartTest")
    @Test
    public void deleteRealItem(){
        Cart cart = new Cart("test-cart");
        RealItem realItem = new RealItem();
        cart.addRealItem(realItem);
        cart.deleteRealItem(realItem);
        Assert.assertTrue(cart.getTotalPrice() == 0);
    }
}