package BaseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;
import utils.Pages;

public class Hooks {

	private static String browser = Driver.browser;

	protected static Pages pages;

	@BeforeAll
	public static void setUpTestEnvironment() {
		pages = new Pages();
		Driver.getDriver().get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		if (browser.equalsIgnoreCase("firefox")) {
			Driver.getDriver().navigate().refresh();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@AfterAll
	public static void tearDown() {
		Driver.closeDriver();
	}

}
