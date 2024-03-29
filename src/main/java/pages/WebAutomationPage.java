package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebAutomationPage extends BasePage {

	@FindBy(linkText = "Draggable")
	private WebElement draggableLink;

	@FindBy(linkText = "Default Functionality")
	private WebElement defaultFunctionalityLink;

	@FindBy(linkText = "Constrain Movement")
	private WebElement constrainMovementLink;

	@FindBy(linkText = "Handles")
	private WebElement handles;

	@FindBy(linkText = "Auto Scrolling")
	private WebElement autoScrollingLink;

	@FindBy(linkText = "Droppable")
	private WebElement droppableLink;

	@FindBy(linkText = "Accept")
	private WebElement acceptLink;

	@FindBy(linkText = "Revert draggable position")
	private WebElement revertDraggableLink;

	@FindBy(linkText = "Resizable")
	private WebElement resizableLink;

	@FindBy(linkText = "Synchronus Resize")
	private WebElement synchronusResize;

	@FindBy(linkText = "Textarea")
	private WebElement textArea;

	@FindBy(linkText = "Selectable")
	private WebElement selectableLink;

	@FindBy(linkText = "Serialize")
	private WebElement serializeLink;

	@FindBy(linkText = "Iframe")
	private WebElement iframeLink;

	@FindBy(linkText = "Nested Iframe")
	private WebElement nestedIframeLink;

	@FindBy(linkText = "Normal Iframe")
	private WebElement normalIframeLink;

	@FindBy(linkText = "Alerts")
	private WebElement alertsLink;

	@FindBy(linkText = "Animate")
	private WebElement animateLink;

	@FindBy(linkText = "Autocomplete")
	private WebElement autocompleteLink;

	@FindBy(linkText = "Multiple & Remote")
	private WebElement multipleRemoteLink;

	@FindBy(linkText = "Accent Folding")
	private WebElement accentFoldingLink;

	@FindBy(linkText = "Menu")
	private WebElement menuLink;

	@FindBy(linkText = "Icons")
	private WebElement iconsLink;

	@FindBy(linkText = "Progress Bar")
	private WebElement progressBarLink;

	@FindBy(linkText = "Download Dialog")
	private WebElement downloadDialogLink;

	@FindBy(linkText = "Datepicker")
	private WebElement datePickerLink;

	@FindBy(linkText = "Display Multiple Months")
	private WebElement displayMultipleMonthsLink;

	@FindBy(linkText = "Select Date Range")
	private WebElement selectDateRangeLink;

	@FindBy(linkText = "Control Group")
	private WebElement controlGroupLink;

	@FindBy(linkText = "Toolbar")
	private WebElement toolbarLink;

	@FindBy(linkText = "Dialog")
	private WebElement dialogLink;

	@FindBy(linkText = "Modal Form")
	private WebElement modalFormLink;


	public void clickOnDraggableLink() {
		draggableLink.click();
	}

	public void clickOnDraggableDefaultFunctionalityLink() {
		defaultFunctionalityLink.click();
	}

	public void clickOnConstrainMovementLink() {
		constrainMovementLink.click();
	}

	public void clickOnHandlesLink() {
		handles.click();
	}

	public void clickOnDroppableDefaultFunctionalityLink() {
		defaultFunctionalityLink.click();
	}

	public void clickOnDroppableLink() {
		droppableLink.click();
	}

	public void clickOnAcceptLink() {
		acceptLink.click();
	}

	public void clickOnRevertDraggableLink() {
		revertDraggableLink.click();
	}

	public void clickOnAutoScrollingLink() {
		autoScrollingLink.click();
	}

	public void clickOnResizableLink() {
		resizableLink.click();
	}

	public void clickOnResizableDefaultFuncLink() {
		defaultFunctionalityLink.click();
	}

	public void clickOnSynchronusResizeLink() {
		synchronusResize.click();
	}

	public void clickOnTextAreaLink() {
		textArea.click();
	}

	public void clickOnSelectableLink() {
		selectableLink.click();
	}

	public void clickOnDefaultFunctionality() {
		defaultFunctionalityLink.click();
	}

	public void clickOnSerializeLink() {
		serializeLink.click();
	}

	public void clickOnIframeLink() {
		iframeLink.click();
	}

	public void clickOnNestedIframe() {
		nestedIframeLink.click();
	}

	public void clickOnNormalIframe() {
		normalIframeLink.click();
	}

	public void clickOnAlertsLink() {
		alertsLink.click();
	}

	public void clickOnAnimateLink() {
		animateLink.click();
	}

	public void clickOnAutocompleteLink() {
		wait(2);
		autocompleteLink.click();
	}

	public void clickOnMultipleRemoteLink() {
		multipleRemoteLink.click();
	}

	public void clickOnAccentFoldingLink() { accentFoldingLink.click(); }

	public void clickOnMenuLink() {menuLink.click();}

	public void clickOnIconsLink() {iconsLink.click();}

	public void clickOnProgressBarLink() {progressBarLink.click();}

	public void clickOnDownloadDialogLink() {downloadDialogLink.click();}

	public void clickOnDatePickerLink() {datePickerLink.click();}

	public void clickOnDisplayMultipleMonthsLink() {displayMultipleMonthsLink.click();}

	public void clickOnSelectDateRangeLink() {selectDateRangeLink.click();}

	public void clickOnControlGroupLink() {controlGroupLink.click();}

	public void clickOnToolBarLink() {toolbarLink.click();}

	public void clickOnDialogLink() {dialogLink.click();}

	public void clickOnModalFormLink() {modalFormLink.click();}

}
