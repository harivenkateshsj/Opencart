package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;




public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; //for logging
	public ResourceBundle rb; //to read config.properties
	
	@BeforeClass(groups = {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		logger = LogManager.getLogger(this.getClass()); //for logging
		rb = ResourceBundle.getBundle("config"); // to load config.properties
		
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//WebDriverManager.chromedriver().setup(); --> WebDriverManager is NOT required from Selenium updates of 2022
		
		if(br.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();//to delete all cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(rb.getString("appURL")); //get URL from config.properties file
	    driver.manage().window().maximize();
	}
	
    @AfterClass(groups={"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomNumber()
	{
		String randomNo = RandomStringUtils.randomNumeric(10);
		return randomNo;
	}
	
	public String randomString()
	{
		String randomStr = RandomStringUtils.randomAlphabetic(5);
		return randomStr;
	}
	
	public String randomAplhaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
	}
	
	public String captureScreen(String tName) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot .getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tName+"_"+ timestamp+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e)
		{
			e.getMessage();
		}
		return destination;	
	}
	
	
}
