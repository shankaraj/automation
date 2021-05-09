package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("[id='user_email']");
	private By password = By.cssSelector("[type='password']");
	private By login = By.cssSelector("[value='Log In']");
	private By forgotpassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	//Created constructor 
	public LoginPage (WebDriver driver)
	
	{
		this.driver=driver;
		
	}
	

	public WebElement getEmail ()
	{
		
		return driver.findElement(email);
	}
	
	
	public WebElement getPassword ()
	{
		
		return driver.findElement(password);
	}
	
	public WebElement getlogin1 ()
	{
		
		return driver.findElement(login);
	}
	
	public Forgot forgotpassword ()
	{
		
		driver.findElement(forgotpassword).click();
		Forgot F = new Forgot(driver);
		return F;
		
		
	}



	


}