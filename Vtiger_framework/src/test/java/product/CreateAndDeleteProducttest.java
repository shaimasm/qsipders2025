package product;

import java.io.FileInputStream;
import java.util.List;
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
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_utility;
import Generic_utilities.File_utility;
import Generic_utilities.WebDriver_Utility;
import Generic_utilities.java_utility;
import Object_Repository.CreatePrdPage;
import Object_Repository.DeleteProductPge;
import Object_Repository.HomePage1;
import Object_Repository.Home_page;
import Object_Repository.Login_page;
import Object_Repository.ProductValidation;

public class CreateAndDeleteProducttest extends BaseClass {
	@Test
	public static void CreateAndDeleteProducttest()throws Throwable {

		Excel_utility elib = new Excel_utility();
		java_utility jlib = new java_utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

//		File_utility flib = new File_utility();
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
//
//		Login_page login = new Login_page(driver);
//		login.loginIntoApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Products")).click();
		HomePage1 home = new HomePage1(driver);
		home.clickPrdLink();

//		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

		home.clickLookUp();

		java_utility jib=new java_utility();
		int ranNum = jib.getRandomNum();

		String prdName = elib.getExcelData("PRODUCTS", 0, 0) + ranNum;
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);


		ProductValidation validate = new ProductValidation(driver);
		validate.validatePrd(driver, prdName);

		home.clickPrdLink();

		DeleteProductPge deleteprd=new DeleteProductPge(driver);
		deleteprd.selectPrdCheckBox(driver, prdName);
		deleteprd.clickDeletePrdButton();
	
Thread.sleep(3000);
		
		deleteprd.validatePrdDeleted(driver, prdName);
		
		
		Home_page home1=new Home_page(driver);
//		home1.signOut();
	}
}
