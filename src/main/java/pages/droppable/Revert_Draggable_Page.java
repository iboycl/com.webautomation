package pages.droppable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Revert_Draggable_Page extends BasePage {

	@FindBy(id = "draggable-revert-draggable")
	private WebElement draggableRevertDraggableFirst;

	@FindBy(id = "draggable2-revert-draggable")
	private WebElement draggableRevertDraggableSecond;

	@FindBy(id = "droppable-revert-draggable")
	private WebElement droppableRevertDraggableBox;

	public void dragRevertDraggableFirstToDroppableBox() {
		actions.clickAndHold(draggableRevertDraggableFirst)
			.moveToElement(droppableRevertDraggableBox)
			.release()
			.build()
			.perform();
	}

	public void dragRevertDraggableFirstByOffset(int xOffset, int yOffset) {
		int locX = draggableRevertDraggableFirst.getLocation().getX();
		int locY = draggableRevertDraggableFirst.getLocation().getY();
		actions.clickAndHold(draggableRevertDraggableFirst)
			.moveToLocation(locX + xOffset, locY + yOffset)
			.build()
			.perform();
	}

	public void releaseRevertDraggableFirst() {
		actions.release().build().perform();
	}

	public void dragRevertDraggableSecondToDroppableBox() {
		actions.clickAndHold(draggableRevertDraggableSecond)
			.moveToElement(droppableRevertDraggableBox)
			.release()
			.build()
			.perform();
	}

	public void dragRevertDraggableSecondByOffset(int xOffset, int yOffset) {
		int locX = draggableRevertDraggableSecond.getLocation().getX();
		int locY = draggableRevertDraggableSecond.getLocation().getY();
		actions.clickAndHold(draggableRevertDraggableSecond)
			.moveToLocation(locX + xOffset, locY + yOffset)
			.build()
			.perform();
	}

	public void releaseRevertDraggableSecond() {
		actions.release().build().perform();
		wait(2);
	}

	public int[] getRevertDraggableFirstLocation() {
		return new int[] { draggableRevertDraggableFirst.getLocation().getX(),
				draggableRevertDraggableFirst.getLocation().getY() };
	}

	public int[] getRevertDraggableSecondLocation() {
		return new int[] { draggableRevertDraggableSecond.getLocation().getX(),
				draggableRevertDraggableSecond.getLocation().getY() };
	}

	public String getDroppableRevertDraggableText() {
		return droppableRevertDraggableBox.getText();
	}

	public String getDroppableRevertDraggableBGColor() {
		return getBGColorOfElementWithJavaScript(droppableRevertDraggableBox);
	}

}
