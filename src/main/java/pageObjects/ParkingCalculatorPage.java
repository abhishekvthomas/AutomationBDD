package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParkingCalculatorPage extends Utility{

	public ParkingCalculatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Lot")
	WebElement selectParkingLot;
	
	@FindBy(name = "EntryTime")
	WebElement entryTime;
	
	@FindBy(name = "EntryDate")
	WebElement entryDate;
	
	@FindBy(name = "ExitTime")
	WebElement exitTime;
	
	@FindBy(name = "ExitDate")
	WebElement exitDate;

	@FindBy(name = "Submit")
	WebElement calculateBtn;
	
	@FindBy(css = "[name='EntryTimeAMPM'][value='PM']")
	WebElement entryTimePM;
	
	@FindBy(css = "[name='ExitTimeAMPM'][value='PM']")
	WebElement exitTimePM;
	
	public void selectParkingLot() {
		selectElement(selectParkingLot, "Valet Parking");
	}
	
	public void enterEntryDate_Time(WebDriver driver, String time, String date) {
		enterText(driver, entryTime, time);
		clickElement(driver, entryTimePM);
		enterText(driver, entryDate, date);
	}
	
	public void enterExitDate_Time(WebDriver driver, String time, String date) {
		enterText(driver, exitTime, time);
		clickElement(driver, exitTimePM);
		enterText(driver, exitDate, date);
	}
	
	public void clickCalculateBtn(WebDriver driver) {
		clickElement(driver, calculateBtn);
	}
	
}
