package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public TestBase() {
		
		try {
			
			prop=new Properties();
			
			FileInputStream ip=new FileInputStream("D:\\Selenium Practice\\FreeCRMTestA\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(IOException e) {
			
			e.printStackTrace();
		}
				
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
			driver=new ChromeDriver();
						
		}else if(browserName.equals("FF")) {
		
			System.setProperty("webdriver.gecko.driver", "D:\\My Data\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		wait=new WebDriverWait(driver, 12);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Values take from TestUtil class
				
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
}
