package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageFactory.HomePage;
import utility.ActionKeywords;
import utility.DriverLaunch;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class sauce_Shopping {

	DriverLaunch objmanager = new DriverLaunch();
	WebDriver driver;
	ActionKeywords action = new ActionKeywords();
	HomePage factory;
	Properties prop= new Properties();
	
	ExtentHtmlReporter reporter= new ExtentHtmlReporter("E:\\Selenium projects\\Swag_Labs\\Reports\\Reports.html");
	ExtentReports extent= new ExtentReports();
	

	@BeforeTest
	public void BeforeTest() throws IOException {

		driver = objmanager.openBrowser("Chrome");
		factory = new HomePage(driver);
	}

	@Test(priority = 1, enabled = true)
	public void Login() throws Throwable {

		// Validating the page navigated
		String expectedUrl = "https://www.saucedemo.com";
		String expectedTitle = "Swag Labs";
		
		
		FileInputStream inputStream= new FileInputStream("E:\\Selenium projects\\Swag_Labs\\src\\test\\resources\\Properties\\testdata.properties");
		prop.load(inputStream);

		String actualUrl = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		System.out.println("\n\nPage Validation\n\nURL is : " + actualUrl + "\nPage Title is : " + actualTitle);

		if (actualUrl.contains(expectedUrl)) {
			System.out.println("\nResult: Page Details Verification is passed\n");
		} else
			System.out.println("\nResult: Page Details Verification is failed\n");

		action.inputText(factory.uname, driver, prop.getProperty("username"));
		action.inputText(factory.pswrd, driver, prop.getProperty("password"));
		Thread.sleep(3000);
		action.click(factory.btn_Login, driver);

		// Validating if Login was successful

		String expected_HomeURL = "https://www.saucedemo.com/inventory.html";
		String home_Url = driver.getCurrentUrl();
		if (home_Url.equalsIgnoreCase(expected_HomeURL)) {
			System.out.println("Result: Login Successful\n");
		} else
			System.out.println("Result: Login failed\n");
		
		//Generating Reports
		extent.attachReporter(reporter);
		ExtentTest logger= extent.createTest("Login");
		logger.log(Status.INFO, "Login to site");
		logger.log(Status.PASS, "Logged in Successfully");
		extent.flush();

	}

	@Test(priority = 2, enabled = true)
	public void add_item() throws InterruptedException {

		
		action.click(factory.btn_addToCart, driver);

		if (factory.btn_RemoveItem.isDisplayed()) {
			System.out.println("Result: Item Added to Cart Successfully\n");
		} else
			System.out.println("Result: Item Not Added to Cart \n");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		action.click(factory.btn_CartIcon, driver);
		
		//Generating Reports
		extent.attachReporter(reporter);
		ExtentTest logger= extent.createTest("Adding Item to Cart");
		logger.log(Status.INFO, "Add Item to Cart");
		logger.log(Status.PASS, "Add Item to Cart Successfully");
		extent.flush();

	}

	@Test(priority = 3, enabled = true)
	public void your_Cart() throws InterruptedException {

		// Validating the item is shown in the Cart

		String expectedItem = "Sauce Labs Backpack";
		String ItemName1 = factory.lnk_Item1.getText();
		if (expectedItem.equals(ItemName1)) {
			System.out.println("Result:" + expectedItem + " is Added to Cart Successfully\n");
		} else
			System.out.println("Result:" + expectedItem + " is Not Added to Cart Successfully\n");

		action.click(factory.btn_Checkout, driver);
		
		//Generating Reports
		extent.attachReporter(reporter);
		ExtentTest logger= extent.createTest("View Cart");
		logger.log(Status.INFO, "Viewing Cart");
		logger.log(Status.PASS, "Viewed Cart Successfully");
		extent.flush();

	}

	@Test(priority = 4, enabled = true)
	public void checkOut() throws InterruptedException {

		action.inputText(factory.txt_firstName, driver, "Test FirstName");
		action.inputText(factory.txt_lastName, driver, "Test LastName");
		action.inputText(factory.txt_postalCode, driver, "AB12CD");
		Thread.sleep(3000);
		action.click(factory.btn_continue, driver);

		if (factory.checkOut_secPage.isDisplayed()) {

			System.out.println("Result:Confirmation page is Displayed Successfully\n");
		} else
			System.out.println("Result:Confirmation page is Not Displayed Successfully\n");

		action.click(factory.btn_Finish, driver);

		if (driver.getPageSource().contains("THANK YOU FOR YOUR ORDER")) {
			System.out.println("Result: Order Confirmation Successful\n");
		}

		else {
			System.out.println("Result: Order Confirmation Unsuccessful\n");
		}
		
		//Generating Reports
		extent.attachReporter(reporter);
		ExtentTest logger= extent.createTest("Check Out");
		logger.log(Status.INFO, "Check Out");
		logger.log(Status.PASS, "Checked out Successfully");
		extent.flush();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();
	}

}
