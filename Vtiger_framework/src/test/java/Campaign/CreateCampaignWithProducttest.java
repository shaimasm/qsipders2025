package Campaign;

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
import Object_Repository.CampLookUpImg;
import Object_Repository.CampValidation;
import Object_Repository.CreateCampPage;
import Object_Repository.CreatePrdPage;
import Object_Repository.Home_page;
import Object_Repository.Login_page;
import Object_Repository.PrdLookUpImg;
import Object_Repository.SwitchWindowPage;
//@Test(groups = "smokeTest")
public class CreateCampaignWithProducttest extends BaseClass {
@Test

public void createCampWithProductTest() throws Throwable {

	Excel_Utility elib = new Excel_Utility();
	Java_Utility jlib = new Java_Utility();
	WebDriver_Utility wlib = new WebDriver_Utility();

	HomePage home = new HomePage(driver);
	home.clickPrdLink();

	PrdLookUpImg lookUp = new PrdLookUpImg(driver);
	lookUp.clickPrdLookUp();

	int ranNum = jlib.getRandomNum();

	String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
	System.out.println(prdName);

	CreatePrdPage prdPage = new CreatePrdPage(driver);
	prdPage.enterPrdDetails(prdName);

//------------------------------------------------------------------------------------------

	home.clickCampLink();

//	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	CampLookUpImg lookUpImg = new CampLookUpImg(driver);
	lookUpImg.clickCampLookUp();

	String CampName = elib.getExcelData("Campaign", 0, 0);

	System.out.println(CampName);

	CreateCampPage campPage = new CreateCampPage(driver);
	campPage.enterCampDetails(CampName);

	campPage.clickPrdPlusSign();

	wlib.windowSwitching(driver, "Products&action");

	SwtichingWindowPage switching = new SwtichingWindowPage(driver);
	switching.searchPrdNAme(CampName);
	switching.dynamicXpath(driver, prdName);

	Thread.sleep(2000);

	// -------------------------------------------------------------------------------------------------

	wlib.windowSwitching(driver, "Campaigns&action");
	campPage.clickSaveButton();

	CampValidation validate = new CampValidation(driver);
	validate.validateCamp(driver, CampName);
	validate.validatePrd(driver, prdName);

}
}
