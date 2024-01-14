package utils;

import pages.Autocomplete.MultipleRemote_Page;
import pages.HomePage;
import pages.WebAutomationPage;
import pages.alerts.Alert_Types_Page;
import pages.draggable.AutoScrolling_Page;
import pages.draggable.Constrain_Movement_Page;
import pages.draggable.Handles_Page;
import pages.droppable.Accept_Page;
import pages.droppable.Revert_Draggable_Page;
import pages.iframe.Normal_Iframe_Page;
import pages.resizable.Synchronus_Resize_Page;
import pages.resizable.Textarea_Page;
import pages.selectable.Serialize_Page;

public class Pages {

	private HomePage homePage;

	private WebAutomationPage webAutomationPage;

	private AutoScrolling_Page autoScrollingPage;

	private Constrain_Movement_Page constrainMovementPage;

	private Handles_Page handlesPage;

	private Accept_Page acceptPage;

	private Revert_Draggable_Page revertDraggablePage;

	private Synchronus_Resize_Page synchronusResizePage;

	private Textarea_Page textareaPage;

	private Serialize_Page serializePage;

	private Alert_Types_Page alertTypesPage;

	private Normal_Iframe_Page normalIframePage;

	private MultipleRemote_Page multipleRemotePage;

	public Pages() {
		homePage = new HomePage();
		webAutomationPage = new WebAutomationPage();
		autoScrollingPage = new AutoScrolling_Page();
		constrainMovementPage = new Constrain_Movement_Page();
		handlesPage = new Handles_Page();
		acceptPage = new Accept_Page();
		revertDraggablePage = new Revert_Draggable_Page();
		synchronusResizePage = new Synchronus_Resize_Page();
		textareaPage = new Textarea_Page();
		serializePage = new Serialize_Page();
		alertTypesPage = new Alert_Types_Page();
		normalIframePage = new Normal_Iframe_Page();
		multipleRemotePage = new MultipleRemote_Page();
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public WebAutomationPage getWebAutomationPage() {
		return webAutomationPage;
	}

	public AutoScrolling_Page getAutoScrollingPage() {
		return autoScrollingPage;
	}

	public Constrain_Movement_Page getConstrainMovementPage() {
		return constrainMovementPage;
	}

	public Handles_Page getHandlesPage() {
		return handlesPage;
	}

	public Accept_Page getAcceptPage() {
		return acceptPage;
	}

	public Revert_Draggable_Page getRevertDraggablePage() {
		return revertDraggablePage;
	}

	public Synchronus_Resize_Page getSynchronusResizePage() {
		return synchronusResizePage;
	}

	public Textarea_Page getTextareaPage() {
		return textareaPage;
	}

	public Serialize_Page getSerializePage() {
		return serializePage;
	}

	public Alert_Types_Page getAlertTypesPage() {
		return alertTypesPage;
	}

	public Normal_Iframe_Page getNormalIframePage() {
		return normalIframePage;
	}

	public MultipleRemote_Page getMultipleRemotePage() {
		return multipleRemotePage;
	}

}
