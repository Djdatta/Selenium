package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {

		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		
		loginPage=new LoginPage();
		
	}
	
	
	@Test(priority=3)
	public void loginPageTitleTest() {
		
		String title=loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "Starlink: Battle for Atlas on PS4, Xbox One, Switch | Ubisoft (US)");
	}
	
	@Test(priority=1)
	public void rememberMeTest() throws InterruptedException {
		loginPage.rememberMe();
		Assert.assertTrue(true);
	}
/*	@Test(priority=2)
	public void crmLogoImageTest() {
		
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}*/
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {	
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
