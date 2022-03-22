package parser;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.Assert;
import org.testng.AssertJUnit;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest {

    private Faker faker = new Faker();
    private final JsonParser jsonParser = new JsonParser();

    private final String fileName = String.valueOf(faker.name());
    private final String filePath = "./src/main/resources/%s.json";

    @Disabled("Disabled test")
    @Tag("JSTest")
    @Test
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
            Assert.fail("");
        }
    }

    @Tag("JSTest")
    @Test
    public void readValidTest() {
        Cart testCart = createCart();
        File file = new File(String.format(filePath, fileName));
        try{
            Gson gson = new Gson();
            Writer writer = new FileWriter(file);
            gson.toJson(testCart, writer);
            writer.close();
            JsonParser parser = new JsonParser();
            parser.readFromFile(file);
            Cart newCart = jsonParser.readFromFile(file);
            Assertions.assertAll(" ",
                    () -> assertEquals(testCart.getCartName(), newCart.getCartName()),
                    () -> assertEquals(testCart.getTotalPrice(),newCart.getTotalPrice())
            );
        }catch (IOException thrown) {
            Assertions.fail("");
        }
    }

    @Tag("JSTest")
    @ParameterizedTest
    @ValueSource(strings = {"test-cart.json", "vadim-cart.txt", "eugen-cart.json", ".artem-cart", "project-cart.json "})
    public void readInvalidTest(String fileName) {
        File file = new File(String.format(filePath, fileName));
        assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file));
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
