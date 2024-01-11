package pages.draggable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Constrain_Movement_Page extends BasePage {

	@FindBy(id = "draggable5")
	WebElement verticalDraggable;

	@FindBy(id = "draggable6")
	WebElement horizontalDraggable;

	@FindBy(id = "containment-wrapper")
	WebElement containmentWrapper;

	@FindBy(id = "draggable7")
	WebElement draggableInsideContainer;

	@FindBy(xpath = "//*[@id='containment-wrapper']/div[2]")
	WebElement boxInsideContainer;

	@FindBy(id = "draggable8")
	WebElement draggableInsideBox;

	public void dragVerticalDraggable(int xOffset, int yOffset) {
		actions.dragAndDropBy(verticalDraggable, xOffset, yOffset).perform();
	}

	public int[] getVerticalDraggableLocation() {
		return new int[] { verticalDraggable.getLocation().getX(), verticalDraggable.getLocation().getY() };
	}

	public void dragHorizontalDraggable(int xOffset, int yOffset) {
		actions.dragAndDropBy(horizontalDraggable, xOffset, yOffset).perform();
	}

	public int[] getHorizontalDraggableLocation() {
		return new int[] { horizontalDraggable.getLocation().getX(), horizontalDraggable.getLocation().getY() };
	}

	public int[] getContainerWrapperLimits() {
		return new int[] { containmentWrapper.getLocation().getY(),
				containmentWrapper.getLocation().getX() + containmentWrapper.getSize().width,
				containmentWrapper.getLocation().getY() + containmentWrapper.getSize().height,
				containmentWrapper.getLocation().getX() };
	}

	public void dragDraggableInsideContainer(int xOffset, int yOffset) {
		actions.dragAndDropBy(draggableInsideContainer, xOffset, yOffset).perform();
	}

	public int[] getDraggableInsideContainerLocation() {
		return new int[] { draggableInsideContainer.getLocation().getX(),
				draggableInsideContainer.getLocation().getY() };
	}

	public int[] getBoxInsideContainerLimits() {
		return new int[] { boxInsideContainer.getLocation().getY(),
				boxInsideContainer.getLocation().getX() + boxInsideContainer.getSize().width,
				boxInsideContainer.getLocation().getY() + boxInsideContainer.getSize().height,
				boxInsideContainer.getLocation().getX() };
	}

	public void dragDraggableInsideBox(int xOffset, int yOffset) {
		actions.dragAndDropBy(draggableInsideBox, xOffset, yOffset).perform();
	}

	public int[] getDraggableInsideBoxLocation() {
		return new int[] { draggableInsideBox.getLocation().getX(), draggableInsideBox.getLocation().getY() };
	}

}
