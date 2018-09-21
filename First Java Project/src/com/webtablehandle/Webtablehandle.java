package com.webtablehandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtablehandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//*[@id="customers"]/tbody/tr[7]/td[1]
		
		//break xpath--row changing here other data same
		
		String beforeXpath="*[@id=\"customers\"]/tbody/tr[";
		
		String afterXpath="/td[1]";
		
		for(int i=2; i<=7;i++) {
			
			String actulXpath=beforeXpath+i+afterXpath;
			
			String companyName=driver.findElement(By.xpath(actulXpath)).getText();
			
			System.out.println(companyName);
		}
		
	}
	
}
