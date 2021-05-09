package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Forgot;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

	public class HomePage extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	  @BeforeTest
	  
	  
	  public void initialse() throws IOException
	  
	  { driver = initializeDriver(); 
	
	  
	  }
	 
	@Test(dataProvider = "getData")

	public void basePageNavigation(String username, String passwd) throws IOException

	{
		
		driver.get(prop.getProperty("url"));

		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getlogin();		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(passwd);
		lp.getlogin1().click();
		log.info("Validated with tow sets of data successfully");
		
		Forgot F = lp.forgotpassword();
		F.getEmail().sendKeys("Test123@gmail.com");
		F.sendme1().click();

	}

	@DataProvider
	public Object[][] getData() {

		// Rows stands for how many different data should run
		// Column values stands for how many values per test
		Object[][] data = new Object[2][2];

		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "78910";

		return data;

	}

	@AfterTest

	public void teardown()

	{
		driver.close();

	}

}