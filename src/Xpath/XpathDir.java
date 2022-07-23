package Xpath;

import org.openqa.selenium.By;

public class XpathDir {

	public static By text_userName = By.xpath("//input[@name='userid']");
	public static By button_Continue = By.xpath("//button[@id='signin-continue-btn']");
	public static By text_Password = By.xpath("//input[@id='pass']");
	public static By button_signIn = By.xpath("//button[@id='sgnBt']");
	public static By link_signIn = By.xpath("(//span[contains(text(),'day!')]//a)[1]");
	public static By text_signInErrorMsg = By.xpath("//p[@id='errormsg']");
	public static By input_searchBox = By.xpath("//label[text()='Enter your search keyword']//following-sibling::input[1]");
	public static By button_search = By.xpath("//input[@value='Search']");
	public static By link_itemAppeared = By.xpath("(//a[@class='s-item__link']//h3)[2]");
	public static By button_addToCart = By.xpath("//a[contains(text(),'Add to cart')]");
	public static By button_goToCart = By.xpath("//span[contains(text(),'Go to cart')]");
	public static By link_itemInCart = By.xpath("(//a[@data-test-id='cart-item-link']//span//span)[1]");
	public static By button_checkOut = By.xpath("//button[text()='Go to checkout']");
	public static By button_signInCheckout = By.xpath("//button[@id='signin-btn']");
	public static By link_firstOption = By.xpath("(//a[@class='s-item__link'])[2]");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
