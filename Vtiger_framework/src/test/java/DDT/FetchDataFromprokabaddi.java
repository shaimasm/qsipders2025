package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromprokabaddi {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
		driver.get("https://www.prokabaddi.com/standings");
		String won = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won'] ")).getText();
		System.out.println(won);
	}

}
 