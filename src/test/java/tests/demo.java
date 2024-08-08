package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.DashboardPage;
import pages.LoginPage;
import utils.PropertyReader;

public class demo extends TestBase {
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify login To VWO")
	@Test
	public void loginToVWO() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.openLoginPage();
		loginPage.loginToVWO();
		takeScreenShot("Login to VWO");
		
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify Logged In User ")
	@Test
	public void verifyLoggedInUser() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.openLoginPage();
		loginPage.loginToVWO();
		
		DashboardPage dashboardPage = loginPage.afterLogin();
		
		Assert.assertEquals(dashboardPage.loggedInUserName(),PropertyReader.readItem("fullUsername"));
		
		takeScreenShot("Login to VWO");
		
	}

}
