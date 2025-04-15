package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.WebDriver_Utility;

public class Home_page {
	// initialization
	public Home_page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// declaration
	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(linkText = "Campaigns")
	private WebElement camplink;

	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement admLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	@FindBy(linkText = "Products")
	private WebElement prdLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	// getter method
	public void setPrdLink(WebElement prdLink) {
		this.prdLink = prdLink;
	}

	public WebElement getAdmLink() {
		return admLink;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCamplink() {
		return camplink;
	}

	// buisness logic
	/**
	 * 
	 * This method is used to click campaign link
	 */
	public void clickCampLink() {
		morelink.click();
		camplink.click();
	}

	public void logOut(WebDriver driver) {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.mouseoverToEle(driver, admLink);
//		signOut.click();
	}

	public void ClickSignOutLink() {
		
		signOut.click();
	}

	public void clickPrdLink() {
		prdLink.click();
	}
	
	public void clickOrgLink()
	{
		orgLink.click();
	}
	
	public void clickContactLink()
	{
		contactLink.click();
	}

	public void clickOnAdmLink() {
	admLink.click();;
		
	}

	

}
