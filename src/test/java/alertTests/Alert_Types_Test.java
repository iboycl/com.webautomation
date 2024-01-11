package alertTests;

import BaseTest.Hooks;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.alerts.Alert_Types_Page;
import utils.BrowserUtils;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

// 1. Click on Show Alert button
// 2. Verify alert is visible by getting its text "This is an alert!"
// 3. Click on "Tamam" button on alert
// 4. Verify alert is disappeared
// 5. Click on Show Confirm button
// 6. Verify alert is visible by getting its text "Are you sure?"
// 7. Click on "Tamam" button on alert
// 8. Verify alert text changed to "Confirmed!"
// 9. Click on "Tamam" button on alert
// 10. Verify alert is disappeared
// 11. Click on Show Confirm button
// 12. Click on "İptal" button on alert
// 13. Verify alert is disappeared
// 14. Click on Show Prompt button
// 15. Verify alert is visible by getting its text "Enter your name:"
// 16. Type "Mecnun" in input field
// 17. Verify alert gives correct prompt by checking its text "Hello, Mecnun!"
// 18. Click on "Tamam" button on alert
// 19. Verify alert is disappeared
// 20. Click on Show Prompt button
// 21. Click on "İptal" button on alert
// 22. Verify alert is disappeared

public class Alert_Types_Test extends Hooks {

	@Test
	void testAlert() {
		pages.getHomePage().clickOnWebAutomationLink();
		pages.getWebAutomationPage().clickOnAlertsLink();

		Alert_Types_Page alertTypesPage = pages.getAlertTypesPage();

		BrowserUtils.wait(2);
		// 1. Click on Show Alert button
		alertTypesPage.clickOnShowAlert();

		// 2. Verify alert is visible by getting its text "This is an alert!"
		alertTypesPage.switchToAlert();
		assertEquals("This is an alert!", alertTypesPage.getAlertText(), "Show Alert button doesn't show any alert!");

		// 3. Click on "Tamam" button on alert
		alertTypesPage.acceptAlert();

		// 4. Verify alert is disappeared
		alertTypesPage.switchToWindow();
		assertNull(alertTypesPage.isAlertVisible(), "Alert is still visible after clicking Tamam");

		// 5. Click on Show Confirm button
		alertTypesPage.clickOnShowConfirm();

		// 6. Verify alert is visible by getting its text "Are you sure?"
		alertTypesPage.switchToAlert();
		assertEquals("Are you sure?", alertTypesPage.getAlertText(), "Show Confirm button doesn't show any alert!");

		// 7. Click on "Tamam" button on alert
		alertTypesPage.acceptAlert();

		// 8. Verify alert text changed to "Confirmed!"
		assertEquals("Confirmed!", alertTypesPage.getAlertText(),
				"After clicking Tamam button alert text doesn't change!");

		// 9. Click on "Tamam" button on alert
		alertTypesPage.acceptAlert();

		// 10. Verify alert is disappeared
		alertTypesPage.switchToWindow();
		assertNull(alertTypesPage.isAlertVisible(), "Alert is still visible after clicking Tamam");

		// 11. Click on Show Confirm button
		alertTypesPage.clickOnShowConfirm();

		// 12. Click on "İptal" button on alert
		alertTypesPage.switchToAlert();
		alertTypesPage.dismissAlert();

		// 13. Verify alert is disappeared
		alertTypesPage.switchToWindow();
		assertNull(alertTypesPage.isAlertVisible(), "Alert is still visible after clicking İptal");

		// 14. Click on Show Prompt button
		alertTypesPage.clickOnShowPrompt();

		// 15. Verify alert is visible by getting its text "Enter your name:"
		alertTypesPage.switchToAlert();
		assertEquals("Enter your name:", alertTypesPage.getAlertText(), "Show Prompt button doesn't show any alert!");

		// 16. Type "Mecnun" in input field
		alertTypesPage.typeInputOnAlert("Mecnun");
		alertTypesPage.acceptAlert();

		// 17. Verify alert gives correct prompt by checking its text "Hello, Mecnun!"
		assertEquals("Hello, Mecnun!", alertTypesPage.getAlertText(), "Alert doesn't give correct input!");

		// 18. Click on "Tamam" button on alert
		alertTypesPage.acceptAlert();

		// 19. Verify alert is disappeared
		alertTypesPage.switchToWindow();
		assertNull(alertTypesPage.isAlertVisible(), "Alert is still visible after clicking Tamam");

		// 20. Click on Show Prompt button
		alertTypesPage.clickOnShowPrompt();

		// 21. Click on "İptal" button on alert
		alertTypesPage.switchToAlert();
		alertTypesPage.dismissAlert();

		// 22. Verify alert is disappeared
		alertTypesPage.switchToWindow();
		assertNull(alertTypesPage.isAlertVisible(), "Alert is still visible after clicking İptal");

	}

}
