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

public class CreateCampaignWithProducttest extends BaseClass {
@Test
	public static void CreateCampaignWithProducttest() throws Throwable {

		Excel_utility elib = new Excel_utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
	    java_utility jlib = new java_utility();
	
		File_utility flib = new File_utility();
//		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

//		WebDriver driver;
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}

		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);

		Login_page login = new Login_page(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		Home_page home = new Home_page(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();

		int ranNum = jlib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

		home.clickCampLink();

		CampLookUpImg lookUpImg = new CampLookUpImg(driver);
		lookUpImg.clickCampLookUp();

		String CampName = elib.getExcelData("Campaign", 0, 0);

		System.out.println(CampName);

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);

		campPage.clickPrdPlusSign();

		wlib.windowSwitching(driver, "Products&action");

		SwitchWindowPage switching = new SwitchWindowPage(driver);
		switching.searchPrdNAme(CampName);
		switching.dynamicXpath(driver, prdName);

		Thread.sleep(2000);

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver, CampName);
		validate.validatePrd(driver, prdName);

//		home.logOut(driver);
	}
}
