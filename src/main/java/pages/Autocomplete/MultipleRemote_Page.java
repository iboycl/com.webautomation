package pages.Autocomplete;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class MultipleRemote_Page extends BasePage {
    @FindBy(id = "tags-multipleremotes")
    WebElement inputBox;

    @FindBy(css = "#ui-id-43 > li")
    List<WebElement> suggestionList;

    @FindBy(xpath = "//*[@id='tags-multipleremotes']/../span")
    WebElement loadingText;

    public void typeInput(String text) {
        inputBox.sendKeys(text);
    }

    public boolean checkSuggestionsStartsWith(String begins) {
        for (WebElement suggestion : suggestionList) {
            if (!suggestion.getText().toLowerCase().startsWith(begins.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSuggestionListVisible () {
        return !suggestionList.isEmpty();
    }
    public void clearInputField() {
        inputBox.clear();
    }

    public boolean isLoadingTextVisible() {
        return loadingText.isDisplayed();
    }
}
