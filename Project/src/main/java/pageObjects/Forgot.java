package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgot {
	
	public WebDriver driver;
	
	private By email = By.cssSelector("[id='user_email']");
	private By sendme = By.cssSelector("[type='submit']");

	
	//Created constructor 
	public Forgot (WebDriver driver)
	
	{
		this.driver=driver;
		
	}
	

	public WebElement getEmail ()
	{
		
		return driver.findElement(email);
	}
	
	public WebElement sendme1 ()
	{
		
		return driver.findElement(sendme);
	}
	
			
		
	}

