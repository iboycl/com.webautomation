package pages.datePicker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class Display_Multiple_Months_Page extends BasePage {
    @FindBy(id="datepicker-multiple-months")
    private WebElement datePickerInputField;

    @FindBy(id="ui-datepicker-div")
    private WebElement datePickerModal;

    @FindBy(css=".ui-datepicker-prev")
    private WebElement previousMonthButton;

    @FindBy(css=".ui-datepicker-next")
    private WebElement nextMonthButton;

    @FindBy(xpath="//button[text()='Today']")
    private WebElement todayButton;

    @FindBy(xpath="//button[text()='Done']")
    private WebElement doneButton;

    @FindBy(xpath="//div[@class='ui-datepicker-title'][1]")
    private WebElement datePickerTitle;

    @FindBy(xpath="//table[@class='ui-datepicker-calendar'][1]/tbody/*/td/a")
    private List<WebElement> datePickerDays;



    public void clickOnDatePickerInputField(){
        datePickerInputField.click();
    }

    public void typeInDatePickerInputField(String dateMMDDYYY){
        datePickerInputField.sendKeys(dateMMDDYYY);
    }

    public boolean isDatePickerModalDisplayed() {return datePickerModal.isDisplayed();}

    public void clickOnPreviousMonthButton(){ actions.moveToElement(previousMonthButton).click().perform(); }

    public void clickOnNextMonthButton(){ actions.moveToElement(nextMonthButton).click().perform();}

    public void clickOnTodayButton(){ todayButton.click();}

    public void clickOnDoneButton(){
        doneButton.click();
        wait(1);
    }

    public boolean isGivenDateSelected(String dateMMDDYYY) {
        typeInDatePickerInputField(dateMMDDYYY);
        String[] date = dateMMDDYYY.split("/");
        String[] months = {"", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String selectedMonth = months[Integer.parseInt(date[0])];
        int selectedDay = Integer.parseInt(date[1]);

        WebElement foundElement = datePickerDays.stream().filter(element -> element.getText().contains(selectedDay + "")).findFirst().orElse(null);

        return datePickerTitle.getText().toLowerCase().contains(selectedMonth + " " + date[2]) &&
                getBGColorOfElementWithJavaScript(foundElement).equals("rgb(0, 128, 0)");
    }

    public boolean isFirstMonthCorrect(String monthYear) {
        return datePickerTitle.getText().toLowerCase().contains(monthYear.toLowerCase());
    }

}
