package droppableTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

// 1. Click on the Droppable button
// 2. Click on the Accept button
// 3. Drag the accept-non-valid element on the droppable box
// 4. Verify the droppable box element didn't accept the accept-non-valid element
// 5. Drag the accept-valid element on the droppable box
// 6. Verify the droppable box element accepted the accept-valid element

public class Accept_Test extends Hooks {

	List<int[]> locationsOfFirstElement = new ArrayList<>();

	List<int[]> locationsOfSecondElement = new ArrayList<>();

	@Test
	void testDroppableAcceptFunc() {
		// pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Droppable button
		pages.getWebAutomationPage().clickOnDroppableLink();

		// 2. Click on the Accept button
		pages.getWebAutomationPage().clickOnAcceptLink();

		// ------------------First Element------------------

		// Get initial location of the accept-non-valid element
		locationsOfFirstElement.add(pages.getAcceptPage().getNonValidAcceptLocation());

		// 3. Drag the accept-non-valid element on the droppable box
		pages.getAcceptPage().dragNonValidAcceptElementToDroppableBox();

		// Get final location of the accept-non-valid element
		locationsOfFirstElement.add(pages.getAcceptPage().getNonValidAcceptLocation());

		// Verify the accept-non-valid element moved
		assertNotEquals(locationsOfFirstElement.get(0), locationsOfFirstElement.get(1),
				"The accept-non-valid element didn't move");

		// 4. Verify the droppable box element didn't accept the accept-non-valid element
		assertNotEquals("Dropped!", pages.getAcceptPage().getDroppableAcceptText(),
				"Droppable-box accepted the accept-non-valid element");

		// ------------------Second Element------------------

		// Get initial location of the accept-valid element
		locationsOfSecondElement.add(pages.getAcceptPage().getValidAcceptLocation());

		// 5. Drag the accept-valid element on the droppable box
		pages.getAcceptPage().dragValidAcceptElementToDroppableBox();

		// Get final location of the accept-non-valid element
		locationsOfSecondElement.add(pages.getAcceptPage().getValidAcceptLocation());

		// Verify the accept-non-valid element moved
		assertNotEquals(locationsOfSecondElement.get(0), locationsOfSecondElement.get(1),
				"The accept-valid element didn't move");

		// 6. Verify the droppable box element accepted the accept-valid element
		assertEquals("Dropped!", pages.getAcceptPage().getDroppableAcceptText(),
				"Droppable-box didn't accept the accept-valid element");

	}

}
