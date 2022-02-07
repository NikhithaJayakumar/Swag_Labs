package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.io.Files;

import PageFactory.HomePage;

public class ActionKeywords {

	WebDriver driver;

	public void click(WebElement clickElement, WebDriver driver) throws InterruptedException {
		clickElement.click();
		Thread.sleep(2000);
	}

	public void inputText(WebElement text, WebDriver driver, String expectedMessage) {

		text.sendKeys(expectedMessage);
	}

	public void waitForWindow() throws InterruptedException {

		System.out.println("Waiting for Window");
		Thread.sleep(5000);
	}

}
