package BaseTest;

import org.testng.annotations.*;
import utils.Driver;
import utils.Pages;

public class Hooks {

	protected static Pages pages;

	@BeforeTest
	@Parameters("browserType")
	public static void setUpTestEnvironment(@Optional("chrome") String browserType) {
		Driver.setDriver(browserType);
		pages = new Pages();
		pages.getHomePage().clickOnWebAutomationLink();
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@AfterTest
	public static void tearDown() {
		Driver.closeDriver();
	}

}
