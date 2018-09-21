package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParametrizedTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		Xls_Reader reader=new Xls_Reader("D:\\Selenium Practice\\First Java Project\\src\\com\\test\\data\\TestData.xlsx");
		
		int rowCount=reader.getRowCount("RegTestData");
		
		//Parameterization done here
		//actual data start from 2nd row..first row conatins labels
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {
			
			String firstname=reader.getCellData("RegTestData", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname=reader.getCellData("RegTestData", "lastname", rowNum);
			System.out.println(lastname);
			
			String emailaddress=reader.getCellData("RegTestData", "emailaddress", rowNum);
			System.out.println(emailaddress);
			
			String password=reader.getCellData("RegTestData", "password", rowNum);
			System.out.println(password);
			
			
			//enter data
			driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);
			
			driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
			
		}
	}
	
}
