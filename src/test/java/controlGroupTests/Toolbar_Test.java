package controlGroupTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.controlGroup.Toolbar_Page;


// 1. Click on Webautomation link
// 2. Click on Control Group link
// 3. Click on Toolbar link
// 4. Select 150% zoom
// 5. Verify that the text zoom attribute is "150%"
// 6. Select 100% zoom
// 7. Verify that the text zoom attribute is "100%"
// 8. Select "Green" back-ground color
// 9. Verify that the "background-color" attribute is green
// 10.Select "None" back-ground color
// 11.Verify that the "background-color" attribute is none
// 12.Select "Yellow" text color
// 13.Verify that the "color" attribute is yellow
// 14.Select "Black" text color
// 15.Verify that the "color" attribute is black
// 16.Click on bold button
// 17.Verify that the "font-weight" attribute is bold
// 18.Click on bold button
// 19.Verify that the "font-weight" attribute is normal
// 20.Click on italic button
// 21.Verify that the "font-style" attribute is italic
// 22.Click on italic button
// 23.Verify that the "font-style" attribute is normal
// 24.Click on underline button
// 25.Verify that the "text-decoration" attribute is underline
// 26.Click on underline button
// 27.Verify that the "text-decoration" attribute is none


public class Toolbar_Test extends Hooks {

    @Test
    void testToolbar() {
    // 1. Click on Webautomation link
    // 2. Click on Control Group link
    pages.getWebAutomationPage().clickOnControlGroupLink();

    // 3. Click on Toolbar link
    pages.getWebAutomationPage().clickOnToolBarLink();
    Toolbar_Page toolbarPage = pages.getToolbarPage();

    // 4. Select 150% zoom
    toolbarPage.setZoomSelect("150%");

    // 5. Verify that the text zoom attribute is "150%"
    softAssert.assertEquals(toolbarPage.getZoom(), "1.5", "Zoom option doesn't increase");

    // 6. Select 100% zoom
    toolbarPage.setZoomSelect("100%");

    // 7. Verify that the text zoom attribute is "100%"
    softAssert.assertEquals(toolbarPage.getZoom(), "1", "Zoom option doesn't decrease");

    // 8. Select "Green" back-ground color
    toolbarPage.setBGColor("Green");

    // 9. Verify that the "background-color" attribute is green
    softAssert.assertEquals(toolbarPage.getBGColor(), "rgba(0, 128, 0, 1)", "Back-ground color doesn't change");

    // 10.Select "None" back-ground color
    toolbarPage.setBGColor("None");

    // 11.Verify that the "background-color" attribute is none
    softAssert.assertEquals(toolbarPage.getBGColor(), "rgba(0, 0, 0, 0)", "Back-ground color doesn't reset");

    // 12.Select "Yellow" text color
    toolbarPage.setTextColor("Yellow");

    // 13.Verify that the "color" attribute is yellow
    softAssert.assertEquals(toolbarPage.getTextColor(), "rgba(255, 255, 0, 1)", "Text color doesn't turn to 'Yellow'");

    // 14.Select "Black" text color
    toolbarPage.setTextColor("Black");

    // 15.Verify that the "color" attribute is black
    softAssert.assertEquals(toolbarPage.getTextColor(), "rgba(0, 0, 0, 1)", "Text color doesn't turn to 'Black'");

    // 16.Click on bold button
    toolbarPage.clickBold();

    // 17.Verify that the "font-weight" attribute is bold
    softAssert.assertTrue(toolbarPage.isTextBold(),  "Bold button doesn't make the text bold");

    // 18.Click on bold button
    toolbarPage.clickBold();

    // 19.Verify that the "font-weight" attribute is normal
    softAssert.assertFalse(toolbarPage.isTextBold(),  "Bold button doesn't make the text normal");

    // 20.Click on italic button
    toolbarPage.clickItalic();

    // 21.Verify that the "font-style" attribute is italic
    softAssert.assertTrue(toolbarPage.isTextItalic(),  "Italic button doesn't make the text italic");

    // 22.Click on italic button
    toolbarPage.clickItalic();

    // 23.Verify that the "font-style" attribute is normal
    softAssert.assertFalse(toolbarPage.isTextItalic(),  "Italic button doesn't make the text normal");

    // 24.Click on underline button
    toolbarPage.clickUnderline();

    // 25.Verify that the "text-decoration" attribute is underline
    softAssert.assertTrue(toolbarPage.isTextUnderlined(),  "Underline button doesn't make the text underlined");

    // 26.Click on underline button
    toolbarPage.clickUnderline();

    // 27.Verify that the "text-decoration" attribute is none
    softAssert.assertFalse(toolbarPage.isTextUnderlined(),  "Underline button doesn't make the text normal");


    softAssert.assertAll("Toolbar tests aren't completed:");
    }
}
