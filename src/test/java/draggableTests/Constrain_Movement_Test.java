package draggableTests;

import BaseTest.Hooks;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

// 1. Click on the Draggable button
// 2. Click on the Constrain Movement button
// 3. Drag the vertically draggable element by 100 pixels to the right and down
// 4. Verify the vertically draggable element moved only vertically
// 5. Drag the horizontally draggable element by 100 pixels to the right and down
// 6. Verify the horizontally draggable element moved only horizontally
// 7. Drag the draggable element in container wrapper by 1000 pixels to the right and 200 pixels down
// 8. Verify the draggable element in container wrapper did not move out of the container
// 9. Drag the draggable element in the box by 100 pixels to the right and down
// 10.Verify the draggable element did not move out of its parent box

public class Constrain_Movement_Test extends Hooks {

	List<int[]> locationsOfFirstElement = new ArrayList<>();

	List<int[]> locationsOfSecondElement = new ArrayList<>();

	List<int[]> locationsOfThirdElement = new ArrayList<>();

	List<int[]> locationsOfFourthElement = new ArrayList<>();

	@Test
	void testDraggableConstrainFunc() {
		pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Draggable button
		pages.getWebAutomationPage().clickOnDraggableLink();
		// 2. Click on the Constrain Movement button
		pages.getWebAutomationPage().clickOnConstrainMovementLink();

		// ------------------First Element------------------
		// Get initial location of the vertically draggable element
		locationsOfFirstElement.add(pages.getConstrainMovementPage().getVerticalDraggableLocation());
		// 3. Drag the vertically draggable element by 100 pixels to the right and down
		pages.getConstrainMovementPage().dragVerticalDraggable(100, 100);
		// Get final location of the vertically draggable element
		locationsOfFirstElement.add(pages.getConstrainMovementPage().getVerticalDraggableLocation());
		// 4. Verify the vertically draggable element moved only vertically
		assertThat(locationsOfFirstElement.get(1)[0]).as("The vertically draggable element moved horizontally")
			.isCloseTo(locationsOfFirstElement.get(0)[0], Percentage.withPercentage(1));
		/*
		 * assertEquals(locationsOfFirstElement.get(0)[0],
		 * locationsOfFirstElement.get(1)[0],
		 * "The vertically draggable element moved horizontally");
		 */
		assertThat(locationsOfFirstElement.get(1)[1]).as("The vertically draggable element didn't move vertically")
			.isGreaterThan(locationsOfFirstElement.get(0)[1]);

		// ------------------Second Element------------------
		// Get initial location of the horizontally draggable element
		locationsOfSecondElement.add(pages.getConstrainMovementPage().getHorizontalDraggableLocation());
		// 5. Drag the horizontally draggable element by 100 pixels to the right and down
		pages.getConstrainMovementPage().dragHorizontalDraggable(100, 100);
		// Get final location of the horizontally draggable element
		locationsOfSecondElement.add(pages.getConstrainMovementPage().getHorizontalDraggableLocation());
		// 6. Verify the horizontally draggable element moved only horizontally
		assertEquals(locationsOfSecondElement.get(0)[1], locationsOfSecondElement.get(1)[1],
				"The horizontally draggable element moved vertically");
		assertThat(locationsOfSecondElement.get(1)[0]).as("The horizontally draggable element didn't move horizontally")
			.isGreaterThan(locationsOfSecondElement.get(0)[0]);

		// ------------------Third Element------------------
		// Get initial location of the draggable element in container wrapper
		locationsOfThirdElement.add(pages.getConstrainMovementPage().getDraggableInsideContainerLocation());
		// 7. Drag the draggable element in container wrapper by 1000 pixels to the right
		// and 200 pixels down
		pages.getConstrainMovementPage().dragDraggableInsideContainer(1000, 200);
		// Get final location of the draggable element in container wrapper
		locationsOfThirdElement.add(pages.getConstrainMovementPage().getDraggableInsideContainerLocation());
		// Get the limits of container box
		int[] limitsOfContainer = pages.getConstrainMovementPage().getContainerWrapperLimits();
		// 8. Verify the draggable element in container wrapper did not move out of its
		// container
		assertNotEquals(locationsOfThirdElement.get(0), locationsOfThirdElement.get(1),
				"The draggable element in container wrapper didn't move");
		assertThat(locationsOfThirdElement.get(1)[0] + 90)
			.as("The draggable element in container wrapper moved out of its container on X axis")
			.isLessThan(limitsOfContainer[1]);
		assertThat(locationsOfThirdElement.get(1)[1] + 90)
			.as("The draggable element in container wrapper moved out of its container on Y axis")
			.isLessThan(limitsOfContainer[2]);

		// ------------------Fourth Element------------------
		// Get initial location of the draggable element in the box
		locationsOfFourthElement.add(pages.getConstrainMovementPage().getDraggableInsideBoxLocation());
		// 9. Drag the draggable element in the box by 100 pixels to the right and down
		pages.getConstrainMovementPage().dragDraggableInsideBox(100, 100);
		// Get final location of the draggable element in container wrapper
		locationsOfFourthElement.add(pages.getConstrainMovementPage().getDraggableInsideBoxLocation());
		// Get the limits of container box

		int[] limitsOfBox = pages.getConstrainMovementPage().getBoxInsideContainerLimits();
		// 10.Verify the draggable element did not move out of its parent box
		assertNotEquals(locationsOfFourthElement.get(0), locationsOfFourthElement.get(1),
				"The draggable element inside box didn't move");
		assertThat(locationsOfFourthElement.get(1)[0] + 90)
			.as("The draggable element inside box moved out of its container box on X axis")
			.isLessThan(limitsOfBox[1]);
		assertThat(locationsOfFourthElement.get(1)[1] + 90)
			.as("The draggable element inside box moved out of its container box on Y axis")
			.isLessThan(limitsOfBox[2]);
	}

}
