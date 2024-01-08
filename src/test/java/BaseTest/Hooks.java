package BaseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;
import utils.Pages;

public class Hooks {
    private static  String browser = Driver.browser;

    protected static Pages pages = new Pages();
    @BeforeAll
    public static void setUpTestEnvironment() {
        Driver.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        Driver.closeDriver();
    }
}
