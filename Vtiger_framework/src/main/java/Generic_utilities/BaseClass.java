package Generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Object_Repository.Home_page;
import Object_Repository.Login_page;
//push eng 1
public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void beforeSuite()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void beforeTest()
	{
		System.out.println("Parallel Exceution ");
	}
//pushback
	//pullback
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest","sanityTest"})
	public void beforeClass() throws Throwable
	{
//		File_Utility flib = new File_Utility();
//		String BROWSER = flib.getKeyAndValuePair("browser");
		
		//cmd prompt
		String BROWSER = System.getProperty("browser");
		System.out.println("launching browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		
		}
		sdriver=driver;
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"smokeTest","regressionTest","sanityTest"})
	public void beforeMethod() throws Throwable
	{
		File_utility flib = new File_utility();
        String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);

		// Business Logics
		Login_page login = new Login_page(driver);
		login.loginIntoApp(USERNAME, PASSWORD);
		System.out.println("log into application");
	}
	
	
	@AfterMethod(groups = {"smokeTest","regressionTest","sanityTest"})
	public void afterMethod()
	{
		Home_page home = new Home_page(driver);
		home.getSignOut();
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest","sanityTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	
	@AfterTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void afterTest()
	{
		System.out.println("close parallel execution");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void afterSuite()
	{
		System.out.println("Close the DataBase");
	}
}
