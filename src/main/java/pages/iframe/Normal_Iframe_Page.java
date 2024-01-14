package pages.iframe;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Normal_Iframe_Page extends BasePage {

	String mainWindowHandle = DRIVER.getWindowHandle();

	@FindBy(id = "nestedIframe")
	WebElement iframe;

	@FindBy(css = "div > h1")
	WebElement iframeH1;

	@FindBy(css = "div > p")
	WebElement iframeParagraph;

	@FindBy(xpath = "/html/head/title")
	WebElement iframeTitle;

	public void switchToIframe() {
		DRIVER.switchTo().frame(iframe);
	}

	public void switchToWindow() {
		DRIVER.switchTo().window(mainWindowHandle);
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
