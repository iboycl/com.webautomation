package dialogTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.dialog.Model_Form_Page;

// 1. Click on Webautomation link
// 2. Click on Dialog link
// 3. Click on Model Form link
// 4. Verify the first user is "John Doe johndoe@example.com"
// 5. Add user "Jane Doer janedoer@example.com"
// 6. Verify the second user is "Jane Doer janedoer@example.com"
// 7. Click on Create Account button
// 8. Verify the dialog is visible
// 9. Click on Close button
// 10.Verify the dialog is disappeared

public class Model_Form_Test extends Hooks {

    @Test
    void testModalForm() {
        // 1. Click on Webautomation link
        // 2. Click on Dialog link
        pages.getWebAutomationPage().clickOnDialogLink();

        // 3. Click on Model Form link
        pages.getWebAutomationPage().clickOnModalFormLink();
        Model_Form_Page modelFormPage = pages.getModelFormPage();

        // 4. Verify the first user is "John Doe johndoe@example.com"
        softAssert.assertEquals(modelFormPage.getRow(0), "John Doe johndoe@example.com", "The first user is not correct");

        // 5. Add user "Jane Doer janedoer@example.com"
        modelFormPage.addUser("Jane", "Doer", "janedoer@example.com");

        // 6. Verify the second user is "Jane Doer janedoer@example.com"
        softAssert.assertEquals(modelFormPage.getRow(1), "Jane Doer janedoer@example.com", "The second user is not correct");

        // 7. Click on Create Account button
        modelFormPage.clickOnCreateAccountButton();

        // 8. Verify the dialog is visible
        softAssert.assertTrue(modelFormPage.isUserDialogVisible(), "User add dialog is not visible");

        // 9. Click on Close button
        modelFormPage.clickOnCloseButton();

        // 10.Verify the dialog is disappeared
        softAssert.assertFalse(modelFormPage.isUserDialogVisible(), "User add dialog is not disappeared");
    }
}
