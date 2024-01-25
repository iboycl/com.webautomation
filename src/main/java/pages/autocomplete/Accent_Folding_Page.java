package pages.autocomplete;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Accent_Folding_Page extends BasePage {
    @FindBy(id = "developer-accentFolding")
    WebElement inputBox;

    @FindBy(css = "#ui-id-148 > li")
    List<WebElement> suggestionList;

    public void typeInput(String text) {
        inputBox.sendKeys(text);
    }

    public boolean checkSuggestionsContain(String text) {
        for (WebElement suggestion : suggestionList) {
            if (!suggestion.getText().toLowerCase().contains(text.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSuggestionListVisible() {
        return !suggestionList.isEmpty();
    }

    public void clearInputField() {
        inputBox.clear();
    }
}
