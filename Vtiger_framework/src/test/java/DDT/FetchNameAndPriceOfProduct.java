package DDT;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchNameAndPriceOfProduct {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("bluetooth");
		driver.findElement(By.className("_2iLD__")).click();
		List<WebElement> titles = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='slAVV4']"));
		Iterator<WebElement> itr1 = titles.iterator();
		Iterator<WebElement> itr2 = prices.iterator();
		while (itr1.hasNext() && itr2.hasNext()) {
			String title = itr1.next().getText();
			String price = itr2.next().getText();
			System.out.println(title);
			System.out.println(price);
		}

	}

}
