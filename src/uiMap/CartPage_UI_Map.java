package uiMap;

import org.openqa.selenium.By;

public class CartPage_UI_Map {
	public static By input_searchBox = By.xpath("//label[text()='Enter your search keyword']//following-sibling::input[1]");
	public static By button_search = By.xpath("//input[@value='Search']");
	public static By link_itemAppeared = By.xpath("(//a[@class='s-item__link']//h3)[2]");
	public static By button_addToCart = By.linkText("Add to cart");
	public static By button_goToCart = By.linkText("Go to cart");
	public static By link_itemInCart = By.xpath("(//a[@data-test-id='cart-item-link']//span//span)[1]");
	public static By button_checkOut = By.xpath("//button[text()='Go to checkout']");
	public static By button_signInCheckout = By.id("signin-btn");
	public static By link_firstOption = By.xpath("(//a[@class='s-item__link'])[2]");
}
