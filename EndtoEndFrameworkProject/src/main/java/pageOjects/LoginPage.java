package pageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	//Adding Constructor 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
		
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By submit = By.xpath("//input[@type='submit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement submitLogin()
	{
		return driver.findElement(submit);
	}
	
}
