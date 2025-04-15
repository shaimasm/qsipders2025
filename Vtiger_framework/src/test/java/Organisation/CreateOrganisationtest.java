package Organisation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.WebDriver_Utility;
import Generic_utilities.java_utility;
import Object_Repository.CreateOrganisationPage;
import Object_Repository.Home_page;
import Object_Repository.Login_page;
import Object_Repository.OrgLookUpImg;
import Object_Repository.OrgValidate;

public class CreateOrganisationtest extends BaseClass{
	@Test
	public static void CreateOrganisationtest() throws Throwable {


		Home_page home = new Home_page(driver);
		home.clickOrgLink();

		OrgLookUpImg lookUp = new OrgLookUpImg(driver);
		lookUp.getOrgLookUp().click();

		java_utility jlib = new java_utility();
		int ranNum = jlib.getRandomNum();

		Excel_utility elib = new Excel_utility();
		String orgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String phnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0);
		String emailId = elib.getExcelDataUsingFormatter("Organization", 2, 0);

		CreateOrganisationPage org = new CreateOrganisationPage(driver);
		org.enterOrgDetails(orgName, phnNum, emailId);
        org.clickSaveButton();

		OrgValidate validate = new OrgValidate(driver);
		validate.validateOrg(driver, orgName);
//        home.signOut();
	}


}
