package homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredential extends TestBase {

	HomePage homePage;
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredential.class.getName());

	@BeforeTest
	public void setUp() {
		init();
	}

	@Test
	public void verifyLoginWithInvalidCred() throws InterruptedException {
		log.info("====starting test");
		homePage = new HomePage(driver);
		homePage.loginToApplication("test@gmail.com", "password");

		String expected = homePage.getInvalidLoginText();
		String actual = "Authentication failed.";
		Assert.assertEquals(expected, actual);
		log.info("Finish test");

	}

	@AfterTest
	public void endTest() {
		driver.close();

	}

}
