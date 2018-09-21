package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory--OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a/font[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		
		return signUpBtn.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
	
		//Thread.sleep(10000); //due to thread throws exception here
		//new WebDriverWait(driver, 10000).until(ExpectedConditions.visibilityOf(loginBtn)).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
