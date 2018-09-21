package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
//import com.starlink.pages.HomePage;

public class LoginPage extends TestBase{

	
	//Page Factory OR
	@FindBy(xpath="//a[@class='LoginView']")
	WebElement loginView;
	
	@FindBy(name="AuthEmail")
	WebElement userName;
	
	@FindBy(name="AuthPassword")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"LogInButton\"]")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[@id=\"RememberMeDiv\"]/label")
	WebElement rememberMe;
	
	/*@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement crmLogo;*/
	
	//Initailizing OR
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public void rememberMe() throws InterruptedException {
		driver.switchTo().frame(0);
		loginView.click();
		for(String subWindow:driver.getWindowHandles()) {
			
			driver.switchTo().window(subWindow);
			
		}
		Thread.sleep(10000);
		rememberMe.click();
		
	}
	/*public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
		
	}*/
	
	/*public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
	}*/
	
	public HomePage login(String un, String pw) throws InterruptedException {
		
		driver.switchTo().frame(0);
		loginView.click();
		//String parentWindow=driver.getWindowHandle();
		for(String subWindow:driver.getWindowHandles()) {
			
			driver.switchTo().window(subWindow);
			
		}
		
		//	driver.switchTo().window(parentWindow);	//to get back to parent window
		//driver.close();
		Thread.sleep(10000);
		
		userName.sendKeys(un);
		password.sendKeys(pw);
		submitBtn.click();
		return new HomePage();
	}	
}
