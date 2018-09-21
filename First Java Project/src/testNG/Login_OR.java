package testNG;

import org.testng.annotations.Test;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class Login_OR {
	
	public WebDriver driver;
	
	public FileInputStream fi;
	


  @Test
  public void verifyLogout() {
	  
	  System.out.println("Test case --1");
  }
  
  
  @BeforeTest
  public void beforeTest() {
  }

}
