package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	// Executimg same test script multiple times with same set of
	// data-------->innvocation count
	// Executimg same test script multiple times with different set of data---->Data
	// Provider

	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest) {
		System.out.println("Book tickets from" + src + "to" + dest);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "Bangalore";
		objArr[0][1] = "Goa";

		objArr[1][0] = "Bangalore";
		objArr[1][1] = "mysuru";

		objArr[2][0] = "Bangalore";
		objArr[2][1] = "hassan";

		return objArr;

	}

}
