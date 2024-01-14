package resizableTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.assertTrue;

// 1. Click on the Resizable button
// 2. Click on the Synchronus Resize button
// 3. Resize the first element by offset
// 4. Verify the first element's size changes
// 5. Verify the second element's size changes
// 6. Resize the second element by offset
// 7. Verify the first element's size doesn't change
// 8. Verify the second element's size changes

public class Synchronus_Resize_Test extends Hooks {

	List<int[]> sizesOfFirstElement = new ArrayList<>();

	List<int[]> sizesOfSecondElement = new ArrayList<>();

	@Test
	void testDroppableAcceptFunc() {
		// pages.getHomePage().clickOnWebAutomationLink();
		// 1. Click on the Resizable button
		pages.getWebAutomationPage().clickOnResizableLink();

		// 2. Click on the Synchronus Resize button
		pages.getWebAutomationPage().clickOnSynchronusResizeLink();

		// ------------------First Element------------------

		// Get initial sizes of the elements
		sizesOfFirstElement.add(pages.getSynchronusResizePage().getFirstResizableSize());
		sizesOfSecondElement.add(pages.getSynchronusResizePage().getSecondResizableSize());

		// 3. Resize the first element by offset
		pages.getSynchronusResizePage().resizeFirstResizable(50, 50);

		// Get final sizes of the elements
		sizesOfFirstElement.add(pages.getSynchronusResizePage().getFirstResizableSize());
		sizesOfSecondElement.add(pages.getSynchronusResizePage().getSecondResizableSize());

		// 4. Verify the first element's size changes
		// Assert width
		assertTrue(sizesOfFirstElement.get(0)[0] < sizesOfFirstElement.get(1)[0],
				"First element's width didn't increase");
		// Assert height
		assertTrue(sizesOfFirstElement.get(0)[1] < sizesOfFirstElement.get(1)[1],
				"First element's height didn't increase");

		// 5. Verify the second element's size changes
		// Assert width
		assertTrue(sizesOfSecondElement.get(0)[0] < sizesOfSecondElement.get(1)[0],
				"Second element's width didn't increase");
		// Assert height
		assertTrue(sizesOfSecondElement.get(0)[1] < sizesOfSecondElement.get(1)[1],
				"Second element's height didn't increase");

		// ------------------Second Element------------------

		// 6. Resize the second element by offset
		pages.getSynchronusResizePage().resizeSecondResizable(50, 50);

		// Get final sizes of the elements
		sizesOfFirstElement.add(pages.getSynchronusResizePage().getFirstResizableSize());
		sizesOfSecondElement.add(pages.getSynchronusResizePage().getSecondResizableSize());

		// 7. Verify the first element's size doesn't change
		// Assert width
		assertTrue(sizesOfFirstElement.get(1)[0] == sizesOfFirstElement.get(2)[0], "First element's width changed");
		// Assert height
		assertTrue(sizesOfFirstElement.get(1)[1] == sizesOfFirstElement.get(2)[1], "First element's height changed");

		// 8. Verify the second element's size changes
		// Assert width
		assertTrue(sizesOfSecondElement.get(1)[0] < sizesOfSecondElement.get(2)[0],
				"Second element's width didn't increase");
		// Assert height
		assertTrue(sizesOfSecondElement.get(1)[1] < sizesOfSecondElement.get(2)[1],
				"Second element's height didn't increase");
	}

}
