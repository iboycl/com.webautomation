package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.NoSuchElementException;

public class Icons_Page extends BasePage {
    @FindBy(css = "#menu-w-icons > li")
    List<WebElement> menuList;

    public void hoverOnElement(int index) {
        actions.moveToElement(menuList.get(index - 1)).perform();
    }

    public void clickOnElement(int index) {
        menuList.get(index - 1).click();
    }

    public boolean checkConvertedIntoSelectable(int index) {
        clickOnElement(index);

        try {
            menuList.get(index - 1).findElement(By.tagName("ul"));
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public String getBGColorOfMenuItem(int index) {
        wait(1);
        return getBGColorOfElementWithJavaScript(menuList.get(index - 1).findElement(By.tagName("div")));
    }

    public String getElementText(int index) {
        wait(1);
        return menuList.get(index -1 ).getText();
    }
}
