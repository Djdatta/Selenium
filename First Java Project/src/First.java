import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class First {


    /**
     * @param args
     * @throws WebDriverException
     */
    /**
     * @param args
     * @throws WebDriverException
     */
    /**
     * @param args
     * @throws WebDriverException
     */
    public static void main(String[] args) throws WebDriverException {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","D:\\My Data\\Selenium\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		

    	//to solve proxy problems
		FirefoxProfile ff = new FirefoxProfile();
		ff.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		FirefoxDriver driver = new FirefoxDriver(ff);
		
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        driver.manage().window().maximize();
        
        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        
        driver.findElement(By.linkText("REGISTER")).click();
        
      
        //driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
        
        driver.findElement(By.name("firstName")).sendKeys("Datta");

        driver.findElement(By.name("lastName")).sendKeys("Jadhav");
        
        driver.findElement(By.name("phone")).sendKeys("7387887799");
        
        driver.findElement(By.name("userName")).sendKeys("dmjadhav");
        
        driver.findElement(By.name("address1")).sendKeys("Kalyaninagar");
        
        driver.findElement(By.name("city")).sendKeys("Pune");
        
        driver.findElement(By.name("state")).sendKeys("maharashtra");
        
        driver.findElement(By.name("postalCode")).sendKeys("413203");
        
        Select country=new Select(driver.findElement(By.name("country")));
        
        country.selectByVisibleText("INDIA");
        
        driver.findElement(By.name("email")).sendKeys("dmjadhav");
        
        driver.findElement(By.name("password")).sendKeys("maharashtra");
        
        driver.findElement(By.name("confirmPassword")).sendKeys("maharashtra");
        
        driver.findElement(By.name("submit")).click();
        
        System.out.println("Registration completed successfuly");
        
        
        driver.findElement(By.linkText("sign-in")).click();
        
        driver.findElement(By.name("userName")).sendKeys("dmjadhav");
        
        driver.findElement(By.name("password")).sendKeys("maharastra");
        
        driver.findElement(By.name("submit")).click();
        
        
//        driver.findElement(By.name("userName")).sendKeys("datta");
//        
//        driver.findElement(By.name("password")).sendKeys("datta");
//        
//        driver.findElement(By.name("submit")).click();
        
     
        
        //driver.findElement(By.className("dropdown-toggle")).click();
        
        
       
        //close Fire fox
        //driver.close();
       
    }

}