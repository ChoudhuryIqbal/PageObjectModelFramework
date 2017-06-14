package homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.RegistrationPage;

public class TC002_VerifyRegistration extends TestBase {
	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());
	RegistrationPage reg;
	String firstName = "Choudhury";
	String emailId = "iqbalchoudhury3@gmail.com";
	String passWd = "Bangladesh1";
	String lastName = "iqbal";

	@BeforeClass
	public void setUp() {
		init();
	}

	@Test
	public void testLogin() throws InterruptedException {
		reg = new RegistrationPage(driver);
		reg.registerUser(firstName, lastName, emailId, passWd);
		Assert.assertEquals("AUTHENTICATION", reg.getRegistrationMessage());
	}

	@AfterClass
	public void endTest() {
		driver.quit();
	}

}
