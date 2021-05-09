package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.cssSelector(".text-center>h2");
	private By nav_bar = By.xpath("//a[contains(text(),'Contact')]");
	private By pop_up =By.xpath("//button[contains(text(),'NO THANKS')]");
	private By header =By.cssSelector("div[class*='video-banner'] h3");

	
	
	//Created constructor 
	public LandingPage (WebDriver driver)
	
	{
		this.driver=driver;
		
	}
	

	public LoginPage getlogin ()
	{
		
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
	
	public WebElement gettitle()
	{
		
		return driver.findElement(title);
	}
	
	public WebElement navigation_bar()
	{
		
		return driver.findElement(nav_bar);
	}

	public WebElement header_bar()
	{
		
		return driver.findElement(header);
	}

	
	
	public int popupsize ()
	{
		
		return driver.findElements(pop_up).size();
	}
	
	public WebElement popup ()
	{
		
		return driver.findElement(pop_up);
	}
	
}