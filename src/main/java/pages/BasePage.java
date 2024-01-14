package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BasePage {

	protected final WebDriver DRIVER = Driver.getDriver();

	protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

	public Actions actions = new Actions(DRIVER);

	public BasePage() {
		PageFactory.initElements(DRIVER, this);
		DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void executeJavaScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) DRIVER;
		js.executeScript(script);
	}

	public String getBGColorOfElementWithJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) DRIVER;
		return (String) js.executeScript(
				"return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');", element);
	}

	public void wait(double second) {
		try {
			Thread.sleep((long) second * 1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void wait(int second) {
		try {
			Thread.sleep((long) second * 1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
