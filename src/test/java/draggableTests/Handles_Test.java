package draggableTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Test;
import utils.Pages;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 1. Click on the Draggable button
// 2. Click on the Handles button
// 3. Drag the first draggable element by 100 pixels to the right and down by clicking on the handle
// 4. Verify the first element moved
// 5. Drag the first draggable element by 100 pixels to the right and down by not clicking on the handle
// 6. Verify the first element did not move
// 7. Drag the second draggable element by 100 pixels to the right and down by clicking on the handle
// 8. Verify the second element did not move
// 9. Drag the second draggable element by 100 pixels to the right and down by not clicking on the handle
// 10.Verify the second element moved

public class Handles_Test extends Hooks {

	List<int[]> locationsOfFirstElement = new ArrayList<>();

	List<int[]> locationsOfSecondElement = new ArrayList<>();

	void getLocationOfFirstElement() {
		int[] location = new int[2];
		location[0] = pages.getHandlesPage().getLocationOfTheFirstDraggableX();
		location[1] = pages.getHandlesPage().getLocationOfTheFirstDraggableY();
		locationsOfFirstElement.add(location);
	}

	void getLocationOfSecondElement() {
		int[] location = new int[2];
		location[0] = pages.getHandlesPage().getLocationOfTheSecondDraggableX();
		location[1] = pages.getHandlesPage().getLocationOfTheSecondDraggableY();
		locationsOfSecondElement.add(location);
	}

	@Test
	void testHandles() {

		pages.getHomePage().clickOnWebAutomationLink();

		// 1. Click on the Draggable button
		pages.getWebAutomationPage().clickOnDraggableLink();

		// 2. Click on the Handles button
		pages.getWebAutomationPage().clickOnHandlesLink();
		pages.getHandlesPage().dragFirstDraggableWithoutHandle(100, 100);

		// 3. Drag the first draggable element by 100 pixels to the right and down by
		// clicking on the handle.
		getLocationOfFirstElement();
		pages.getHandlesPage().dragFirstDraggableWithHandle(100, 100);

		// 4. Verify the first element moved
		getLocationOfFirstElement();

		assertThat(locationsOfFirstElement.get(1)).as("Element doesn't move!")
			.isNotEqualTo(locationsOfFirstElement.get(0));
		assertEquals(locationsOfFirstElement.get(0)[0] + 100, locationsOfFirstElement.get(1)[0],
				"Element doesn't move on X axis as wanted!");
		assertEquals(locationsOfFirstElement.get(0)[1] + 100, locationsOfFirstElement.get(1)[1],
				"Element doesn't move on Y axis as wanted!");

		// 5. Drag the first draggable element by 100 pixels to the right and down by not
		// clicking on the handle.
		pages.getHandlesPage().dragFirstDraggableWithoutHandle(1049, 480);

		// 6. Verify the first element did not move
		getLocationOfFirstElement();

		assertThat(locationsOfFirstElement.get(2)).as("Element still moves without handle!")
			.isEqualTo(locationsOfFirstElement.get(1));

		// 7. Drag the second draggable element by 100 pixels to the right and down by
		// clicking on the handle.
		getLocationOfSecondElement();
		pages.getHandlesPage().dragSecondDraggableWithHandle(100, 100);

		// 8. Verify the second element did not move
		getLocationOfSecondElement();
		assertThat(locationsOfSecondElement.get(1)).as("Element moves with handle!")
			.isEqualTo(locationsOfSecondElement.get(0));

		// 9. Drag the second draggable element by 100 pixels to the right and down by not
		// clicking on the handle.
		pages.getHandlesPage().dragSecondDraggableWithoutHandle(100, 100);

		// 10.Verify the second element moved
		getLocationOfSecondElement();
		assertThat(locationsOfSecondElement.get(2)).as("Element doesn't move without handle!")
			.isNotEqualTo(locationsOfSecondElement.get(1));

	}

}
