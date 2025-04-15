package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.java_utility;

public class DataProviderEx2 {

	@Test(dataProvider = "readData")
	public void organizationModuleTest(String orgName, String phnNum, String mailId) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

	@DataProvider
	public Object[][] readData() {
		Object[][] objArr = new Object[3][3];

		java_utility jlib = new java_utility();
		int ranNum = jlib.getRandomNum();

		objArr[0][0] = "AAA" + ranNum;
		objArr[0][1] = "986454784";
		objArr[0][2] = "mailto:abc@gmail.com";

		objArr[1][0] = "BBB" + ranNum;
		objArr[1][1] = "986454784";
		objArr[1][2] = "mailto:abc@gmail.com";

		objArr[2][0] = "CCC" + ranNum;
		objArr[2][1] = "986454784";
		objArr[2][2] = "mailto:abc@gmail.com";
		return objArr;

	}

}
