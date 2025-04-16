package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.WebDriver_Utility;

public class Home_page {
	//initialization
		public Home_page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Declaration
		@FindBy(linkText = "More")
		private WebElement moreLink;
		
		@FindBy(linkText = "Campaigns")
		private WebElement campLink;

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
		
		//getter methods
		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampLink() {
			return campLink;
		}
		
		/**
		 * This method is used to click campaign link
		 */
		public void clickCampLink()
		{
			moreLink.click();
			campLink.click();
		}
		
		public void logOut(WebDriver driver)
		{
			WebDriver_Utility wlib = new WebDriver_Utility();
			wlib.mouseHoverToEle(driver, admLink);
			signOut.click();
		}
		
		public void signOut()
		{
			admLink.click();
			signOut.click();
		}
		
		public void clickPrdLink()
		{
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
	}

	


