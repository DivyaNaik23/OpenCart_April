package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"regression","master"})
	void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		try 
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on registration link");
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		arp.setFirstName(randomeString().toUpperCase()); //randomly generated name
		arp.setLastName(randomeString().toUpperCase());
		arp.setEmail(randomeString()+"@gmail.com"); //randomly generated email
		
		String password=randomAlphaNumeric();
		arp.setPassword(password);
		
		arp.setPrivacyPolicy();
		
		arp.clickContinue();
		logger.info("Clicked on Continue");
		
		String confirmsg=arp.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confirmsg, "Your Account Has Been Created!","Not getting expected message");
	 
		}catch (Exception e) 
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	}
}
