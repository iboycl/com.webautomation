package pages.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.Driver;

public class Alert_Types_Page extends BasePage {

	Alert alert;

	WebDriver driver = Driver.getDriver();

	String mainWindowHandle = driver.getWindowHandle();

	@FindBy(xpath = "//button[text()='Show Alert']")
	WebElement showAlertButton;

	@FindBy(xpath = "//button[text()='Show Confirm']")
	WebElement showConfirmButton;

	@FindBy(xpath = "//button[text()='Show Prompt']")
	WebElement showPromptButton;

	public void switchToAlert() {
		alert = driver.switchTo().alert();
	}

	public void switchToWindow() {
		driver.switchTo().window(mainWindowHandle);
	}

	public void clickOnShowAlert() {
		showAlertButton.click();
	}

	public void clickOnShowConfirm() {
		showConfirmButton.click();
	}

	public void clickOnShowPrompt() {
		showPromptButton.click();
	}

	public String getAlertText() {
		wait(2);
		return alert.getText();
	}

	public void acceptAlert() {
		alert.accept();
	}

	public void dismissAlert() {
		alert.dismiss();
	}

	public void typeInputOnAlert(String text) {
		wait(2);
		alert.sendKeys(text);
	}

	public Alert isAlertVisible() {
		wait(2);
		return ExpectedConditions.alertIsPresent().apply(driver);
	}

}
