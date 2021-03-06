package E2EFramework;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageOjects.LandingPage;
import resources.base;

public class ValidateContactNavigation extends base
{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=iniilizeDriver();
		//Properties prop=new Properties();
		
	}
	@Test
	public void validateNavigation()
	{
		driver.get(prop.getProperty("url"));  
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		//l.getContactNavigation().isDisplayed();
		Assert.assertTrue(l.getContactNavigation().isDisplayed());
	}
	@AfterTest
	public void driverclose()
	{
		driver.close();
		driver=null;
	}
}

