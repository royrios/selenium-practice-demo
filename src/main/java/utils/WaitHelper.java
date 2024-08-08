package utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class WaitHelper {

	public WebDriver driver;
	public  Wait<WebDriver> fluentWait;
	
	public WaitHelper(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver =driver;
		this.fluentWait = new FluentWait<WebDriver>(this.driver)
				//Specify the timeout of the wait
				.withTimeout(30,TimeUnit.SECONDS)
				//Specify the polling time
				.pollingEvery(1,TimeUnit.SECONDS )
				//Specify what exception to ignore
				.ignoring(NoSuchElementException.class); 
		
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public WebElement presenceofElement(final By locator) {
		
		return fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
	}
	
	public WebElement elementToBeClickkable(final By locator) {
		
		return  fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
}
