package TestNG;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParserTest {
    private final JsonParser jsonParser = new JsonParser();
    private Faker faker = new Faker();
    private final String fileName = String.valueOf(faker.name());
    private final String filePath = "./src/main/resources/%s.json";



    @Test(testName = "Write to file - empty cart", groups = { "group1" })
    public void writeEmptyCartTest() {
        Cart testCart = new Cart("test-cart");
        jsonParser.writeToFile(testCart);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cartName","test-cart");
            JSONArray realItems = new JSONArray();
            jsonObject.put("realItems",realItems);
            JSONArray virtualItems = new JSONArray();
            jsonObject.put("virtualItems",virtualItems);
            jsonObject.put("total",0.0);

            Assert.assertEquals(jsonObject, new String(Files.readAllBytes(Paths.get(String.format(filePath, fileName)))));
        } catch (IOException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(testName = "Read from file", groups = { "group2" })
    public void readValidTest() {
        Cart testCart = createCart();
        File file = new File(String.format(filePath, fileName));
        try{
            Gson gson = new Gson();
            Writer writer = new FileWriter(file);
            gson.toJson(testCart, writer);
            writer.close();
            Assertions.assertAll(" ",
                    () -> assertEquals(testCart.getCartName(), jsonParser.readFromFile(file).getCartName()),
                    () -> assertEquals(testCart.getTotalPrice(), jsonParser.readFromFile(file).getTotalPrice())
            );
        }catch (IOException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(testName = "Read from file with incorrect name", groups = { "group2" }, dataProvider = "test1")
    public void readInvalidTest(String fileName) {
        File file = new File(String.format(filePath, fileName));

        Assert.assertThrows(NoSuchFileException.class,() -> jsonParser.readFromFile(file));
    }

    @DataProvider(name = "test1")
    public Object[][] createData() {
        return new Object[][]{{"test-cart.json"}, {"vadim-cart.txt"}, {"eugen-cart.json"}, {".artem-cart"}, {"project-cart.json "}};
    }

    @AfterEach
    public void cleanUpEach() {
        try {
            Path path = FileSystems.getDefault().getPath(String.format(filePath, fileName));
            if (Files.exists(path)) {Files.delete(path);}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cart createCart() {
        Cart testCart = new Cart(fileName);

        RealItem car = new RealItem();
        car.setName(String.valueOf(faker.name()));
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName(String.valueOf(faker.name()));
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        testCart.addRealItem(car);
        testCart.addVirtualItem(disk);

        return testCart;
    }
}