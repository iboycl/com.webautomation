package pages.draggable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

public class Handles_Page extends BasePage {

	@FindBy(id = "draggable13")
	WebElement firstDraggable;

	@FindBy(css = "#draggable13 > p")
	WebElement firstDraggableHandle;

	@FindBy(id = "draggable14")
	WebElement secondDraggable;

	@FindBy(css = "#draggable14 > .ui-widget-header")
	WebElement secondDraggableHandle;

	public void dragFirstDraggableWithHandle(int xOffset, int yOffset) {
		actions.dragAndDropBy(firstDraggableHandle, xOffset, yOffset).perform();
	}

	public void dragFirstDraggableWithoutHandle(int xOffset, int yOffset) {
		int locX = firstDraggable.getLocation().getX();
		int locY = firstDraggable.getLocation().getY();
		actions.moveToLocation(locX, locY)
			.clickAndHold()
			.moveToLocation(locX + xOffset, locY + yOffset)
			.release()
			.build()
			.perform();
	}

	public void dragSecondDraggableWithHandle(int xOffset, int yOffset) {
		actions.dragAndDropBy(secondDraggableHandle, xOffset, yOffset).perform();
	}

	public void dragSecondDraggableWithoutHandle(int xOffset, int yOffset) {
		int locX = secondDraggable.getLocation().getX() + 5;
		int locY = secondDraggable.getLocation().getY() + 5;
		actions.moveToLocation(locX, locY)
			.clickAndHold()
			.moveToLocation(locX + xOffset, locY + yOffset)
			.release()
			.build()
			.perform();
	}

	public int[] getLocationOfTheFirstDraggable() {
		return new int[] { firstDraggable.getLocation().getX(), firstDraggable.getLocation().getY() };
	}

	public int[] getLocationOfTheSecondDraggable() {
		return new int[] { secondDraggable.getLocation().getX(), secondDraggable.getLocation().getY() };
	}

}
