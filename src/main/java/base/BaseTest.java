package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Base Test
 * @author saurav
 *
 */
public class BaseTest 
{
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() 
	{
		if (driver == null) 
		{
			try 
			{
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\Config.properties");
				config.load(fis);
				log.info("Config file loaded successfully !!");

				if (config.getProperty("browser").equals("firefox")) 
				{
					driver = new FirefoxDriver();

				} 
				else if (config.getProperty("browser").equals("chrome")) 
				{
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
					log.info("Chrome Launched !!!");
				} 
				else if (config.getProperty("browser").equals("ie")) 
				{
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}

				driver.get(config.getProperty("application_url"));
				log.info("Started Application : " + config.getProperty("application_url"));
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 5);
			}

			catch(Exception e)
			{
				log.error("Exception :"+e.getMessage());
			}
		}
	}

	@AfterSuite
	public void afterSuite() 
	{
		if (driver != null)
		{
			driver.quit();
		}
	}
}
