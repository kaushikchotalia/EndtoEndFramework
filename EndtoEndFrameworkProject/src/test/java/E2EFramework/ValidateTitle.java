package E2EFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageOjects.LandingPage;

import resources.base;

public class ValidateTitle extends base
{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=iniilizeDriver();
		//driver.get(prop.getProperty("url"));  
		
	}
	
	@Test
	public void basePageNavigation()
	{
		driver.get(prop.getProperty("url"));  
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		
		//Compare the text from browser to the actual required text
		Assert.assertEquals(l.getTitle().getText(), "Featured Courses123");
		
	}
	
	@AfterTest
	public void driverclose()
	{
		driver.close();
	}
	
}
