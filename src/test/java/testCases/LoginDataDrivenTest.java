package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_DTT(String email, String password, String expectedResult)
	{
		logger.info("*** Starting Login Data Driven Test ***");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.myAccount();
		hp.login();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean status = myAcc.msgInMyAccPage();
		
		if(expectedResult.equals("Valid"))
		{
			if(status == true)
			{
				myAcc.clickLogout();
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}
		else if(expectedResult.equals("Invalid"))
		{
			if(status == true)
			{
				myAcc.clickLogout();
				Assert.assertTrue(false);
			}
			else{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished Login Data Driven Test ***");
		
	}

}
