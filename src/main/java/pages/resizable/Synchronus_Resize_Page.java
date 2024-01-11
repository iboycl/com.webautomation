package pages.resizable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Synchronus_Resize_Page extends BasePage {

	@FindBy(id = "resizable-synchr-resize")
	private WebElement firstResizable;

	@FindBy(xpath = "//*[@id='resizable-synchr-resize']/div[3]")
	private WebElement firstElementHandle;

	@FindBy(id = "also-synchr-resize")
	private WebElement secondResizable;

	@FindBy(xpath = "//*[@id='also-synchr-resize']/div[3]")
	private WebElement secondElementHandle;

	public void resizeFirstResizable(int xOffset, int yOffset) {
		actions.dragAndDropBy(firstElementHandle, xOffset, yOffset).perform();
	}

	public int[] getFirstResizableSize() {
		int locX = firstResizable.getLocation().getX();
		int locY = firstResizable.getLocation().getY();
		return new int[] { locX + firstResizable.getSize().width, locY + firstResizable.getSize().height };
	}

	public void resizeSecondResizable(int xOffset, int yOffset) {
		actions.dragAndDropBy(secondElementHandle, xOffset, yOffset).perform();
	}

	public int[] getSecondResizableSize() {
		int locX = secondResizable.getLocation().getX();
		int locY = secondResizable.getLocation().getY();
		return new int[] { locX + secondResizable.getSize().width, locY + secondResizable.getSize().height };
	}

}
