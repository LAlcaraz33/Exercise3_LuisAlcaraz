package Guru99;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.ClsReport;
import Base.ClsWebElements;

public class CheckoutPage extends ClsWebElements {


	JavascriptExecutor js = (JavascriptExecutor) objDriver;
	
	//Billing Information Xpaths
	String firstNameTxt = "Luis";
	String middleNameTxt = "Eduardo";
	String lastnameTxt = "Alcaraz";
	String companyTxt = "Agilethought";
	String emailTxt = "testexercise3@agile.com";
	String addressTxt = "Benito Juarez 92";
	String cityTxt = "Ciudad de México";
	String zipTxt = "03560";
	String phoneNumTxt = "(55) 9864 5230";
	String firstNameFld = "//input[@id = 'billing:firstname']";
	String middleNameFld = "//input[@id = 'billing:middlename']";
	String lastNameFld = "//input[@id = 'billing:lastname']";
	String companyFld = "//input[@id = 'billing:company']";
	String emailFld = "//input[@id = 'billing:email']";
	String addressFld = "//input[@id = 'billing:street1']";
	String cityFld = "//input[@id = 'billing:city']";
	String zipCodeFld = "//input[@id = 'billing:postcode']";
	String phoneNumFld = "//input[@id = 'billing:telephone']";
	String contBtn1 = "//button[@id = 'onepage-guest-register-button']";
	String orderNum = "//p[contains(text() ,'Your order')]";
	
	//Shipping Method Xpaths
	String contBtn2 = "//button[@onclick = 'billing.save()']";
	
	//Payment Information Xpahts
	String inputOrder = "//input[@id = 'p_method_checkmo']";
	String contBtn3 = "//button[@onclick = 'shippingMethod.save()']";
	String contBtn4 = "//button[@onclick = 'payment.save()']";
	
	//Place order Xpath
	String placeOrderBtn = "//button[@onclick = 'review.save();']";
	
	
	//Methods
	
	/**
	 * Fill the txt fields on the Billing Information.
	 * 
	 */
	public void billingInfo () throws InterruptedException
	{
		WaitForLoad();
		WaitForElementClickable(contBtn1);
		Click(contBtn1);
		SendKeys(firstNameFld,firstNameTxt);
		SendKeys(middleNameFld,middleNameTxt);
		SendKeys(lastNameFld,lastnameTxt);
		SendKeys(companyFld,companyTxt);
		SendKeys(emailFld,emailTxt);
		SendKeys(addressFld,addressTxt);
		SendKeys(cityFld,cityTxt);
		SendKeys(zipCodeFld,zipTxt);
		SendKeys(phoneNumFld,phoneNumTxt);
		deployableList();		
	}
	
	
	/**
	 * Complete the shipping method requirements.
	 */
	public void shippingMethod () throws InterruptedException 
	{
		WaitForLoad();
		WaitForElementClickable(contBtn2);
		Click(contBtn2);
		Thread.sleep(2500);
		js.executeScript("window.scrollBy(0,-2500)","");
	}
	
	
	/**
	 * Complete de Payment Information requirements.
	 */
	public void payInfo () throws InterruptedException
	{
		WaitForLoad();
		WaitForElementClickable(contBtn3);
		Click(contBtn3);
		Thread.sleep(1500);
		Click(inputOrder);
	}
	
	/**
	 * Place Order and Extract Order Number.
	 */
	public void placeOrder () throws InterruptedException
	{

		WaitForLoad();
		WaitForElementClickable(contBtn4);
		Click(contBtn4);
		WaitForLoad();
		Thread.sleep(1500);
		WaitForElementClickable(placeOrderBtn);
		Click(placeOrderBtn);
		WebElement objText = getWebElement(orderNum);
		String ntxt = objText.getAttribute("innerText");
		ClsReport.fnLog(Status.PASS, ntxt , false);
		Thread.sleep(1500);
	}
	
}