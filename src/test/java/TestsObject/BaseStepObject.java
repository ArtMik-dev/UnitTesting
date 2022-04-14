package TestsObject;

import Config.DriverSingleton;
import org.junit.jupiter.api.AfterAll;

public class BaseStepObject {

    @AfterAll
    public static void destroy(){
        DriverSingleton.getInstance().closeDriver();
    }
}