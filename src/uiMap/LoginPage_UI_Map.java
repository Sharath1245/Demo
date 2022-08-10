package uiMap;

import org.openqa.selenium.By;

public class LoginPage_UI_Map 
{
	public static By text_userName = By.name("userid");
	public static By button_Continue = By.id("signin-continue-btn");
	public static By text_Password = By.id("pass");
	public static By button_signIn = By.id("sgnBt");
	public static By link_signIn = By.xpath("(//span[contains(text(),'day!')]//a)[1]");
	public static By text_signInErrorMsg = By.xpath("//p[@id='errormsg']");
}
