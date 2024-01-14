package pages.resizable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

public class Textarea_Page extends BasePage {

	@FindBy(id = "resizable-text-area-res")
	WebElement textArea;

	@FindBy(xpath = "//*[@id='resizable-text-area-res']/../div[3]")
	WebElement textAreaCornerHandle;

	@FindBy(xpath = "//*[@id='resizable-text-area-res']/../div[1]")
	WebElement textAreaRightHandle;

	@FindBy(xpath = "//*[@id='resizable-text-area-res']/../div[2]")
	WebElement textAreaBottomHandle;

	public void resizeTextAreaWithCornerHandle(int xOffset, int yOffset) {
		actions.dragAndDropBy(textAreaCornerHandle, xOffset, yOffset).perform();
	}

	public void resizeTextAreaWithRightHandle(int xOffset) {
		int locX = textAreaRightHandle.getLocation().getX();
		int locY = textAreaRightHandle.getLocation().getY();
		actions.moveToLocation(locX + 1, locY + 1)
			.clickAndHold()
			.moveToLocation(locX + xOffset, locY)
			.release()
			.build()
			.perform();
		// actions.dragAndDropBy(textAreaRightHandle, xOffset, 0).perform();
	}

	public void resizeTextAreaWithBottomHandle(int yOffset) {
		int locX = textAreaBottomHandle.getLocation().getX();
		int locY = textAreaBottomHandle.getLocation().getY();
		actions.moveToLocation(locX + 1, locY + 1)
			.clickAndHold()
			.moveToLocation(locX, locY + yOffset)
			.release()
			.build()
			.perform();
		// actions.dragAndDropBy(textAreaBottomHandle, 0, yOffset).perform();
	}

	public int[] getTextAreaSize() {
		int locX = textArea.getLocation().getX();
		int locY = textArea.getLocation().getY();
		return new int[] { locX + textArea.getSize().width, locY + textArea.getSize().height };
	}

	public void typeInTextBox(String text) {
		textArea.sendKeys(text);
	}

}
