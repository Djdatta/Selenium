package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameteraziedTest {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	
		//Data Driven Approach---used to create datat driven framework	
		//we wrote here generic method so evene n nos of data from excel 
		//Using Apache poi we can read data from excel
		Xls_Reader reader=new Xls_Reader("D:\\Selenium Practice\\Data Driven Framework\\src\\com\\testdata\\FalfEbayRegData.xlsx");
		
		int rowCount=reader.getRowCount("regData");
		
		//create col in excel sheet
		reader.addColumn("regData", "Status");
		
		//parameterization
		for(int rowNum=2; rowNum<=rowCount;rowNum++) {
		
			String firstName=reader.getCellData("regData", "firstname", rowNum);
			System.out.println(firstName);
			
			String lastName=reader.getCellData("regData", "lastname", rowNum);
			
			System.out.println(lastName);
			
			String emailAddress=reader.getCellData("regData", "emailaddress", rowNum);
			
			System.out.println(emailAddress);
			
			String password=reader.getCellData("regData", "password", rowNum);
			
			System.out.println(password);
			
		
			driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(emailAddress);
			
			driver.findElement(By.name("PASSWORD")).clear();
			driver.findElement(By.name("PASSWORD")).sendKeys(password);
			
			//Write status
			reader.setCellData("regData", "Status", rowNum, "Pass");
		}
		
		
		
		
	}
}
