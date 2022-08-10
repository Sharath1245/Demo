package bussinessMethods;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage extends CommonMethods {
//Method to Verify cart Item
public void verifyCartItem()
{
	try
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement text_searchBox=driver.findElement(uiMap.CartPage_UI_Map.input_searchBox);
	WebElement button_search=driver.findElement(uiMap.CartPage_UI_Map.button_search);
	text_searchBox.sendKeys("Mobile");
	takeScreenShotOnClick(button_search);
	WebElement link_firstItemAppeared=driver.findElement(uiMap.CartPage_UI_Map.link_itemAppeared);
	String itemClicked = link_firstItemAppeared.getText();
	System.out.println("Description of item appeared in search"+" : "+itemClicked);
	WebElement link_firstItem=driver.findElement(uiMap.CartPage_UI_Map.link_firstOption);
	wait.until(ExpectedConditions.elementToBeClickable(link_firstItem));
	takeScreenShotOnClick(link_firstItem);
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
                WebElement button_addtoCart=driver.findElement(uiMap.CartPage_UI_Map.button_addToCart);
                //button_addtoCart.click();
                takeScreenShotOnClick(button_addtoCart);
                WebElement button_gotoCart=driver.findElement(uiMap.CartPage_UI_Map.button_goToCart);
                //button_gotoCart.click();
                takeScreenShotOnClick(button_gotoCart);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                WebElement link_cartItem=driver.findElement(uiMap.CartPage_UI_Map.link_itemInCart);
                itemAdded = link_cartItem.getText();
                
                System.out.println("Description of item addded in cart"+" : "+itemAdded);
                Assert.assertEquals(itemClicked, itemAdded); 
                WebElement button_chcekOut=driver.findElement(uiMap.CartPage_UI_Map.button_checkOut);
                //button_chcekOut.click();
                takeScreenShotOnClick(button_chcekOut);
                
                WebElement button_signInchcekOut=driver.findElement(uiMap.CartPage_UI_Map.button_signInCheckout);
                //button_signInchcekOut.click();
                takeScreenShotOnClick(button_signInchcekOut); 
        }	
        
    }	
	}
	catch(Exception e)
	{
		System.out.println(e);  
	}
	}

}
