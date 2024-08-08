package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class DashboardPage extends BasePage{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
		
	//Page Locators
	By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");
	
	//Page Actions
	public String loggedInUserName() {
		
		waitForLoading();
		searchWebElement(userNameOnDashboard);
		return readText(userNameOnDashboard);
	}
}
