package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

public WebDriver driver;
public Properties prop;

public WebDriver initializeDriver() throws IOException 

{
	
	 prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);

	//Below is to check the in the mvn command while run time 
	//String browsername = System.getProperty("browser");
	
	//Below is to check the in the property file 
	String browsername = prop.getProperty("browser");
	
	if(browsername.equals("chromeheadless"))
		
		
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		 
	}	
	
	
if(browsername.equals("chrome"))
		
		
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		 
	}	
	
	else if (browsername.equals("firefox"))
		
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	
	else if (browsername.equals("IE"))
		
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	
	return driver;
	
}

// Method to take screenshot 

	public  String getscreenshot(String testcasename,WebDriver driver) throws IOException
	
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destination));
		return destination;
	}


}
