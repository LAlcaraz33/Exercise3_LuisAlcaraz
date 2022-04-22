package Guru99;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.ClsReport;
import Base.ClsWebElements;

public class LoginPage extends ClsWebElements {
	
	//Xpaths
	String accountBtn = "//a[@class = 'skip-link skip-account']";
	String loginBtn = "//a[@title = 'Log In']";
	String emailFld = "//input[@id = 'email']";
	String passwordFld = "//input[@id = 'pass']";
	String emailTxt = "testexercise13agile.com";
	String passwordTxt = "Test!13";
	String logInBtn = "//button[@id = 'send2']";
	String logoutBtn = "//a[@title = 'Log Out']";
	String userCreated = "//p[@class = 'welcome-msg']";
	
	
	
	//Methods
	
	/**
	 * Go to the Login Page.
	 */
	public void goToLogin ()
	{
		WaitForLoad();
		WaitForElementClickable(accountBtn);
		Click(accountBtn);
		WaitForElementClickable(logoutBtn);
		Click(logoutBtn);
		WaitForLoad();
		WaitForElementClickable(accountBtn);
		Click(accountBtn);
		WaitForElementClickable(loginBtn);
		Click(loginBtn);
	}
	
	
	/**
	 * Log in with the user created previously.
	 */
	public void logIn ()
	{
		WaitForLoad();
		SendKeys(emailFld,emailTxt);
		SendKeys(passwordFld,passwordTxt);
		Click(logInBtn);
		WebElement objText = getWebElement(userCreated);
		String ntxt = objText.getAttribute("innerText");
		Assert.assertEquals("WELCOME, LUIS EDUARDO ALCARAZ!", ntxt);
		ClsReport.fnLog(Status.PASS,"Accout created correctly.", false);
	}

}
