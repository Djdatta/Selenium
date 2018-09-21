package chrome;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportDemo {

	@Test
	public void loginTest() throws IOException {
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./report/automation.html");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger=extent.createTest("LoginTest");
		
		logger.log(Status.INFO, "Login to amazon");
		
		logger.log(Status.PASS, "tITLE verified");
		
		extent.flush();
		

		ExtentTest logger1=extent.createTest("LoginTest");
		
		logger1.log(Status.INFO, "Login OFF");
		
		logger1.log(Status.FAIL, "fail");
		//add screenshot
		logger1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("‪C:\\Users\\DJadhav\\Pictures\\RS.jpg").build());
		
		extent.flush();
		
	}
	
}
