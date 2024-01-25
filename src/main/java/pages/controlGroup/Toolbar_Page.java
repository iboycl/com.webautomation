package pages.controlGroup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class Toolbar_Page extends BasePage {
    @FindBy(css = ".toolbar > div > select:nth-child(1)")
    private WebElement zoomSelect;

    @FindBy(css = ".toolbar > div > select:nth-child(2)")
    private WebElement bgColorSelect;

    @FindBy(css = ".toolbar > div > select:nth-child(3)")
    private WebElement textColorSelect;

    @FindBy(xpath = "//*/button[text()='B']")
    private WebElement boldButton;

    @FindBy(xpath = "//*/button[text()='I']")
    private WebElement italicButton;

    @FindBy(xpath = "//*/button[text()='U']")
    private WebElement underlineButton;

    @FindBy(id = "page")
    private WebElement page;



    public void setZoomSelect(String percentage) {
        Select zoom = new Select(zoomSelect);
        zoom.selectByVisibleText(percentage);
    }

    public void setBGColor(String color) {
        Select bgColor = new Select(bgColorSelect);
        bgColor.selectByVisibleText(color);
    }

    public void setTextColor(String textColor) {
        new Select(textColorSelect).selectByVisibleText(textColor);
    }

    public void clickBold() {
        boldButton.click();
    }

    public void clickItalic() {
        italicButton.click();
    }

    public void clickUnderline() {
        underlineButton.click();
    }

    public String getZoom() {
        return page.getCssValue("zoom");
    }

    public String getBGColor() {
        return page.getCssValue("background-color");
    }

    public String getTextColor() {
        return page.getCssValue("color");
    }

    public String getFontWeight() {
        return page.getCssValue("font-weight");
    }

    public String getFontStyle() {
        return page.getCssValue("font-style");
    }

    public String getTextDecoration() {
        return page.getCssValue("text-decoration");
    }

    public boolean isTextBold() {
        return getFontWeight().equals("700");
    }

    public boolean isTextItalic() {
        return getFontStyle().equals("italic");
    }

    public boolean isTextUnderlined() {
        return getTextDecoration().equals("underline solid rgb(0, 0, 0)");
    }

}
