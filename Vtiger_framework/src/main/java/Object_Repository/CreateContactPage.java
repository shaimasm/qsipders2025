package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.WebDriver_Utility;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public void selectDropDOwnVAlue(WebDriver driver)
	{
		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.dropDown(ele, "Mrs.");
	}
	
	public void enterContactDetails(String firstname, String lastname)

	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
	}

	public void clickSaveButton()
	{
		saveButton.click();
	}


}
