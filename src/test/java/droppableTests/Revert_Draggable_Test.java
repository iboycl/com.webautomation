package droppableTests;

import BaseTest.Hooks;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

// 1. Click on the Droppable button
// 2. Click on the Revert draggable position button
// 3. Drag the first element by offset
// 4. Verify the droppable box element's color changes while dragging the element
// 5. Verify the first element doesn't revert to its initial location if it isn't dropped on droppable box
// 6. Drag and drop the first element on the droppable box
// 7. Verify the first element reverts to its initial location if it is dropped on droppable box
// 8. Drag the second element by offset
// 9. Verify the droppable box element's color changes while dragging the element
// 10. Verify the second element reverts to its initial location if it isn't dropped on droppable box
// 11. Drag and drop the second element on the droppable box
// 12. Verify the second element doesn't revert to its initial location if it is dropped on droppable box
// 13. Verify the droppable box element's color changes permanently after dropping the second element on it

public class Revert_Draggable_Test extends Hooks {

	List<int[]> locationsOfFirstElement = new ArrayList<>();

	List<int[]> locationsOfSecondElement = new ArrayList<>();

	@Test
	void testDroppableAcceptFunc() {
		pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Droppable button
		pages.getWebAutomationPage().clickOnDroppableLink();

		// 2. Click on the Revert draggable position button
		pages.getWebAutomationPage().clickOnRevertDraggableLink();

		// ------------------First Element------------------

		// Get initial location of the first element
		locationsOfFirstElement.add(pages.getRevertDraggablePage().getRevertDraggableFirstLocation());

		// 3. Drag the first element by offset
		pages.getRevertDraggablePage().dragRevertDraggableFirstByOffset(55, 55);

		// 4. Verify the droppable box element's color changes while dragging the element
		assertEquals("rgb(0, 128, 0)", pages.getRevertDraggablePage().getDroppableRevertDraggableBGColor(),
				"Droppable-box back-ground color doesn't change while dragging the first element!");

		// Release the first element
		pages.getRevertDraggablePage().releaseRevertDraggableFirst();

		// Get final location of the first element
		locationsOfFirstElement.add(pages.getRevertDraggablePage().getRevertDraggableFirstLocation());

		// 5. Verify the first element doesn't revert to its initial location if it isn't
		// dropped on droppable box
		assertNotEquals(locationsOfFirstElement.get(0), locationsOfFirstElement.get(1),
				"The first element reverted back to its initial location");

		// 6. Drag and drop the first element on the droppable box
		pages.getRevertDraggablePage().dragRevertDraggableFirstToDroppableBox();

		// Get final location of the first element
		locationsOfFirstElement.add(pages.getRevertDraggablePage().getRevertDraggableFirstLocation());

		// 7. Verify the first element reverts to its initial location if it is dropped on
		// droppable box
		assertNotEquals(locationsOfFirstElement.get(1), locationsOfFirstElement.get(2),
				"The first element didn't revert back to its initial location");

		// ------------------Second Element------------------
		// Get initial location of the second element
		locationsOfSecondElement.add(pages.getRevertDraggablePage().getRevertDraggableSecondLocation());

		// 8. Drag the second element by offset
		pages.getRevertDraggablePage().dragRevertDraggableSecondByOffset(400, 400);

		// 9. Verify the droppable box element's color changes while dragging the element
		assertEquals("rgb(0, 128, 0)", pages.getRevertDraggablePage().getDroppableRevertDraggableBGColor(),
				"Droppable-box back-ground color doesn't change while dragging the second element!");

		// Release the second element
		pages.getRevertDraggablePage().releaseRevertDraggableSecond();

		// Get final location of the second element
		locationsOfSecondElement.add(pages.getRevertDraggablePage().getRevertDraggableSecondLocation());

		// 10. Verify the second element reverts to its initial location if it isn't
		// dropped on droppable box
		assertThat(locationsOfSecondElement.get(1)[0])
			.as("The second element didn't revert back to its initial location")
			.isCloseTo(locationsOfSecondElement.get(0)[0], Percentage.withPercentage(1));
		assertThat(locationsOfSecondElement.get(1)[1])
			.as("The second element didn't revert back to its initial location")
			.isCloseTo(locationsOfSecondElement.get(0)[1], Percentage.withPercentage(1));

		// 11. Drag and drop the second element on the droppable box
		pages.getRevertDraggablePage().dragRevertDraggableSecondToDroppableBox();

		// Get final location of the second element
		locationsOfSecondElement.add(pages.getRevertDraggablePage().getRevertDraggableSecondLocation());

		// 12. Verify the second element doesn't revert to its initial location if it is
		// dropped on droppable box
		assertNotEquals(locationsOfSecondElement.get(1), locationsOfSecondElement.get(2),
				"The second element reverted back to its initial location");

		// 13. Verify the droppable box element's color and text changes permanently after
		// dropping the second element on it

		// Color
		assertEquals("rgba(14, 233, 80, 0.525)", pages.getRevertDraggablePage().getDroppableRevertDraggableBGColor(),
				"Droppable-box back-ground color doesn't change when the second element is dropped on it");

		// Text
		assertEquals("Dropped!", pages.getRevertDraggablePage().getDroppableRevertDraggableText(),
				"Droppable-box's text doesn't change when the second element is dropped on it!");
	}

}
