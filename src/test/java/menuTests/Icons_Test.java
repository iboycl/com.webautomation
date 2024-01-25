package menuTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.menu.Icons_Page;
import static org.testng.Assert.*;

// 1. Click on Webautomation link
// 2. Click on the Menu button
// 3. Click on the Icons button
// 4. Hover on the first menu item
// 5. Verify that its text is "Save" and back-ground color is rgba(14, 233, 80, 0.525)"
// 6. Click on the first menu item
// 7. Verify that it is not converted into selectable menu item
// 8. Hover on the fourth menu item
// 9. Verify that its text is "Print..." and back-ground color isn't "rgba(14, 233, 80, 0.525)"
// 10.Verify the fourth menu item is not clickable
// 11.Hover on the fifth menu item
// 12.Verify that it is converted into selectable menu item
public class Icons_Test extends Hooks {

	@Test
	void testIcons() {
		// 1. Click on Webautomation link
		// 2. Click on the Menu button
		pages.getWebAutomationPage().clickOnMenuLink();

		// 3. Click on the Icons button
		pages.getWebAutomationPage().clickOnIconsLink();
		Icons_Page iconsPage = pages.getIconsPage();

		// 4. Hover on the first menu item
		iconsPage.hoverOnElement(1);

		// 5. Verify that its text is "Save" and back-ground color is rgb(0, 128, 0)"
		assertEquals(iconsPage.getElementText(1),
				"Save",
				"Element text is not 'Save'");
		assertEquals(iconsPage.getBGColorOfMenuItem(1),
				"rgb(0, 128, 0)",
				"Element color is not 'rgb(0, 128, 0)'");

		// 6. Click on the first menu item
		iconsPage.clickOnElement(1);

		// 7. Verify that it is not converted into selectable menu item
		assertFalse(iconsPage.checkConvertedIntoSelectable(1), "First menu element is converted into selectable menu");

		// 8. Hover on the fourth menu item
		iconsPage.hoverOnElement(4);

		// 9. Verify that its text is "Print..." and back-ground color is "rgb(0, 0, 0)"
		assertEquals(iconsPage.getElementText(4),
				"Print...",
				"Element text is not 'Print...'");
		assertEquals(iconsPage.getBGColorOfMenuItem(4),
				"rgba(0, 0, 0, 0)",
				"Element color is not 'rgba(0, 0, 0, 0)'");

		// 10.Verify the fourth menu item is not clickable
		try {
			iconsPage.clickOnElement(4);
            fail("Element is clickable");
		} catch (RuntimeException ignored) {}


		// 11.Click on the fifth menu item
		iconsPage.clickOnElement(5);

		// 12.Verify that it is converted into selectable menu item
		assertTrue(iconsPage.checkConvertedIntoSelectable(5), "Fifth menu element is not converted into selectable menu");
	}

}
