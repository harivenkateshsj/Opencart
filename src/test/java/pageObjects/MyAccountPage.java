package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	@FindBy(xpath="//div[@id='content']/h2[normalize-space()='My Account']")
	WebElement cnfMsg;
	
	@FindBy(xpath="//div/a[normalize-space()='Logout']")
	WebElement logout;
	
	//Action methods
    public boolean msgInMyAccPage()
    {
    	try {
    		return (cnfMsg.isDisplayed()); //it should return true if it is displayed
    		}
    	catch(Exception e) {
    		return (false);
    	}
    }
    
    public void clickLogout()
    {
    	logout.click();
    }
	
}
