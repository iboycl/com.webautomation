package pages.selectable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.util.List;

public class Serialize_Page extends BasePage {

	@FindBy(css = "#feedback-serialize")
	WebElement feedbackText;

	@FindBy(css = "#selectable-serialize > li")
	List<WebElement> selectableElements;

	public String getFeedbackText() {
		return feedbackText.getText();
	}

	public void clickOnElement(int index) {
		selectableElements.get(index - 1).click();
	}

	public void clickOnElementByPressingCtrl(int index) {
		actions.moveToElement(selectableElements.get(index - 1))
			.keyDown(Keys.CONTROL)
			.click()
			.keyUp(Keys.CONTROL)
			.perform();
	}

	public void chooseElementsByDragging(int index1, int index2, int index3) {
		actions.moveToElement(selectableElements.get(index1 - 1))
			.clickAndHold()
			.moveToElement(selectableElements.get(index3 - 1))
			.release()
			.build()
			.perform();
	}

	public String getSelectableElementBGColor(int index) {
		return getBGColorOfElementWithJavaScript(selectableElements.get(index - 1));
	}

	public String getSelectableElementText(int index) {
		return selectableElements.get(index - 1).getText();
	}

}
