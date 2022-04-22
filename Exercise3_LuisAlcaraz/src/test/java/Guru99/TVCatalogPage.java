package Guru99;

import Base.ClsWebElements;

public class TVCatalogPage extends ClsWebElements{
	
	
	//Xpaths 
	
	String tvHeader = "//div[@class='page-title category-title']";	
	
	
	//Methods
	
	/**
	 * Add to Cart any product.
	 */
	public void catalogPage(String addItem)
	{
		WaitForLoad();
		getWebElement(tvHeader);
		WaitForElementClickable(addItem);
		Click(addItem);
	}
	
}


