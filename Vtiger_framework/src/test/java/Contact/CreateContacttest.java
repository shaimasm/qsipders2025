package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.WebDriver_Utility;
import Object_Repository.ContactLookUp;
import Object_Repository.ContactValidationPage;
import Object_Repository.CreateContactPage;
import Object_Repository.Home_page;
import Object_Repository.Login_page;


public class CreateContacttest extends BaseClass {
	@Test
	public static void CreateContacttest() throws Throwable {
//		File_utility flib = new File_utility();
//		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_utility elib = new Excel_utility();

		Home_page home = new Home_page(driver);
		home.clickContactLink();

		ContactLookUp lookUp = new ContactLookUp(driver);
		lookUp.clickContactLookUp();

		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDOwnVAlue(driver);

		String FirstName = elib.getExcelData("CONTACT", 0, 0);
		String LastName = elib.getExcelData("CONTACT", 1, 0);
		contactPage.enterContactDetails(FirstName, LastName);

		contactPage.clickSaveButton();

		ContactValidationPage validate = new ContactValidationPage(driver);
		validate.validateContactFirstNAme(driver, FirstName);
		validate.validateContactLastNAme(driver, LastName);

	}

}
