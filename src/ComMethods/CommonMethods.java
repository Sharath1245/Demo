//Package with all the methods to be executed
package ComMethods;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Xpath.XpathDir;

import dataProvider.configFileReader;



public class CommonMethods extends configFileReader {
	
	public static WebDriver driver ;
	public static String itemAdded,itemClicked;
	
	
	//Method to initiate Driver
	@BeforeTest
	public void intitiateDriver() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91868\\OneDrive\\Desktop\\Eclipse\\driver\\chromedriver.exe");
		String url = properties.getProperty("ApplicationUrl");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	//Method to login Application
	public void login(String username, String password)
	{
		try
		{
		WebElement text_username=driver.findElement(Xpath.XpathDir.text_userName);
		WebElement button_Continue=driver.findElement(Xpath.XpathDir.button_Continue);
		WebElement text_Password=driver.findElement(Xpath.XpathDir.text_Password);
		WebElement button_signIn=driver.findElement(Xpath.XpathDir.button_signIn);
		text_username.sendKeys(username);
		button_Continue.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		text_Password.sendKeys(password);
		button_signIn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
	//Method to Verify cart Item (Test case- 1)
    @Test
	public void verifyCartItem()
	{
    	try
    	{
		/*String userName = properties.getProperty("UserName");
		String password= properties.getProperty("Password");
		login(userName, password);*/
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement text_searchBox=driver.findElement(Xpath.XpathDir.input_searchBox);
		WebElement button_search=driver.findElement(Xpath.XpathDir.button_search);
		text_searchBox.sendKeys("bike");
		takeScreenShotOnClick(button_search);
		//button_search.click();
		WebElement link_firstItemAppeared=driver.findElement(Xpath.XpathDir.link_itemAppeared);
		String itemClicked = link_firstItemAppeared.getText();
		System.out.println("Description of item appeared in search"+" : "+itemClicked);
		WebElement link_firstItem=driver.findElement(Xpath.XpathDir.link_firstOption);
		wait.until(ExpectedConditions.elementToBeClickable(link_firstItem));
		takeScreenShotOnClick(link_firstItem);
		//link_firstItem.click();
		String MainWindow=driver.getWindowHandle();		
		Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();			
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                    driver.switchTo().window(ChildWindow);	
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    WebElement button_addtoCart=driver.findElement(Xpath.XpathDir.button_addToCart);
                    //button_addtoCart.click();
                    takeScreenShotOnClick(button_addtoCart);
                    WebElement button_gotoCart=driver.findElement(Xpath.XpathDir.button_goToCart);
                    //button_gotoCart.click();
                    takeScreenShotOnClick(button_gotoCart);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                    WebElement link_cartItem=driver.findElement(Xpath.XpathDir.link_itemInCart);
                    itemAdded = link_cartItem.getText();
                    
                    System.out.println("Description of item addded in cart"+" : "+itemAdded);
                    Assert.assertEquals(itemClicked,itemAdded);
                    WebElement button_chcekOut=driver.findElement(Xpath.XpathDir.button_checkOut);
                    //button_chcekOut.click();
                    takeScreenShotOnClick(button_chcekOut);
                    
                    WebElement button_signInchcekOut=driver.findElement(Xpath.XpathDir.button_signInCheckout);
                    //button_signInchcekOut.click();
                    takeScreenShotOnClick(button_signInchcekOut);
                    verifyErrorMessage();
                    
            }	
            
        }	
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);  
    	}
    	}
    	
  
	public void verifyErrorMessage() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement button_Continue=driver.findElement(Xpath.XpathDir.button_Continue);
		//button_Continue.click();
		takeScreenShotOnClick(button_Continue);
		WebElement text_errorMEssage=driver.findElement(Xpath.XpathDir.text_signInErrorMsg);
		String errorMessage = text_errorMEssage.getText();
		System.out.println("Error Message Displayed===>"+errorMessage);
		Assert.assertEquals(errorMessage,"Oops, that's not a match.");
	}
	//Method to Verify Error Message (Test case- 2)
	@Test
	public void verifyErrorMessageLogin() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement link_signIn=driver.findElement(Xpath.XpathDir.link_signIn);
		wait.until(ExpectedConditions.elementToBeClickable(link_signIn));
		link_signIn.click();
		verifyErrorMessage();
	}
	
	//Method to capture screen shot when ever an element is clicked.
	public void takeScreenShotOnClick(WebElement element) throws IOException
	{
		element.click();
		Date date = new Date();
		String screenshotFileName = date.toString().replace(" ", "-").replace(":", "-");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\91868\\OneDrive\\Desktop\\Eclipse\\Demo\\screenshots\\"+screenshotFileName+".png"));
	}
	
	@AfterTest
	public void quitChrome()
	{
		driver.quit();
	}
		
	}

		



