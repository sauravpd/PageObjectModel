package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Home Page
 * @author saurav
 *
 */
public class HomePage extends PageObject
{	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = ".//*[@id='navigation']//a[contains(text(),'Logout')]")
	private WebElement logoutBtn;

	public void logout()
	{
		logoutBtn.click();
	}
}
