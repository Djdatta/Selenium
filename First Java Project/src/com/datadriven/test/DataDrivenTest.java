package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		

		Xls_Reader reader=new Xls_Reader("D:\\Selenium Practice\\First Java Project\\src\\com\\test\\data\\TestData.xlsx");
		
		String firstname=reader.getCellData("RegTestData", "firstname", 2);
		
		System.out.println(firstname);
		
		String lastname=reader.getCellData("RegTestData", "lastname", 2);
		
		System.out.println(lastname);
			
		String emailaddress=reader.getCellData("RegTestData", "emailaddress", 2);
		
		System.out.println(emailaddress);
		
		String password=reader.getCellData("RegTestData", "password", 2);
		
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);
		
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
		
		//driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
		
		
	}

}
