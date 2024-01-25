package pages.datePicker;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Date_Range_Page extends BasePage {
    @FindBy(id="from-selectDateRange")
    private WebElement fromDateInputField;

    @FindBy(id="to-selectDateRange")
    private WebElement toDateInputField;

    @FindBy(id="ui-datepicker-div")
    private WebElement datePickerModal;

    @FindBy(css=".ui-datepicker-prev")
    private WebElement previousMonthButton;

    @FindBy(css=".ui-datepicker-next")
    private WebElement nextMonthButton;

    @FindBy(xpath="//select[@class='ui-datepicker-month']")
    private WebElement monthSelector;

    @FindBy(css=".ui-datepicker-title:nth-child(1)")
    private WebElement datePickerTitle;

    @FindBy(xpath="//table[@class='ui-datepicker-calendar'][1]/tbody/*/td/a")
    private List<WebElement> datePickerDays;

    @FindBy(css=".ui-datepicker-unselectable > span")
    private List<WebElement> unSelectableDays;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement monthPicker;



    public void clickOnFromDatePickerInputField(){
        fromDateInputField.click();
    }

    public void clickOnToDatePickerInputField(){
        toDateInputField.click();
    }


    public boolean isDatePickerModalDisplayed() {return datePickerModal.isDisplayed();}

    public void clickOnPreviousMonthButton(){ actions.moveToElement(previousMonthButton).click().perform(); }

    public void clickOnNextMonthButton(){ actions.moveToElement(nextMonthButton).click().perform();}


    public boolean verifyFromDateSelected(String fromDateMMDDYYY) {
        fromDateInputField.sendKeys(fromDateMMDDYYY);
        String[] fromDate = fromDateMMDDYYY.split("/");

        String[] months = {"", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String fromSelectedMonth = months[Integer.parseInt(fromDate[0]) + 1];

        int fromSelectedDay = Integer.parseInt(fromDate[1]);
        WebElement foundElementFrom = datePickerDays.stream().filter(element -> element.getText().contains(fromSelectedDay + "")).findFirst().orElse(null);

        return datePickerTitle.getText().toLowerCase().contains(fromSelectedMonth + " " + fromDate[2]) &&
                getBGColorOfElementWithJavaScript(foundElementFrom).equals("rgb(0, 128, 0)");
    }

    public boolean verifyToDateSelected(String toDateMMDDYYY) {
        toDateInputField.sendKeys(toDateMMDDYYY);
        String[] toDate = toDateMMDDYYY.split("/");

        String[] months = {"", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String toSelectedMonth = months[Integer.parseInt(toDate[0]) - 1];

        int toSelectedDay = Integer.parseInt(toDate[1]);
        WebElement toElement = datePickerDays.stream().filter(element -> element.getText().contains(toSelectedDay + "")).findFirst().orElse(null);

        return datePickerTitle.getText().toLowerCase().contains(toSelectedMonth + " " + toDate[2]) &&
                getBGColorOfElementWithJavaScript(toElement).equals("rgb(0, 128, 0)");
    }
    public boolean isGivenDatesSelected(String fromDateMMDDYYY, String toDateMMDDYYY) {
        return verifyFromDateSelected(fromDateMMDDYYY) && verifyToDateSelected(toDateMMDDYYY);
    }

    public boolean isSecondMonthCorrect(String monthYear) {
        return datePickerTitle.getText().toLowerCase().contains(monthYear.toLowerCase());
    }

    public boolean isDaySelectable(String day) {
        return !unSelectableDays.stream().filter(element -> element.getText().contains(day)).findFirst().orElse(null).isEnabled();
    }

}
