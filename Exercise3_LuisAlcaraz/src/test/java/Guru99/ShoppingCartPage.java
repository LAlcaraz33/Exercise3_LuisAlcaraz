package Guru99;

import Base.ClsWebElements;

public class ShoppingCartPage extends ClsWebElements {
	
	
	//Xpaths
	String proceedCheck = "//ul[@class = 'checkout-types top']";
	
	//Methods
	
	/**
	 * Check that the item was added.
	 */
	public void checkItemAdded (String itemAdded)
	{
		WaitForLoad();
		getWebElement(itemAdded);
	}
	
	/**
	 * Proceed to Checkout.
	 */
	public void proceedToCheckout ()
	{
		WaitForLoad();
		Click(proceedCheck);
	}

}
