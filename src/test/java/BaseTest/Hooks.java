package BaseTest;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.Pages;

public class Hooks {

	protected static Pages pages;
	protected SoftAssert softAssert = new SoftAssert();
	@BeforeTest
	@Parameters("browserType")
	public static void setUpTestEnvironment(@Optional("chrome") String browserType) {
		Driver.setDriver(browserType);
		pages = new Pages();
		pages.getHomePage().clickOnWebAutomationLink();
		if (browserType.equalsIgnoreCase("firefox")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@AfterTest
	public static void tearDown() {
		Driver.closeDriver();
	}

	public void waitSec(int sec) {
		try {
			Thread.sleep(sec * 1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
