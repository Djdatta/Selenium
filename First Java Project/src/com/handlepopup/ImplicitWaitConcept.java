package com.handlepopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		//implicit wait is dynamic wait
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://half.ebay.com");
		
		//heavy sides are taking too much time to load because of any reasosn
		//suppose page load in 2 sec so it ignore 38 secs so called dynamic
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//for all the elements it wait till given time completes if object not load after finish time give error
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(20000)--- it is hard wait. it compulsary wait for 20 sec anyway..
		System.out.println("All done...");
		
		
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java");
		
		driver.findElement(By.xpath("//input[contains(@id,'gh-ac')]")).sendKeys("java");
		
		
		//dynamic id
		//id-test_123
		//id-test_345
		//ids are dynamic many time.. they changes after every refres or page load
		//with contains function we can write test_  in xpath--so it becom dynami
		//driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("java");
		//
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("java");
		
		//id=test_test_3434_test------in this case we use starts-with(@id,'')
		//id=123_test_t
		//id_123_234_test_test_t like that
		//ends-with(@id,'')	----for the  id ends with same pattern
		
		
		//For Links::::
		//All link are prepresented a tag
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();;
		
	}	
	
	
}
