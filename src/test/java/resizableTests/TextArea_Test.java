package resizableTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 1. Click on the Resizable button
// 2. Click on the Textarea button
// 3. Get initial size of the text box
// 4. Resize the text box with corner handle
// 5. Get final size of the text box
// 6. Verify the text box's size changes
// 7. Resize the text box with right handle
// 8. Get final size of the text box
// 9. Verify the text box's size changes
// 10. Resize the text box with bottom handle
// 11. Get final size of the text box
// 12. Verify the text box's size changes

public class TextArea_Test extends Hooks {

	List<int[]> sizesOfTextArea = new ArrayList<>();

	@Test
	void testTextArea() {
		pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Resizable button
		pages.getWebAutomationPage().clickOnResizableLink();

		// 2. Click on the Textarea button
		pages.getWebAutomationPage().clickOnTextAreaLink();

		// 3. Get initial size of the text box
		sizesOfTextArea.add(pages.getTextareaPage().getTextAreaSize());

		// 4. Resize the text box with corner handle
		pages.getTextareaPage().resizeTextAreaWithCornerHandle(200, 200);

		// 5. Get final size of the text box
		sizesOfTextArea.add(pages.getTextareaPage().getTextAreaSize());

		// 6. Verify the text box's size changes for both width and height
		assertTrue(sizesOfTextArea.get(0)[0] < sizesOfTextArea.get(1)[0],
				"Width of the text box didn't increase with corner handle");
		assertTrue(sizesOfTextArea.get(0)[1] < sizesOfTextArea.get(1)[1],
				"Height of the text box didn't increase with corner handle");

		// 7. Resize the text box with right handle
		pages.getTextareaPage().resizeTextAreaWithRightHandle(100);

		// 8. Get final size of the text box
		sizesOfTextArea.add(pages.getTextareaPage().getTextAreaSize());

		// 9. Verify the text box's size changes only for width
		assertTrue(sizesOfTextArea.get(1)[0] < sizesOfTextArea.get(2)[0],
				"Width of the text box didn't increase with right handle");
		assertEquals(sizesOfTextArea.get(1)[1], sizesOfTextArea.get(2)[1],
				"Height of the text box increased with right handle");

		// 10. Resize the text box with bottom handle
		pages.getTextareaPage().resizeTextAreaWithBottomHandle(100);

		// 11. Get final size of the text box
		sizesOfTextArea.add(pages.getTextareaPage().getTextAreaSize());

		// 12. Verify the text box's size changes only for height
		assertTrue(sizesOfTextArea.get(2)[1] < sizesOfTextArea.get(3)[1],
				"Height of the text box didn't increase with bottom handle");
		assertEquals(sizesOfTextArea.get(2)[0], sizesOfTextArea.get(3)[0],
				"Width of the text box increased with bottom handle");

	}

}
