package xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPath {

	
	public static void main(String[] args) throws WebDriverException{
		
			
		System.setProperty("webdriver.chrome.driver", "D:\\My Data\\Selenium\\Chrome driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver2;
		
		//driver.get("https://www.w3schools.com/howto/howto_js_display_checkbox_text.asp");
		
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.get("https://pun-attendance/dashboard.php");
		
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Username
		driver.findElement(By.xpath("//input[@type='text' and @name='txt_username']")).sendKeys("dattatray.jadhav@ubisoft.com");
		
		//Password
		driver.findElement(By.xpath("//input[@type='password' and @name='txt_password']")).sendKeys("Djdatta@1234");
		
		
		//Submit
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		
		//Select Date
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Select Month from Dropdown box
		WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		
		Select monthSelect=new Select(month);
		
		monthSelect.selectByVisibleText("Feb");
		
		
		//Select year from dropdown box
		WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		
		Select yearhSelect=new Select(year);
		
		yearhSelect.selectByVisibleText("2018");
		
		//Select day
		driver.findElement(By.xpath("//a[text()='5']")).click();
		
		//Select Date
				driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
				
				//Select Month from Dropdown box
				WebElement month1=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				
				Select monthSelect1=new Select(month1);
				
				monthSelect1.selectByVisibleText("Feb");
				
				
				//Select year from dropdown box
				WebElement year1=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				
				Select yearhSelect1=new Select(year1);
				
				yearhSelect1.selectByVisibleText("2018");
				
				//Select day
				driver.findElement(By.xpath("//a[text()='28']")).click();
				
				//Submit
				
				driver.findElement(By.xpath("//input[@type='submit' and @class='btn']")).click();
		
				driver.findElement(By.xpath("//span[text()='Show 10 rows']")).click();
				
				//select 10 rows
				
				driver.findElement(By.xpath("//a[span='10']")).click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				driver.findElement(By.xpath("//a[span='25']")).click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				driver.findElement(By.xpath("//a[span='50']")).click();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
	
				driver.findElement(By.xpath("//a[span='All']")).click();
				//driver.findElement(By.xpath("//a[@class='dt-button']")).click();	//to select All
		
				//driver.switchTo().frame("mainpanel");
				
				//driver.findElement(By.xpath("//a[@class='dt-button buttons-collection buttons-page-length' and span='Excel']")).click();
				
				
				WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"attendance-data-table_wrapper\"]/div[1]/a[2]/span")));
				WebElement element = driver.findElement(By.xpath(("//*[@id=\"attendance-data-table_wrapper\"]/div[1]/a[2]/span")));

				Actions actions = new Actions(driver);

				actions.moveToElement(element).click().build().perform();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				System.out.println("All done");
				//driver.findElement(By.xpath("//span[text()='Excel']")).click();
				
		/*		driver.findElement(By.xpath("//a[span='PDF']")).click();
				
				driver.findElement(By.xpath("//a[span='Print']")).click();*/
		
	}
}
