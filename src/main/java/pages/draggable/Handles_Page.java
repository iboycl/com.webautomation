package pages.draggable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

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
		actions.moveToLocation(firstDraggable.getLocation().getX(), firstDraggable.getLocation().getY())
			.clickAndHold()
			.moveToLocation(xOffset, yOffset)
			.release()
			.build()
			.perform();
	}

	public void dragSecondDraggableWithHandle(int xOffset, int yOffset) {
		actions.dragAndDropBy(secondDraggableHandle, xOffset, yOffset).perform();
	}

	public void dragSecondDraggableWithoutHandle(int xOffset, int yOffset) {
		int locX = secondDraggable.getLocation().getX();
		int locY = secondDraggable.getLocation().getY();
		actions.moveToLocation(locX, locY)
			.clickAndHold()
			.moveToLocation(locX + xOffset, locY + yOffset)
			.release()
			.build()
			.perform();
	}

	public int getLocationOfTheFirstDraggableX() {
		return firstDraggable.getLocation().getX();
	}

	public int getLocationOfTheFirstDraggableY() {
		return firstDraggable.getLocation().getY();
	}

	public int getLocationOfTheSecondDraggableX() {
		return secondDraggable.getLocation().getX();
	}

	public int getLocationOfTheSecondDraggableY() {
		return secondDraggable.getLocation().getY();
	}

}
