package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	//Action Methods
	public void setEmail(String email)
	{
		emailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
}
