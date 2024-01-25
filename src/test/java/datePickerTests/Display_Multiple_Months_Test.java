package datePickerTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.datePicker.Display_Multiple_Months_Page;
import pages.progressBar.Download_Dialog_Page;

// 1. Click on Webautomation link
// 2. Click on Date Picker link
// 3. Click on Display Multiple Months link
// 4. Click on date input field
// 5. Verify that date picker is displayed
// 6. Click on next month button
// 7. Verify that the first month on the calendar is "February 2024"
// 8. Click on previous month button 3 times
// 9. Verify that the first month on the calendar is "November 2023"
// 10.Click on Today button
// 11.Verify that the first month on the calendar is "January 2024"
// 12.Type 05/07/2023 and verify that it is selected
// 13.Click on Done button and verify the date picker disappears


public class Display_Multiple_Months_Test extends Hooks {

    @Test
    void testDisplayMultipleMonths() {
        // 1. Click on Webautomation link
        // 2. Click on Date Picker link
        pages.getWebAutomationPage().clickOnDatePickerLink();

        // 3. Click on Display Multiple Months link
        pages.getWebAutomationPage().clickOnDisplayMultipleMonthsLink();
        Display_Multiple_Months_Page displayMultiple = pages.getDisplayMultipleMonthsPage();

        // 4. Click on date input field
        displayMultiple.clickOnDatePickerInputField();

        // 5. Verify that date picker is displayed
        softAssert.assertTrue(displayMultiple.isDatePickerModalDisplayed(), "Date picker is not visible");

        // 6. Click on next month button
        displayMultiple.clickOnNextMonthButton();

        // 7. Verify that the first month on the calendar is "February 2024"
        waitSec(1);

        softAssert.assertTrue(displayMultiple.isFirstMonthCorrect("February 2024"), "Next month button doesn't work properly");

        // 8. Click on previous month button 3 times
        for (int i = 0; i < 3; i++) displayMultiple.clickOnPreviousMonthButton();

        // 9. Verify that the first month on the calendar is "November 2023"
        waitSec(1);
        softAssert.assertTrue(displayMultiple.isFirstMonthCorrect("November 2023"), "Previous month button doesn't work properly");

        // 10.Click on Today button
        displayMultiple.clickOnTodayButton();

        // 11.Verify that the first month on the calendar is "January 2024"
        waitSec(1);
        softAssert.assertTrue(displayMultiple.isFirstMonthCorrect("January 2024"), "Today button doesn't work properly");

        // 12.Type 05/07/2023 and verify that it is selected
        softAssert.assertTrue(displayMultiple.isGivenDateSelected("05/07/2023"), "Given date is not selected");

        // 13.Click on Done button and verify the date picker disappears
        waitSec(1);
        displayMultiple.clickOnDoneButton();

        softAssert.assertFalse(displayMultiple.isDatePickerModalDisplayed(), "Done button doesn't work properly");

        softAssert.assertAll("Display Multiple Months test is not completed");
    }
}
