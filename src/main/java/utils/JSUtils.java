package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class JSUtils {

	private static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

	;

	public static void executeJavaScript(String script) {
		js.executeScript(script);
	}

	public static String getBGColorOfElementWithJavaScript(WebElement element) {
		return (String) js.executeScript(
				"return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');", element);
	}

}
