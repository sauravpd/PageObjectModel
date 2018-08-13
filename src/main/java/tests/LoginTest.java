package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

/**
 * Login test class
 * @author saurav
 *
 */
public class LoginTest extends BaseTest
{
	public static Logger LOG=Logger.getLogger(LoginTest.class);

	@Test
	public void loginTest()
	{
		LOG.info("****loginTest****");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(config.getProperty("username"));
		loginPage.enterPassword(config.getProperty("password"));
		HomePage homePage=loginPage.submit();
		homePage.logout();
	}	
}
