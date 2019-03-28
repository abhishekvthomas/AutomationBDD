package pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends Utility{

	@FindBy(linkText = "http://www.seleniumframework.com/")
	WebElement homeLink;

	@FindBy(xpath = ".//*[text()='This is a link']")
	WebElement thisIsALink;
	
	@FindBy(name = "email")
	WebElement emailInputTab;
	
	@FindBy(xpath = ".//*[@value='Subscribe']")
	WebElement subscribeBtn;
	
	@FindBy(name = "name")
	WebElement nameInputTab;
	
	@FindBy(xpath = ".//*[@class = 'contact-form dt-form']//input[@name = 'email']")
	WebElement emailContactFormInputTab;
	
	@FindBy(name = "telephone")
	WebElement telePhoneInputTab;
	
	@FindBy(xpath = ".//*[@name = 'country']")
	WebElement countryInputTab;
	
	@FindBy(xpath = ".//*[@name = 'company']")
	WebElement companyInputTab;
	
	@FindBy(xpath = ".//*[@name = 'message' and @placeholder = 'Message']")
	WebElement messageInputTab;
	
	@FindBy(xpath = ".//input")
	List<WebElement> inputTxtBoxes;
	
	@FindBy(xpath = ".//button")
	List<WebElement> buttonList;

	@FindBy(xpath = ".//@href")
	List<WebElement> linksList;
	
	@FindBy(id = "colorVar")
	WebElement changeColorBtn;
	
	@FindBy(xpath = "//a[text()='Element8']")
	WebElement element8;
	
	public Dashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void getTitleOfThisIsALink(WebDriver driver) {
		String title = getAttribute(driver, thisIsALink, "title");
		System.out.println(title);
		assertEquals(title, "seleniumframework");
	}

	public void enterEmail_andSubscribe(WebDriver driver) {
		enterText(driver, emailInputTab, "abhishek.thomas@metacube.com");
		clickElement(driver, subscribeBtn);
	}
	
	public void enterContactUsFormDetails(WebDriver driver) {
		enterText(driver, nameInputTab, "Abhishek");
		enterText(driver, emailContactFormInputTab, "Abhishek");
		enterText(driver, telePhoneInputTab, "9874563214");
		enterText(driver, countryInputTab, "India");
		enterText(driver, companyInputTab, "Metacube");
		enterText(driver, messageInputTab, "Msg");
		clickElement(driver, subscribeBtn);
	}
	
	public void getTotalCountsOfInputTabs(WebDriver driver) {
		System.out.println(inputTxtBoxes.size());
	}
	
	public void getTotalCountsOfButtonOnPage(WebDriver driver) {
		System.out.println(buttonList.size());
		System.out.println(buttonList.get(5));
		System.out.println(buttonList.size() - 1);
	}
	
	public void getColorOfChangeColorBtn(WebDriver driver) {
		String color = getAttribute(driver, changeColorBtn, "color");
		System.out.println(color);
	}
	
	public void verifyLinksOnPage(WebDriver driver) {
		for(int i=0;i<linksList.size()-1;i++) {
			if(linksList.get(i).getText().equals("Setup First Project")) {
				System.out.println("Element found");
				System.out.println("Previos element: "+linksList.get(i - 1).getText());
			}
		}
	}
	
	public void clickElement8(WebDriver driver) {
		clickElement(driver, element8);
	}
	
	
}
