package E2EFramework;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageOjects.LandingPage;
import pageOjects.LoginPage;
import resources.base;

public class HomePage extends base{
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=iniilizeDriver();
		//Properties prop=new Properties();
		
	}
	
	@Test(dataProvider="getData") 
	public void basePageNavigation(String Username,String Password)
	{
		driver.get(prop.getProperty("url"));  
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		lp.submitLogin().click();
	}
	
	@AfterTest
	public void driverclose()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//columns stands for how many values you are sending per each test
		Object[][] data = new Object[2][2];
		//0th raw
		data[0][0]="test@test.com";
		data[0][1]="test123";
		//data[0][2]="Restricted User";
		//1sr row
		data[1][0]="hello@test.com";
		data[1][1]="test1234";
		//data[1][2]="Non-Restricted User";
		
		return data;
	}
}
