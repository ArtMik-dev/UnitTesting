package FactoryTests;

import Config.DriverSingleton;
import org.junit.jupiter.api.AfterAll;

public class BaseStep {

    @AfterAll
    public static void destroy(){
        DriverSingleton.getInstance().closeDriver();
    }
}