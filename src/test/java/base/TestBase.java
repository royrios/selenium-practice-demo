package base;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;
import utils.DriverManager;
import utils.Log;
import utils.PropertyReader;

public class TestBase extends DriverManager {

	// Setup and TearDown
	
	public WebDriver driver;
	PropertyReader pr = new PropertyReader();
	
	public TestBase() {
		
		this.driver = super.getDriver();
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		//Read from properties file and set the WebDriver
		
		try {
			
			if(PropertyReader.readItem("browser").equalsIgnoreCase("chrome")) {
				
				System.getProperty("java.classpath");
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				
				
			}
			else {
				try {
					throw new Exception("Browser Driver is not supported");
				}catch (Exception e) {
					
					Log.error("No Compatible browser found", e);
					
				}
			}
			
		}catch (Exception e) {
			// 
			Log.error("Browser Launch error", e);
		}
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
			
	
	}
	
	
	public void takeScreenShot(String name) {
		
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
	
}


