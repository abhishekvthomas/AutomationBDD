package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility{

	private static String driverPath = System.getProperty("user.dir").concat("\\src\\test\\resources\\drivers\\");
	private static WebDriver driver = null;
	
	public static WebDriver getDriver(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath.concat("chromedriver.exe"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath.concat("geckodriver.exe"));
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", driverPath.concat("IEDriverServer.exe"));
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;
	}
	
	public void clickElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void clickElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
	
	public String getAttribute(WebDriver driver, WebElement element, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute(attribute);
	}
	
	public void enterText(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}
	
	public void selectElement(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
}
