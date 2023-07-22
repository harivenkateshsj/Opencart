package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	
	@Test(groups= {"Master","Sanity"})
	public void testLogin()
	{
		logger.info("*** Starting Login Test ***");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.myAccount();
		logger.info("My Account is clicked");
		
		hp.login(); //Clicks Login Link
		logger.info("Login is clicked");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("Email Address is entered");
		
		lp.setPassword(rb.getString("password"));
		logger.info("Password is entered");
		
		lp.clickLogin();
		logger.info("Login button is clicked");
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean actualStatus = myAcc.msgInMyAccPage();
		Assert.assertEquals(actualStatus, true);
		logger.info("My Account Page is validated");
		
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("*** Finished Login Test ***");
	}
}
