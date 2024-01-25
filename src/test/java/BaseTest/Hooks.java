package BaseTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Driver;
import utils.Pages;



public class Hooks {
	private static Logger logger = LogManager.getLogger(Hooks.class);

	protected static Pages pages;
	protected SoftAssert softAssert = new SoftAssert();
	@BeforeTest
	@Parameters("browserType")
	public static void setUpTestEnvironment(@Optional("chrome") String browserType) {
		Driver.setDriver(browserType);

		logger.info("Starting Tests");
		logger.info("Browser Type:" + browserType);
		pages = new Pages();
		pages.getHomePage().clickOnWebAutomationLink();
		logger.debug("Web Automation link clicked");
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
		logger.info("Finished Tests");
	}

	public void waitSec(int sec) {
		try {
			Thread.sleep(sec * 1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
