package testCases;
import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.RegistrationPage;
public class AccountRegistrationTest extends BaseClass  {

	@Test(groups = {"Master","Regression"})
	public void test_account_registration()
	{
		logger.debug("application logs......");
		logger.info("*** Starting AccountRegistrationTest ***");
		try {
		HomePage bp = new HomePage(driver);
		bp.myAccount();
		logger.info("My Account is clicked");
		
		bp.register();
		logger.info("Register is clicked");
		
		
		RegistrationPage rp = new RegistrationPage(driver);
		logger.info("Providing customer information");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setTelephone(randomNumber());
		rp.setEmail(randomString() + "@yopmail.com");
		String passWrd = randomAplhaNumeric();
		rp.setPassword(passWrd);
		rp.setConfirmPassword(passWrd);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		logger.info("Clicking on continue");
		String cnfMessage = rp.getConfirmationMessage();
		logger.info("Validating expected message");
		Assert.assertEquals(cnfMessage, "Your Account Has Been Created!", "Test Failed");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*** Finished AccountRegistrationTest ***");
	}
}
