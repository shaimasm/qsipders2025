package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrdLookUpImg {
	public PrdLookUpImg(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[alt=\"Create Product...\"]")
	private WebElement prdLookUp;

	public void clickPrdLookUp() {
		prdLookUp.click();
	}

}
