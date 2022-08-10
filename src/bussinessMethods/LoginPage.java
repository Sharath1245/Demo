package bussinessMethods;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import uiMap.LoginPage_UI_Map;

public class LoginPage extends CommonMethods{
	
	//Method to login Application
		public void login(String username, String password)
		{
			try
			{
			WebElement text_username=driver.findElement(uiMap.LoginPage_UI_Map.text_userName);
			WebElement button_Continue=driver.findElement(uiMap.LoginPage_UI_Map.button_Continue);
			WebElement text_Password=driver.findElement(uiMap.LoginPage_UI_Map.text_Password);
			WebElement button_signIn=driver.findElement(uiMap.LoginPage_UI_Map.button_signIn);
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
	
	//Verify Error message displayed while logging in.
	public void verifyErrorMessageLogin() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement link_signIn=driver.findElement(uiMap.LoginPage_UI_Map.link_signIn);
		wait.until(ExpectedConditions.elementToBeClickable(link_signIn));
		link_signIn.click();
		verifyErrorMessage();
	}
     
	public void verifyErrorMessage() throws IOException
	
	{
		try
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement button_Continue=driver.findElement(uiMap.LoginPage_UI_Map.button_Continue);
		//button_Continue.click();
		takeScreenShotOnClick(button_Continue);
		WebElement text_errorMEssage=driver.findElement(uiMap.LoginPage_UI_Map.text_signInErrorMsg);
		String errorMessage = text_errorMEssage.getText();
		System.out.println("Error Message Displayed===>"+errorMessage);
		Assert.assertEquals(errorMessage,"Oops, that's not a match.");
	}
		catch(Exception e)
		{
			System.out.println(e);  
		}
}
}