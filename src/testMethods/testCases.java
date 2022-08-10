package testMethods;
import bussinessMethods.CommonMethods;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bussinessMethods.CartPage;
import bussinessMethods.LoginPage;

public class testCases {
	CommonMethods commonMeth = new CommonMethods();
	CartPage cart = new CartPage();
	LoginPage login = new LoginPage();
	
	//Method to Verify cart Item (Test case - 1)
	@BeforeTest
	public void intitiateChrome() throws IOException
	{
	commonMeth.intitiateDriver();
	}
	
	@Test(priority = 1)
	public void verifySelectedItemIsSameinCart() throws IOException
	{
		try
		{
		cart.verifyCartItem();
	}
		catch(Exception e)
		{
			System.out.println(e);  
		}
	}
	//Method to Verify login error message (Test case - 2)
	@Test(priority = 2)
	public void verifyLoginErrorMessage() throws IOException
	{
		try
		{
		cart.verifyCartItem();
		login.verifyErrorMessage();
	}
		catch(Exception e)
		{
			System.out.println(e);  
		}
	}
	@AfterTest
	public void quitChrome() throws IOException
	{
	commonMeth.quitChrome();;
	}
}
