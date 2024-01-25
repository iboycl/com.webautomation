package autocompleteTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.autocomplete.Multiple_Remote_Page;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

// 1. Open the browser and navigate to the page
// 2. click on web automation link
// 3. click on the auto complete button
// 4. click on the multiple and remote button
// 5. Enter "s" in the text field
// 6. Verify that the suggestion menu is not displayed
// 7. Clear the text field
// 8. Enter "sp" in the text field
// 9. Verify that "Loading suggestions..." message is displayed
// 10. Verify that the suggestion menu is displayed
// 11.Verify that the suggestions in the menu starts with sp(suggestions can be more than one)
public class Multiple_Remote_Test extends Hooks {

	@Test
	void testMultipleRemote() {
		// 1. Open the browser and navigate to the page
		// 2. click on web automation link
		// pages.getHomePage().clickOnWebAutomationLink();

		// 3. click on the auto complete button
		pages.getWebAutomationPage().clickOnAutocompleteLink();

		// 4. click on the multiple and remote button
		pages.getWebAutomationPage().clickOnMultipleRemoteLink();
		Multiple_Remote_Page multipleRemotePage = pages.getMultipleRemotePage();

		// 5. Enter "s" in the text field
		multipleRemotePage.typeInput("s");

		// 6. Verify that the suggestion menu is not displayed
		assertFalse(multipleRemotePage.isSuggestionListVisible(), "Suggestion list is visible with input 's'");

		// 7. Clear the text field
		multipleRemotePage.clearInputField();

		// 8. Enter "sp" in the text field
		multipleRemotePage.typeInput("sp");

		// 9. Verify that "Loading suggestions..." message is displayed
		assertTrue(multipleRemotePage.isLoadingTextVisible(), "Loading text is not visible with input 'sp'");

		// 10. Verify that the suggestion menu is displayed
		assertTrue(multipleRemotePage.isSuggestionListVisible(), "Suggestion list is not visible with input 'sp'");

		// 11.Verify that the suggestions in the menu starts with sp(suggestions can be
		// more than one)
		assertTrue(multipleRemotePage.checkSuggestionsStartsWith("sp"), "Suggestions don't start with correct letters");
	}

}
