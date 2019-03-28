package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffDashboard extends Utility {

	@FindBy(css= "[href='//money.rediff.com/gainers/bse']")
	WebElement dailyGainers;
	
	@FindBy(css= ".tabs [href='//money.rediff.com/losers/bse/weekly']")
	WebElement dailyLosers;
	
	@FindBy(css = ".leftcontainer .dataTable td a")
	List<WebElement> companyNameList;
	
	public RediffDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickDailyGainers(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		clickElement(driver, dailyGainers);
	}

	public void clickDailyLosers(WebDriver driver) throws Exception{
		Thread.sleep(5000);
		clickElement(driver, dailyLosers);
	}
	
	public void getListOfCompanyName(int count) {
		for (int i = 0; i <= count; i++) {
			System.out.println(companyNameList.get(i).getText());
		}		
	}
	
	
}
