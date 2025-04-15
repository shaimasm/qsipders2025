package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUp {
	public ContactLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement lookUp;
	
	public void clickContactLookUp()
	{
		lookUp.click();
	}


}
