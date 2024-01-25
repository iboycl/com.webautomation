package autocompleteTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.autocomplete.Accent_Folding_Page;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

// 1. Open the browser and navigate to the page
// 2. Click on web automation link
// 3. Click on the auto complete button
// 4. Click on the Accent Folding button
// 5. Enter "Jo" in the text field
// 6. Verify that the suggestions include "John" and "Jörn"
// 7. Clear the text field
// 8. Enter "Jö" in the text field
// 9. Verify that the suggestions include "Jö"
// 10.Verify that the suggestion menu is displayed
// 11.Verify that the suggestions in the menu starts with sp(suggestions can be more than one)
public class Accent_Folding_Test extends Hooks {

	@Test
	void testAccentFolding() {
		// 1. Open the browser and navigate to the page
		// 2. click on web automation link
		// 3. click on the auto complete button
		pages.getWebAutomationPage().clickOnAutocompleteLink();

		// 4. click on the Accent Folding button
		pages.getWebAutomationPage().clickOnAccentFoldingLink();
		Accent_Folding_Page accentFoldingPage = pages.getAccentFoldingPage();

		// 5. Enter "Jo" in the text field
		accentFoldingPage.typeInput("Jo");

		// 6. Verify that the suggestions include "John" and "Jörn"
		assertTrue(accentFoldingPage.checkSuggestionsContain("Jo"), "Suggestions don't contain 'Jo'");
		assertTrue(accentFoldingPage.checkSuggestionsContain("Jö"), "Suggestions don't contain 'Jö'");

		// 7. Clear the text field
		accentFoldingPage.clearInputField();

		// 8. Enter "Jö" in the text field
		accentFoldingPage.typeInput("Jö");

		// 9. Verify that the suggestions include "Jö"
		assertTrue(accentFoldingPage.checkSuggestionsContain("Jö"), "Suggestions don't contain 'Jö'");
	}

}
