package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver iniilizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\JK\\EndtoEndFrameworkProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Training\\Udemy\\Work\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
		//Execute in FireFix Driver	
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Training\\Udemy\\Work\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			//Execute in Edge Explorer
			System.setProperty("webdriver.edge.driver","C:\\Selenium Training\\Udemy\\Work\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
