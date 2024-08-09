package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.WaitHelper;

public class BasePage {
// Navigate
//Wait for Element
//Wait for item
//Click
//Write text
//Read Text
//Move to Element
	
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void goToUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void searchWebElement(By locator) {
		// TODO Auto-generated method stub
		new WaitHelper(driver).presenceofElement(locator);
		
	}
	
	public void waitForLoading() {
		// TODO Auto-generated method stub
		new WaitHelper(driver).implicitWait();
	}
	
	public void click(By locator) { driver.findElement(locator).click();}
	
	
	public void writeText(By locator, String text) {
		// TODO Auto-generated method stub
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	
	public String readText(By locator) {return	driver.findElement(locator).getText();	}
	
	
	public void moveToElement(By locator) {
		// TODO Auto-generated method stub
		new Actions(driver).moveToElement(driver.findElement(locator)).build().perform();
	}
}
