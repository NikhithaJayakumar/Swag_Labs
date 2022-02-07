package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class DriverLaunch {
	
	WebDriver driver;
	ActionKeywords action= new ActionKeywords();
	Properties prop= new Properties();
	
	@BeforeTest
	public WebDriver openBrowser(String browser) throws IOException  {
		
		if(browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\Softwares\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			FileInputStream inputStream = new FileInputStream(
					"E:\\Selenium projects\\Swag_Labs\\src\\test\\resources\\Properties\\testdata.properties");
			prop.load(inputStream);
 
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
						
		}
			

		else if (browser.equalsIgnoreCase("Firefox"))  {

			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			
		}
		return driver;
		
		}
	}

