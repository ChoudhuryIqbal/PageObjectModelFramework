package uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	public static final Logger log = Logger.getLogger(RegistrationPage.class.getName());
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath = ".//*[@id='email_create']")
	WebElement createEmail;
	@FindBy(id = "SubmitCreate")
	WebElement createAccount;

	@FindBy(xpath = ".//*[@id='id_gender1']")
	WebElement radioButtonMr;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement day;

	@FindBy(id = "months")
	WebElement month;

	@FindBy(id = "years")
	WebElement year;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "lastname")
	WebElement city;

	@FindBy(id = "postcode")
	WebElement postCode;

	@FindBy(id = "phone_mobile")
	WebElement Mobile;

	@FindBy(id = "id_state")
	WebElement selectState;

	@FindBy(id = "alias")
	WebElement alias;

	@FindBy(id = "submitAccount")
	WebElement submit;

	@FindBy(id = "firstname")
	WebElement fstName;

	@FindBy(id = "lastname")
	WebElement lstName;
	@FindBy(xpath = ".//*[@id='center_column']/h1")
	WebElement registrationMessage;

	public void registerUser(String f, String l, String e, String p) {
		signIn.click();
		createEmail.sendKeys(e);
		createAccount.click();
		log.info("Swithing to registration page-----:");

		radioButtonMr.click();
		firstName.sendKeys(f);
		lastName.sendKeys(l);
		password.sendKeys(p);
		log.info("finisht creating username and password");
		Select select = new Select(day);

		select.selectByValue("18");

		Select selMonth = new Select(month);
		selMonth.selectByValue("4");
		Select selYear = new Select(year);
		selYear.selectByIndex(10);

		log.info("Finish select statement");
		fstName.sendKeys(f);
		lstName.sendKeys(l);

		address.sendKeys("3434 kdjkdj");

		city.sendKeys("3434 kdjkdj");
		Select state = new Select(selectState);
		state.selectByIndex(0);

		log.info("Select state" + selectState.toString());
		postCode.sendKeys("10000");
		Mobile.sendKeys("12211222");
		alias.sendKeys("sss");

		submit.submit();
		log.info("submitted and object si-----:" + submit.toString());
	}

	public String getRegistrationMessage() throws InterruptedException {
		Thread.sleep(3000);
		log.info("registration message is " + registrationMessage.getText());
		return registrationMessage.getText();

	}
}
