package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	public CreateCampPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campNAme;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement prdPlusSign;

	//getter method
	public WebElement getCampNAme() {
		return campNAme;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterCampDetails(String name) {
		campNAme.sendKeys(name);
		//saveButton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickPrdPlusSign() {
		prdPlusSign.click();
	}

}
