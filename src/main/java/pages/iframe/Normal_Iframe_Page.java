package pages.iframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Driver;

public class Normal_Iframe_Page extends BasePage {

	WebDriver driver = Driver.getDriver();

	String mainWindowHandle = driver.getWindowHandle();

	@FindBy(id = "nestedIframe")
	WebElement iframe;

	@FindBy(css = "div > h1")
	WebElement iframeH1;

	@FindBy(css = "div > p")
	WebElement iframeParagraph;

	@FindBy(xpath = "/html/head/title")
	WebElement iframeTitle;

	public void switchToIframe() {
		driver.switchTo().frame(iframe);
	}

	public void switchToWindow() {
		driver.switchTo().window(mainWindowHandle);
	}

	public String getIframeH1Text() {
		return iframeH1.getText();
	}

	public String getIframeTitle() {
		return iframeTitle.getAttribute("outerHTML");
	}

	public String getIframeParagraph() {
		return iframeParagraph.getText();
	}

}
