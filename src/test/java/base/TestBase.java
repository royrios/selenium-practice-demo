package base;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;
import utils.DriverManager;
import utils.Log;
import utils.PropertyReader;

public class TestBase extends DriverManager {

	// Setup and TearDown
	
	public WebDriver driver;
	Capabilities chromeOptions = new DesiredCapabilities();
	PropertyReader pr = new PropertyReader();
	
	public TestBase() {
		
		this.driver = super.getDriver();
		
	}




	@BeforeMethod(alwaysRun = false)
	public void setup() {
		//Read from properties file and set the WebDriver
		
		try {
			
			if(PropertyReader.readItem("browser").equalsIgnoreCase("chrome")) {
				//updates chomedriver version to 64bits
				System.getProperty("java.classpath");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver.exe");
				driver = new ChromeDriver();
				//driver = new RemoteWebDriver(new URL("http://192.168.0.135:4444"),  chromeOptions);
				
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
	//remove 
	@AfterMethod(alwaysRun = false)
	public void tearDown() {
		
		driver.quit();
			
	
	}
	
	
	public void takeScreenShot(String name) {
		
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
	
}


