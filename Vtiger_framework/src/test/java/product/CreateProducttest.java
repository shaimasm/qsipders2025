package product;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.WebDriver_Utility;
import Object_Repository.CreatePrdPage;
import Object_Repository.Home_page;
import Object_Repository.Login_page;
import Object_Repository.PrdLookUpImg;
import Object_Repository.ProductValidation;

public class CreateProducttest extends BaseClass {
@Test
	public static void CreateProducttest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_utility elib = new Excel_utility();
//		File_utility flib = new File_utility();
//
//		String BROWSER = flib.getKeyAndValuePair("browser");
//		String URL = flib.getKeyAndValuePair("url");
//		String USERNAME = flib.getKeyAndValuePair("username");
//		String PASSWORD = flib.getKeyAndValuePair("password");
//
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
//
//		wlib.maximizeWindow(driver);
//		wlib.waitElementsToLoad(driver);
//		driver.get(URL);
//
//		Login_page login = new Login_page(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		Home_page home = new Home_page(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();

		String prdName = elib.getExcelData("PRODUCTS", 0, 0);
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

		ProductValidation validate = new ProductValidation(driver);
		validate.validatePrd(driver, prdName);

//		home.logOut(driver);

		
	}

}
