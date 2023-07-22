package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locator
	@FindBy(xpath = "//span[normalize-space()='My Account']" )
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	//Action methods
	public void myAccount()
	{
		MyAccount.click();
	}
	
	public void register()
	{
		Register.click();
	}
	
	public void login()
	{
		Login.click();
	}

}
