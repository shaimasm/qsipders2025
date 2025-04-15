package Generic_utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to implicitly wait
	 * 
	 * @param driver
	 */
	public void waitElementsToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used to switch windows
	 * 
	 * @param driver
	 * @param partial_Title
	 */
	public void windowSwitching(WebDriver driver, String partial_Title) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partial_Title)) {
				break;
			}
		}
	}

	/**
	 * THis method is used to handle the drop down element
	 * 
	 * @param ele
	 * @param value
	 */
	public void dropDown(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}

	/**
	 * This method is used to mouse over to the element
	 * @param value
	 */
	public void mouseoverToEle(WebDriver driver, WebElement value) {

		Actions act = new Actions(driver);
		act.moveToElement(value).perform();
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
}
