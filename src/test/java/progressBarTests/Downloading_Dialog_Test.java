package progressBarTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.progressBar.Download_Dialog_Page;

// 1. Click on Webautomation link
// 2. Click on Click on Progress Bar link
// 3. Click on Downloading Dialog link
// 4. Click on the Download button
// 5. Verify that its text changed to "Downloading..."
// 6. Verify that download dialog is displayed
// 7. Verify that download started
// 8. Click on "Cancel Download" button
// 9. Verify that download dialog disappears
// 10.Click on Download button
// 11.Click on "Close" button
// 12.Verify that download dialog disappears
public class Downloading_Dialog_Test extends Hooks {

    @Test
    void testDownloadDialog() {
        // 1. Click on Webautomation link
        // 2. Click on Progress Bar link
        pages.getWebAutomationPage().clickOnProgressBarLink();

        // 3. Click on Downloading Dialog link
        pages.getWebAutomationPage().clickOnDownloadDialogLink();
        Download_Dialog_Page downloadDialogPage = pages.getDownloadDialogPage();

        //Verify the Download button's text is "Start Download"
        softAssert.assertEquals(downloadDialogPage.getDownloadButtonText(), "Start Download", "Button text is not 'Start Download'");

        // 4. Click on the Download button
        downloadDialogPage.clickOnDownloadButton();

        // 5. Verify that its text changed to "Downloading..."
        softAssert.assertEquals(downloadDialogPage.getDownloadButtonText(), "Downloading...", "Button text is not 'Downloading...'");

        // 6. Verify that download dialog is displayed
        waitSec(2);
        softAssert.assertTrue(downloadDialogPage.isDownloadDialogDisplayed(), "Download dialog is not displayed");

        // 7. Verify that download started
        softAssert.assertNotEquals(downloadDialogPage.getDownloadProgressText(), "Current Progress: 0%", "Download progress doesn't start");

        // 8. Click on "Cancel Download" button
        downloadDialogPage.clickOnCancelDownloadButton();

        // 9. Verify that download dialog disappears
        waitSec(2);
        softAssert.assertFalse(downloadDialogPage.isDownloadDialogDisplayed(), "Download dialog is not canceled");

        // 10.Click on Download button
        downloadDialogPage.clickOnDownloadButton();

        // 11.Click on "Close" button
        waitSec(1);
        downloadDialogPage.clickOnCloseDownloadButton();

        // 12.Verify that download dialog disappears
        softAssert.assertFalse(downloadDialogPage.isDownloadDialogDisplayed(), "Download dialog is not closed");

        softAssert.assertAll("Download dialog tests are completed");
    }
}
