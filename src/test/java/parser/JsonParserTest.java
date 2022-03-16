package parser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.bind.util.ISO8601Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;
import com.github.javafaker.Faker;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {

    private final JsonParser jsonParser = new JsonParser();

    private final String fileName = "test-cart";
    private final String filePath = "./src/main/resources/%s.json";

    private Faker faker = new Faker();
    String name = faker.name().fullName();

    @Disabled("Disabled test")
    @Tag("JSTest")
    @Test
    public void writeEmptyCartTest() {
        Cart testCart = new Cart(fileName);
        jsonParser.writeToFile(testCart);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("cartName","test-cart");
            JSONArray realItems = new JSONArray();
            jsonObject.put("realItems",realItems);
            JSONArray virtualItems = new JSONArray();
            jsonObject.put("virtualItems",virtualItems);
            jsonObject.put("total",0.0);
            assertEquals(jsonObject, new String(Files.readAllBytes(Paths.get(String.format(filePath, fileName)))));
        } catch (Exception ex) {
            ex.printStackTrace();
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
            assertEquals(testCart.getCartName(), jsonParser.readFromFile(file).getCartName());
            assertEquals(testCart.getTotalPrice(), jsonParser.readFromFile(file).getTotalPrice());
        }catch (IOException e) {
            e.printStackTrace();
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
