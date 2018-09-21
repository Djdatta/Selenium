package com.handlepopup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsPopuphandle {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
		
		Thread.sleep(2000);
		
		Set<String> handler=driver.getWindowHandles();
		
		
		Iterator<String> it=handler.iterator();
		String parentId=it.next();
		
		
		//window id is always unic
		String childWindowId=it.next();
		
		System.out.println("Child Windo--"+childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("child window pop up title--"+ driver.getTitle());
		
		driver.close();//for close specific browser window
		
		driver.switchTo().window(parentId);
		
		System.out.println("Parent Window title--"+driver.getTitle());
		
		
		
	}
}
