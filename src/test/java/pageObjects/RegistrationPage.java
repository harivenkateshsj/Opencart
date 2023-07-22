package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class RegistrationPage extends BasePage{
	
	//constructor
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locator
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg;
	
	//action methods
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void setTelephone(String tphone)
	{
		telephone.sendKeys(tphone);
	}
	
	public void setPassword(String pwd )
	{
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfPwd)
	{
		confirmPassword.sendKeys(cnfPwd);
	}
	
	public void setPrivacyPolicy()
	{
		agreeCheckbox.click();
	}
	
	public void clickContinue()
	{
		continueButton.click();
	}
	
	public String getConfirmationMessage()
	{
		try
		{
			return (msg.getText());
		}
		catch(Exception e){
		  return (e.getMessage());
		}
	}
	
}
