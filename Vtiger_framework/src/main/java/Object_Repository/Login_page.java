package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	// element initialization
	public Login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// element declaration
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	// getter method
	@FindBy(name = "user_name")
	private WebElement UserTextField;

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;
	
	//buisnesslogics
	/**
	 * This method is used to login into application
	 * @param userName
	 * @param password
	 */
	public void loginIntoApp(String userName,String password) {
		UserTextField.sendKeys(userName);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}

}
