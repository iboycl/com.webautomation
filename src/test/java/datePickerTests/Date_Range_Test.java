package datePickerTests;

import BaseTest.Hooks;
import org.testng.annotations.Test;
import pages.datePicker.Date_Range_Page;
import pages.datePicker.Display_Multiple_Months_Page;

// 1. Click on Webautomation link
// 2. Click on Date Picker link
// 3. Click on Select Date Range link
// 4. Click on date input field
// 5. Verify that date picker is displayed
// 6. Click on next month button
// 7. Verify that the second month on the calendar is "March 2024"
// 8. Click on previous month button 3 times
// 9. Verify that the second month on the calendar is "December 2023"
// 10.Type 01/07/2024 and 01/14/2024 in to date fields and verify that they are selected
// 11.Click on end date input field
// 12.Verify that days before 01/07/2024 aren't selectable
// 13.Click on begin date input field
// 14.Verify that days after 01/14/2024 aren't selectable

public class Date_Range_Test extends Hooks {

    @Test
    void testSelectDateRange() {
        // 1. Click on Webautomation link
        // 2. Click on Date Picker link
        pages.getWebAutomationPage().clickOnDatePickerLink();

        // 3. Click on Select Date Range link
        pages.getWebAutomationPage().clickOnSelectDateRangeLink();
        Date_Range_Page dateRangePage = pages.getSelectDateRangePage();

        // 4. Click on date input field
        dateRangePage.clickOnToDatePickerInputField();

        // 5. Verify that date picker is displayed
        waitSec(1);
        softAssert.assertTrue(dateRangePage.isDatePickerModalDisplayed(), "Date picker is not visible");

        // 6. Click on next month button
        dateRangePage.clickOnNextMonthButton();

        // 7. Verify that the first month on the calendar is "March 2024"
        waitSec(1);
        softAssert.assertTrue(dateRangePage.isSecondMonthCorrect("March 2024"), "Next month button doesn't work properly");

        // 8. Click on previous month button 3 times
        for (int i = 0; i < 3; i++) dateRangePage.clickOnPreviousMonthButton();

        // 9. Verify that the first month on the calendar is "November 2023"
        waitSec(1);
        softAssert.assertTrue(dateRangePage.isSecondMonthCorrect("December 2023"), "Previous month button doesn't work properly");

        // 10.Type 01/07/2024 and 01/14/2024 in to date fields and verify that they are selected
        dateRangePage.isGivenDatesSelected("01/07/2024", "01/14/2024");

        // 11.Click on end date input field
        waitSec(1);
        dateRangePage.clickOnToDatePickerInputField();

        // 12.Verify that days before 01/07/2024 aren't selectable
        waitSec(1);
        softAssert.assertFalse(dateRangePage.isDaySelectable("6"), "Given toDay is selectable");

        // 13.Click on begin date input field
        waitSec(1);
        dateRangePage.clickOnFromDatePickerInputField();

        // 14.Verify that days after 01/14/2024 aren't selectable
        waitSec(1);
        softAssert.assertFalse(dateRangePage.isDaySelectable("16"), "Given fromDay is selectable");

        softAssert.assertAll("Date Range test is not completed");
    }
}
