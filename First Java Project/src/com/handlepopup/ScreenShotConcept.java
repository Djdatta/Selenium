package com.handlepopup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotConcept {

	public static void main(String[] args) throws IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		
		//Take screenshot and store as a file
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy to destination
		org.apache.commons.io.FileUtils.copyFile(src, new File("C:\\\\Users\\\\DJadhav\\\\Desktop\\\\Onward_durango_rt.exe_2018-7-0-22-9-23-28-836\\\\google.png"));
	
		
		System.out.println("Screenshot captured successfully....");
	}
}
