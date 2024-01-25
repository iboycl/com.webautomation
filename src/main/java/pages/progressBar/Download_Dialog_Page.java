package pages.progressBar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Download_Dialog_Page extends BasePage {
    @FindBy(id="downloadButton-download-dialog")
    private WebElement downloadButton;

    @FindBy(xpath="//span[text()='File Download']")
    private WebElement downloadDialogHeader;

    @FindBy(id="dialog-download-dialog")
    private WebElement downloadDialogProgress;

    @FindBy(xpath="//button[text()='Cancel Download']")
    private WebElement cancelDownloadButton;

    @FindBy(xpath="//button[@title='Close']")
    private WebElement closeDownloadButton;

    public void clickOnDownloadButton(){
        downloadButton.click();
    }

    public String getDownloadButtonText(){
        return downloadButton.getText();
    }

    public Boolean isDownloadDialogDisplayed(){
        return downloadDialogHeader.isDisplayed();
    }

    public String getDownloadProgressText(){
        return downloadDialogProgress.getText();
    }

    public void clickOnCancelDownloadButton(){
        cancelDownloadButton.click();
    }

    public void clickOnCloseDownloadButton(){
        actions.moveToElement(cancelDownloadButton).click().perform();
    }
}
