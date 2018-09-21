package com.datadrivettest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;

public class HalfEbayTest {

	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
	}
	
	//Get the data from getdataFromExcel method which is present in the TestUtil class
	
	//and store in the arraylist of Object array
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		
		return testData.iterator();
	}
	//using dataProvider get data from the above method
	@Test(dataProvider="getTestData")
	public void halfEbayRegTest(String firstName, String lastName, String emailAddress, String password) {
		
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		
		driver.findElement(By.name("PASSWORD")).clear();
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
