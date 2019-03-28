package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsQADashboard extends Utility{

	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(css = "#sex-0[value='Male']")
	WebElement maleCheckBox;
	
	@FindBy(css = "#sex-0[value='Female']")
	WebElement femaleCheckBox;
	
	@FindBy(id = "datepicker")
	WebElement datePickerInputTab;

	@FindBy(css = "[value='Manual Tester'][name='profession']")
	WebElement manualTester;
	
	@FindBy(css = "[name='profession'][value='Automation Tester']")
	WebElement automationTester;
	
	@FindBy(css = "[name='tool'][value='Selenium Webdriver']")
	WebElement webDriverTool;
	
	@FindBy(id = "continents")
	WebElement selectContinents;
	
	@FindBy(id = "selenium_commands")
	WebElement selectSeleniumCommands;
	
	@FindBy(id = "submit")
	WebElement submitBtn;
	
	String experienceLevel = ".//label[text()='Years of Experience']/../..//input[@value='$year$']";
	
	public ToolsQADashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectContinent() {
		selectElement(selectContinents, "South America");
	}
	
	public void selectSeleniumCommands() {
		selectElement(selectContinents, "Switch Commands");
	}

	public void enterPersonalInformation(WebDriver driver) {
		enterText(driver, firstName, "Abhishek");
		enterText(driver, lastName, "Thomas");
		clickElement(driver, maleCheckBox);
		clickElement(driver, By.xpath(experienceLevel.replace("$year$", "3")));
		enterText(driver, datePickerInputTab, "30/01/2019");
		clickElement(driver, automationTester);
		clickElement(driver, webDriverTool);
		selectElement(selectContinents, "South America");
		selectElement(selectSeleniumCommands, "Switch Commands");
		clickElement(driver, submitBtn);
	}
	
}
