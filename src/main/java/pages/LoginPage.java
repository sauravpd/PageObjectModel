package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login Page
 * @author saurav
 *
 */
public class LoginPage extends PageObject
{
	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = ".//*[@type='submit']")
	private WebElement submitbtn;

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	public void enterUsername(String username) 
	{
		userName.sendKeys(username);
	}

	public void enterPassword(String pwd) 
	{
		password.sendKeys(pwd);
	}

	public HomePage submit()
	{
		submitbtn.click();
		return new HomePage(driver);
	}
}
