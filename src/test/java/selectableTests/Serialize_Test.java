package selectableTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import static org.testng.Assert.assertEquals;

// 1. Click on Selectable button
// 2. Click on Serialize button
// 3. Click on Item 5
// 4. Verify that Item 5 is selected
// 5. Verify that "You've selected: #5" is displayed
// 6. Click on Item 6
// 7. Verify that Item 6 is selected
// 8. Verify that "You've selected: #6" is displayed
// 9. Click on Item 1, Item 3 by holding down the Ctrl key
// 10. Verify that Item 1, Item 3 are selected
// 11. Verify that "You've selected: #1 #3 #6" is displayed(6 selected because Item 6 is still selected)
// 12. Click on Item 1, Item2, Item 3 by holding mouse down and dragging
// 13. Verify that Item 1, Item 2, Item 3 are selected
// 14. Verify that "You've selected: #1 #2 #3" is displayed
public class Serialize_Test extends Hooks {

	@Test
	void testSerialize() {

		pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Selectable button
		pages.getWebAutomationPage().clickOnSelectableLink();

		// 2. Click on the Serialize button
		pages.getWebAutomationPage().clickOnSerializeLink();

		// 3. Click on Item 5
		pages.getSerializePage().clickOnElement(5);

		// 4. Verify that Item 5 is selected
		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(5),
				"Selected element's back-ground color didn't change!");

		// 5. Verify that "You've selected: #5" is displayed
		assertEquals("You've selected: #5.", pages.getSerializePage().getFeedbackText(),
				"Feedback text didn't show the selected element!");

		// 6. Click on Item 6
		pages.getSerializePage().clickOnElement(6);

		// 7. Verify that Item 6 is selected
		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(6),
				"Selected element's back-ground color didn't change!");

		// 8. Verify that "You've selected: #6" is displayed
		assertEquals("You've selected: #6.", pages.getSerializePage().getFeedbackText(),
				"Feedback text didn't show the selected element!");

		// 9. Click on Item 1, Item 3 by holding down the Ctrl key
		pages.getSerializePage().clickOnElementByPressingCtrl(1);
		pages.getSerializePage().clickOnElementByPressingCtrl(3);

		// 10. Verify that Item 1, Item 3 are selected
		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(1),
				"Selected element's back-ground color didn't change!");

		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(3),
				"Selected element's back-ground color didn't change!");

		// 11. Verify that "You've selected: #1 #3 #6" is displayed(6 selected because
		// Item 6 is still selected)
		assertEquals("You've selected: #1 #3 #6.", pages.getSerializePage().getFeedbackText(),
				"Feedback text didn't show the selected elements!");

		// 12. Click on Item 1, Item2, Item 3 by holding mouse down and dragging
		pages.getSerializePage().chooseElementsByDragging(1, 2, 3);

		// 13. Verify that Item 1, Item 2, Item 3 are selected
		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(1),
				"Selected element's back-ground color didn't change!");

		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(2),
				"Selected element's back-ground color didn't change!");

		assertEquals("rgba(14, 233, 80, 0.525)", pages.getSerializePage().getSelectableElementBGColor(3),
				"Selected element's back-ground color didn't change!");

		// 14. Verify that "You've selected: #1 #2 #3" is displayed
		assertEquals("You've selected: #1 #2 #3.", pages.getSerializePage().getFeedbackText(),
				"Feedback text didn't show the selected elements!");

	}

}
