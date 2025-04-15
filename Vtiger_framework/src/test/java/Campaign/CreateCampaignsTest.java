package Campaign;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.WebDriver_Utility;
import Object_Repository.CampLookUpImg;
import Object_Repository.CampValidation;
import Object_Repository.CreateCampPage;
import Object_Repository.Home_page;
import Object_Repository.Login_page;
@Listeners(Generic_utilities.listenersImp.class)
public class CreateCampaignsTest extends BaseClass {

	@Test(retryAnalyzer = Generic_utilities.RetryImp.class)
	public void createCampaignsTest() throws Throwable {
		Excel_utility elib = new Excel_utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Home_page home = new Home_page(driver);
		home.clickCampLink();

		CampLookUpImg lookUp = new CampLookUpImg(driver);
		lookUp.clickCampLookUp();
		Assert.fail("im failing the script----");
		String CampName = elib.getExcelData("Campaign", 0, 0);
		System.out.println(CampName);
		

		CreateCampPage camp = new CreateCampPage(driver);
		camp.enterCampDetails(CampName);
		camp.clickSaveButton();

		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, CampName);

	}
}
