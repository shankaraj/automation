package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;

public class validateTitle extends base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());
	//created below for parallel execution so that same driver will not be initialized
	public WebDriver driver;
	public LandingPage l;
	
	@BeforeTest
	
	public void initialse() throws IOException
	
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
		
	}
	
	@Test //First test case
	
	public void basePageNavigation () throws IOException
	
	{
			
		 l = new LandingPage(driver);
		//Assertion for verification
		Assert.assertEquals(l.gettitle().getText(), "FEATURED1 COURSES");
		log.info("Successfully validated the home page text values");
		Assert.assertTrue(l.navigation_bar().isDisplayed());
		
		
	}
	
	@Test //Second test case
			
	public void HeaderNavigation () throws IOException
	
	{
	
		//Assertion for verification
		 l = new LandingPage(driver);
		Assert.assertEquals(l.header_bar().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated the home page header validation values");
		
	}
	
	@AfterTest 
	
	public void teardown()
	
	{
		driver.close();
		
	}
	
	
		
	}
	