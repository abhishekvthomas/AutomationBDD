package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutomationPracticeDashboard extends Utility{

	public AutomationPracticeDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "[href=\"http://automationpractice.com/\"] img")
	WebElement yourLogo;
	
	@FindBy(css= "#contact-link a")
	WebElement contactUs;
	
	@FindBy(css = ".search_query")
	WebElement searchTab;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;
	
	@FindBy(css = ".alert.alert-warning")
	WebElement warningMsg;
	
	@FindBy(css = "#homefeatured li")
	List<WebElement> homeProductList;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement dresses;
	
	@FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[3]/a")
	WebElement summerDresses;
	
	@FindBy(css = ".product-image-container a img")
	List<WebElement> dressProductImages;
	
	@FindBy(css = ".color-option[style='background: #ffffff;']")
	WebElement whiteColor;
	
	@FindBy(css = ".color-list-container a")
	List<WebElement> colorContainer; 
	
	@FindBy(css = "#enabled_filters .icon-remove")
	List<WebElement> clearFilters; 
	
	@FindBy(css = ".ui-slider-handle[style='left: 0%;']")
	WebElement sliderLeft;
	
	@FindBy(css = ".ui-slider-handle[style='left: 100%;']")
	WebElement sliderRight;
	
	@FindBy(css = ".right-block span.price.product-price[itemprop='price']")
	List<WebElement> filteredResults; 
	
	@FindBy(css = ".icon-th-list")
	WebElement listViewIcon;
	
	@FindBy(css = ".quick-view span")
	List<WebElement> quickViewList;
	
	@FindBy(css = "#wishlist_button")
	WebElement wishListBtn;
	
	@FindBy(css = ".fancybox-error")
	WebElement errorMsg;
	
	@FindBy(css = ".ajax_add_to_cart_button")
	List<WebElement> addToCartBtn;
	
	@FindBy(css = ".product-container .product-name")
	List<WebElement> productContainerList;
	
	@FindBy(css = "#layer_cart_product_title")
	WebElement cartProductTitle; 
	
	@FindBy(css = ".button-container .button-medium span")
	WebElement checkoutBtn;
	
	public void clickYourLogo(WebDriver driver) {
		clickElement(driver, yourLogo);
	}
	
	public void clickContactUs(WebDriver driver) {
		clickElement(driver, contactUs);
	}
	
	public void searchQuery(WebDriver driver, String searchKey) {
		enterText(driver, searchTab, searchKey);
		clickElement(driver, searchBtn);
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getAlertWarningMsg() {
		return warningMsg.getText().trim();
	}
	
	public int getHomeProductList() {
		return homeProductList.size();
	}
	
	public void clickSummerDresses(WebDriver driver) {
		clickElement(driver, dresses);
		clickElement(driver, summerDresses);
	}
	
	public int getDressProductList() {
		return dressProductImages.size();
	}
	
	public void selectWhiteColor(WebDriver driver) {
		clickElement(driver, whiteColor);
	}
	
	public void verifyColorContainer(WebDriver driver, String color) {
		for(WebElement colorElement:colorContainer) {
			if(colorElement.getAttribute("href").contains("color-white")) {
				System.out.println("white color filter applied");
			}
			else {
				Assert.fail();
			}
		}
	}
	
	public void clearFilter(WebDriver driver) {
		for(WebElement filterLoc:clearFilters) {
			clickElement(driver, filterLoc);
		}
	}
	
	public void moveSliderToRight(WebDriver driver) {
		Actions action= new Actions(driver);
	    action.dragAndDropBy(sliderLeft, 40, 0);
	    action.build().perform();
	}
	
	public void moveSliderToLeft(WebDriver driver) {
		Actions action= new Actions(driver);
	    action.dragAndDropBy(sliderRight, -40, 0);
	    action.build().perform();
	}
	
	public void verifyFilteredResults(WebDriver driver) {
		for(WebElement filteredResult:filteredResults) {
			int filter = Integer.parseInt(filteredResult.getText().trim());
			assertTrue(Integer.parseInt(filteredResult.getText().trim())>=28);
		}
	}
	
	public void clickListViewIcon(WebDriver driver) {
		clickElement(driver, listViewIcon);
	}
	
	public void clickFirstQuickViewIcon(WebDriver driver) {
		clickElement(driver, quickViewList.get(0));
	}
	
	public void clickWishListBtn(WebDriver driver) {
		clickElement(driver, wishListBtn);
	}
	
	public void verifyErrorMsg(WebDriver driver) {
		assertTrue(errorMsg.getText().equals("You must be logged in to manage your wishlist."));
	}
	
	public void clickAddToCartBtn(WebDriver driver) {
		clickElement(driver, addToCartBtn.get(2));
	}
	
	public void verifyAddedCartItem(WebDriver driver) {
		String itemText = productContainerList.get(2).getText();
		clickAddToCartBtn(driver);
		assertTrue(cartProductTitle.getText().equals(itemText));
	}
	
	public void clickCheckoutBtn(WebDriver driver) {
		clickElement(driver, checkoutBtn);
	}
	
}
