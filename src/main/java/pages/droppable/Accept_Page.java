package pages.droppable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Accept_Page extends BasePage {

	@FindBy(id = "draggable-nonvalid-accept")
	private WebElement draggableNonValidAccept;

	@FindBy(id = "draggable-accept")
	private WebElement draggableAccept;

	@FindBy(css = "#droppable-accept > p")
	private WebElement droppableAccept;

	public void dragNonValidAcceptElementToDroppableBox() {
		actions.clickAndHold(draggableNonValidAccept).moveToElement(droppableAccept).release().build().perform();
	}

	public void dragValidAcceptElementToDroppableBox() {
		actions.clickAndHold(draggableAccept).moveToElement(droppableAccept).release().build().perform();
	}

	public int[] getNonValidAcceptLocation() {
		return new int[] { draggableNonValidAccept.getLocation().getX(), draggableNonValidAccept.getLocation().getY() };
	}

	public int[] getValidAcceptLocation() {
		return new int[] { draggableAccept.getLocation().getX(), draggableAccept.getLocation().getY() };
	}

	public String getDroppableAcceptText() {
		return droppableAccept.getText();
	}

}
