package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object
 * @author saurav
 *
 */
public class PageObject 
{
	protected WebDriver driver;

	public PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
