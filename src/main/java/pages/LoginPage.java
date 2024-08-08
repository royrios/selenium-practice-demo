package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utils.PropertyReader;

public class LoginPage extends BasePage {
	
	WebDriver v;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	//Page Locators
	By userName = By.id("login-username");
	By password = By.id("login-password");
	By singButton = By.id("js-login-btn");
	
	
	//Page Actions
	
	public void openLoginPage() {
		
		goToUrl(PropertyReader.readItem("url"));
	}
	
	public void loginToVWO() {
		
		writeText(userName, PropertyReader.readItem("username"));
		writeText(password, PropertyReader.readItem("password"));
		
		click(singButton);
	}
	
	public DashboardPage afterLogin() {
		
		return new DashboardPage(driver);
	}

}
