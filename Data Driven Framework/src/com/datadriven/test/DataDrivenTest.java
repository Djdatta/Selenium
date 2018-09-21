package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		//create object of Xls_Reader class which is utility class 
		Xls_Reader reader=new Xls_Reader("D:\\Selenium Practice\\Data Driven Framework\\src\\com\\testdata\\FalfEbayRegData.xlsx");
	
		
		//Get data from excel-- 1st field sheet name 2-colum name 3-col no
		String firstName=reader.getCellData("regData", "firstname", 2);
		
		System.out.println(firstName);
		
		String lastName=reader.getCellData("regData", "lastname", 2);
		
		System.out.println(lastName);
		
		String emailAddress=reader.getCellData("regData", "emailaddress", 2);
		
		System.out.println(emailAddress);
		
		String password=reader.getCellData("regData", "password", 2);
		
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		
		
		
	}

}
