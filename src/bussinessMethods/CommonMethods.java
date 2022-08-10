//Package with all the methods to be executed
package bussinessMethods;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProvider.configFileReader;


public class CommonMethods extends configFileReader {
	
	public static WebDriver driver ;
	public static String itemAdded,itemClicked;
	
	
	//Method to initiate Driver
	public void intitiateDriver() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91868\\OneDrive\\Desktop\\Eclipse\\driver\\chromedriver.exe");
		String url = properties.getProperty("ApplicationUrl");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	//Method to capture screen shot when ever an element is clicked.
	public void takeScreenShotOnClick(WebElement element) throws IOException
	{
		
		String screenshotPath = properties.getProperty("PathToSaveScreenShot");
		element.click();
		Date date = new Date();
		String screenshotFileName = date.toString().replace(" ", "-").replace(":", "-");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(screenshotPath+screenshotFileName+".png"));
	}
	public void quitChrome()
	{
		driver.quit();
	}
		
	}

		



