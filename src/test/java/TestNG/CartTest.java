package TestNG;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.Cart;
import shop.RealItem;

public class CartTest {

    @Test(testName = "Check name and total price", groups = {"group2"})
       void cartNameAndPriceTest() {
        String expectedName = "test-cart";
        Cart testCart = new Cart(expectedName);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(testCart.getCartName(), expectedName);
        softAssert.assertEquals(testCart.getTotalPrice(), 0.0);
        softAssert.assertAll();
    }

    @Test(groups = "CalculateTotal")
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

        Assert.assertEquals(expectedTotal, actualTotal, 0);
    }

    @Test(groups={"deleteRealItem"})
    public void deleteRealItem(){
        Cart cart = new Cart("test-cart");
        RealItem realItem = new RealItem();
        cart.addRealItem(realItem);
        cart.deleteRealItem(realItem);
        Assert.assertTrue(cart.getTotalPrice() == 0);
    }
}