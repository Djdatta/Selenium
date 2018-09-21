import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SecondTry {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\My Data\\Selenium\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		FirefoxProfile ff = new FirefoxProfile();
		ff.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		FirefoxDriver driver = new FirefoxDriver(ff);
		
		
		driver.get("http://demo.guru99.com/test/");
		
		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[3]/a"));

        //Find the date time picker control

       // WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

        //Fill date as mm/dd/yyyy as 09/25/2013

        //dateBox.sendKeys("09252013");

        //Press tab to shift focus to time field

        //dateBox.sendKeys(Keys.TAB);

        //Fill time as 02:45 PM

        //dateBox.sendKeys("0245PM");
	}
	
}
