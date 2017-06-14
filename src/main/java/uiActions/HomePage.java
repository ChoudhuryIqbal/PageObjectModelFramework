package uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver dirver;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement loginEmailAddress;
	//// a[@class='login']

	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	@FindBy(xpath = ".//*[@class='row']/div[1]/div[1]/ol/li")
	WebElement authenticationFailed;

	public void loginToApplication(String emailAddress, String password) {
		signIn.click();
		log.info("clicked on sign in and object is:-" + signIn.toString());
		// loginEmailAddress.sendKeys(emailAddress);

		log.info("entered email address:-" + emailAddress + "adn object is " + loginEmailAddress.toString());
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		submitButton.click();
		log.info("clicked on submit button" + submitButton.toString());
	}

	public String getInvalidLoginText() {
		log.info("error message is" + authenticationFailed.getText());
		return authenticationFailed.getText();
	}

}
