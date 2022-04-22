package Guru99;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.ClsReport;
import Base.ClsWebElements;

public class CreateUserPage extends ClsWebElements{
	
	
	//Register Xpaths
	String firstNameTxt = "Luis";
	String middleNameTxt = "Eduardo";
	String lastnameTxt = "Alcaraz";
	String emailTxt = "testexercise13@agile.com";
	String passwordTxt = "Test!13";
	String firstNameFld = "//input[@id = 'firstname']";
	String middleNameFld = "//input[@id = 'middlename']";
	String lastNameFld = "//input[@id = 'lastname']";
	String emailFld = "//input[@id = 'email_address']";
	String passwordFld = "//input[@id = 'password']";
	String confPasswordFld = "//input[@id = 'confirmation']";
	String accountBtn = "//a[@class = 'skip-link skip-account']";
	String registerBtn = "//a[text() = 'Register']";
	String createAccHead = "//div[@class = 'account-create']";
	String createUser = "//button[@title = 'Register']";
	String userCreated = "//span[contains(text() ,'Thank')]";
	
	/**
	 * Go to the Register Page.
	 */
	public void goToCreate ()
	{
		WaitForLoad();
		WaitForElementClickable(accountBtn);
		Click(accountBtn);
		WaitForElementClickable(registerBtn);
		Click(registerBtn);
	}
	
	/**
	 * Create User.
	 */
	public void createUser ()
	{
		WaitForLoad();
		SendKeys(firstNameFld,firstNameTxt);
		SendKeys(middleNameFld,middleNameTxt);
		SendKeys(lastNameFld,lastnameTxt);
		SendKeys(emailFld,emailTxt);
		SendKeys(passwordFld,passwordTxt);
		SendKeys(confPasswordFld,passwordTxt);
		Click(createUser);
		WebElement objText = getWebElement(userCreated);
		String ntxt = objText.getAttribute("innerText");
		Assert.assertEquals("Thank you for registering with Main Website Store.", ntxt);
		ClsReport.fnLog(Status.PASS,"Accout created correctly.", false);
	}
}
