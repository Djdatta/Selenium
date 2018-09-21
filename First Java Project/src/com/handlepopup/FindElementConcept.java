package com.handlepopup;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {

	//program for total nos of link/text of all link/
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://half.ebay.com");
		
		//get all links
		List<WebElement> list=driver.findElements(By.tagName("a"));
	
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
		}
		
		/*Iterator<WebElement> itr=list.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());*/
		System.out.println("All done...");
	}
	
}
