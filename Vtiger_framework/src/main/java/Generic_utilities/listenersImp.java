package Generic_utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenersImp implements ITestListener {
	// Listener:-Listener is a feature available in TestNG which is used to capture
			// runTime events during the execution and perform appropriate action based on
			// eventType.

		public void onTestFailure(ITestResult result) {

			TakesScreenshot takesSceenShot = (TakesScreenshot) BaseClass.sdriver;

			File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
			File dst = new File("./FailedScripts.png");
			try {
				FileUtils.copyFile(src, dst);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

}
