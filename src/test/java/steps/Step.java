package steps;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AutomationPracticeDashboard;
import pageObjects.Dashboard;
import pageObjects.ParkingCalculatorPage;
import pageObjects.RediffDashboard;
import pageObjects.ToolsQADashboard;
import pageObjects.Utility;

public class Step {
	WebDriver driver;
	Dashboard dashboard;
	ToolsQADashboard qaDashBoard;
	RediffDashboard rediffDashboard;
	AutomationPracticeDashboard practiceDashboard;
	ParkingCalculatorPage parkingPage;
	
	@Given("^I login launch site \"([^\"]*)\"$")
	public void i_login_launch_site(String url) {
		System.out.println("Launching site");
		driver = Utility.getDriver("chrome");
		driver.get(url);
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}

	@When("^I navigate to Home Page$")
	public void i_navigate_to_Home_Page() {
		assertTrue(driver.getTitle().contains("Selenium Framework |   Practiceform"));
		dashboard = new Dashboard(driver);
//		dashboard.clickHomePage(driver);
		assertTrue(driver.getTitle().contains("Selenium Framework | Selenium, Cucumber, Ruby, Java et al."));
	}

	@Then("^I navigate backward$")
	public void i_navigate_backward() {
		driver.navigate().back();
	}

	@Then("^Display title of link 'This is a link'$")
	public void display_title_of_link_This_is_a_link() {
		dashboard.getTitleOfThisIsALink(driver);
	}

	@Then("^I enter email address$")
	public void i_enter_email_address() {
		dashboard.getTitleOfThisIsALink(driver);
	}

	@Then("^I enter valid details in Contact Us form$")
	public void i_enter_valid_details_in_Contact_Us_form() {
		dashboard.enterContactUsFormDetails(driver);
	}

	@Then("^I count total input boxes available on form$")
	public void i_count_total_input_boxes_available_on_form() {
		dashboard.getTotalCountsOfInputTabs(driver);
	}

	@Then("^I get the color code$")
	public void i_get_the_color_code() {
		dashboard.getColorOfChangeColorBtn(driver);
	}

	@Then("^I perform button operations$")
	public void i_perform_button_operations() {
		dashboard.getTotalCountsOfButtonOnPage(driver);
	}

	@Then("^I perform links operations$")
	public void i_perform_links_operations() {
		dashboard.verifyLinksOnPage(driver);
	}

	@Then("^I click Element(\\d+)$")
	public void i_click_Element() {
		dashboard.clickElement8(driver);
	}

	@When("^I enter information details$")
	public void i_enter_information_details() {
		qaDashBoard = new ToolsQADashboard(driver);
		qaDashBoard.enterPersonalInformation(driver);
	}
	
	@Then("^I get details of (\\d+) gainers from Daily section$")
	public void i_get_details_of_gainers_from_Daily_section(int count) throws Exception{
		rediffDashboard = new RediffDashboard(driver);
		rediffDashboard.clickDailyGainers(driver);
		rediffDashboard.getListOfCompanyName(count);
	}

	@Then("^I get details of (\\d+) losers from Weekly section$")
	public void i_get_details_of_losers_from_Weekly_section(int count)throws Exception{
		rediffDashboard.clickDailyLosers(driver);
		rediffDashboard.getListOfCompanyName(count);
	}
	
	@Then("^I click on your logo and verify$")
	public void i_click_on_your_logo_and_verify() {
		practiceDashboard = new AutomationPracticeDashboard(driver);
		practiceDashboard.clickYourLogo(driver);
		assertEquals(practiceDashboard.getCurrentUrl(driver), "http://automationpractice.com/index.php");
	}

	@Then("^I click on contact us and verify$")
	public void i_click_on_contact_us_and_verify() {
		practiceDashboard.clickContactUs(driver);
		assertTrue(practiceDashboard.getCurrentUrl(driver).contains("contact"));
	}
	
	@Then("^I search \"([^\"]*)\" in search tab$")
	public void i_search_in_search_tab(String searchKey) {
		practiceDashboard.searchQuery(driver, searchKey);
		assertTrue(practiceDashboard.getAlertWarningMsg().contains("No results were found for your search"));
	}
	
	@When("^I choose a lot$")
	public void i_choose_a_lot() {
		parkingPage = new ParkingCalculatorPage(driver);
		parkingPage.selectParkingLot();
	}

	@When("^I choose entry date and time$")
	public void i_choose_entry_date_and_time()  {
		parkingPage.enterEntryDate_Time(driver, "02:00", "03/12/2019");
	}

	@When("^I choose exit date and time$")
	public void i_choose_exit_date_and_time()  {
		parkingPage.enterExitDate_Time(driver, "03:00", "03/13/2019");
	}

	@Then("^I calculate$")
	public void i_calculate()  {
		parkingPage.clickCalculateBtn(driver);
	}
	
	@Then("^verify less than (\\d+) products displayed on home page$")
	public void verify_less_than_products_displayed_on_home_page(int homeProducts)  {
	    assertTrue(practiceDashboard.getHomeProductList() < homeProducts);
	}

	@Then("^verify (\\d+) items displayed on Dressed$")
	public void verify_items_displayed_on_Dressed(int summerProducts)  {
		practiceDashboard.clickSummerDresses(driver);
		assertEquals(practiceDashboard.getDressProductList(), summerProducts);
	}

	@Then("^Filter records of color \"([^\"]*)\" and verify$")
	public void filter_records_of_color_and_verify(String arg1)  {
	    
	}

	@Then("^clear filter$")
	public void clear_filter()  {
	    
	}

	@Then("^set price range and verify results$")
	public void set_price_range_and_verify_results()  {
	    
	}

	@When("^I launch dresses in summer dresses in list view$")
	public void i_launch_dresses_in_summer_dresses_in_list_view()  {
	    
	}

	@Then("^I launch quick view of first item$")
	public void i_launch_quick_view_of_first_item()  {
	    
	}

	@Then("^I add to wishlist$")
	public void i_add_to_wishlist()  {
	    
	}

	@Then("^I verify warning message$")
	public void i_verify_warning_message()  {
	    
	}

	@When("^I search for keyword Printed Dress$")
	public void i_search_for_keyword_Printed_Dress()  {
	    
	}

	@When("^I add third item to cart$")
	public void i_add_third_item_to_cart()  {
	    
	}

	@Then("^I verify if the correct item is added to cart$")
	public void i_verify_if_the_correct_item_is_added_to_cart()  {
	    
	}

	@Then("^I checkout items$")
	public void i_checkout_items()  {

		
	}

	@Then("^I verify user launched on Authentication Page$")
	public void i_verify_user_launched_on_Authentication_Page() {
	    
	}

	@Then("^I close browser$")
	public void i_close_browser() {
		driver.close();
	}
}
