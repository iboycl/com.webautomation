package pages.dialog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Model_Form_Page extends BasePage {
    @FindBy(xpath = "//*/button[text()='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*/tbody/tr")
    private List<WebElement> rows;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "surname")
    private WebElement surnameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//*/button[text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*/span[@id='ui-id-47']/../button")
    private WebElement closeButton;

    @FindBy(id = "ui-id-47")
    private WebElement userDialog;


    public String getRow(int index) {
        return rows.get(index).getText();
    }

    public void addUser(String name, String surname, String email) {
        createAccountButton.click();
        nameInput.sendKeys(name);
        surnameInput.sendKeys(surname);
        emailInput.sendKeys(email);
        submitButton.click();
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickOnCloseButton() {
        actions.moveToElement(closeButton).click().perform();
    }

    public boolean isUserDialogVisible() {
        return userDialog.isDisplayed();
    }

}
